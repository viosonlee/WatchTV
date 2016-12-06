package lee.vioson.watchtv.UI.activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.model.TVSource;
import lee.vioson.watchtv.utils.ScreenUtil;
import lee.vioson.watchtv.utils.TVSourceHelper;
import lee.vioson.watchtv.widgets.customViews.MyVideoView;
import lee.vioson.watchtv.widgets.customViews.ProgressWheel;

public class OnlineTVActivity extends Activity {
    private static final String URL = "url";
    private static final int CHECK_STATE = 001;
    public static final String TV_TYPE = "tv_type";
    private MyVideoView videoView;
    private ProgressWheel progressWheel;
    private String url;//当前的电视台url
    private int savePosition;
    private CheckStateHandler handler;
    private Runnable runnable;
    private int old_duration;
    private ArrayList<TVSource> mDatas = new ArrayList<>();
    private int currentIndex = 0;//当前频道

    private TextView tvName, time;
    private View tvInfo;

    private TVSource.Type type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_tv);
        type = (TVSource.Type) getIntent().getSerializableExtra(TV_TYPE);
        mDatas = TVSourceHelper.getTvSourceByType(type);
        currentIndex = TVSourceHelper.getLastPositionByType(type);
        initView();
        setStateListener();
    }


    private void initView() {
        tvInfo = findViewById(R.id.tv_info);
        tvName = (TextView) findViewById(R.id.tv_name);
        time = (TextView) findViewById(R.id.time);
        progressWheel = (ProgressWheel) findViewById(R.id.progress_wheel);
        videoView = (MyVideoView) findViewById(R.id.video_view);
        tvInfoShow();
        url = mDatas.get(currentIndex).url;
        if (url != null) {
            videoView.setVideoPath(url);
            Log.d(getClass().getSimpleName(), url);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.FILL_PARENT,
                    RelativeLayout.LayoutParams.FILL_PARENT);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            videoView.setLayoutParams(layoutParams);
            videoView.start();
            progressWheel.postDelayed(() -> progressWheel.setVisibility(View.VISIBLE), 50);
            videoView.requestFocus();
            videoView.setOnPreparedListener(mediaPlayer -> {
                progressWheel.setVisibility(View.GONE);
                tvInfo.postDelayed(() -> tvInfo.setVisibility(View.GONE), 5000);
                mediaPlayer.setOnVideoSizeChangedListener((mediaPlayer1, i, i1) -> fixVideoSize(mediaPlayer));
            });
            //错误信息处理
            videoView.setOnErrorListener((mediaPlayer, what, extra) -> {
                if (what == MediaPlayer.MEDIA_ERROR_SERVER_DIED) {
                    Log.v(getClass().getSimpleName(), "Media Error,Server Died" + extra);
                    Toast.makeText(this, "Media Error,Server Died" + extra, Toast.LENGTH_SHORT).show();
                } else if (what == MediaPlayer.MEDIA_ERROR_UNKNOWN) {
                    Log.v(getClass().getSimpleName(), "Media Error,Error Unknown " + extra);
                    Toast.makeText(this, "Media Error,Error Unknown " + extra, Toast.LENGTH_SHORT).show();
                }
                return true;
            });
            if (Build.VERSION.SDK_INT >= 17) {
                videoView.setOnInfoListener((mediaPlayer, i, i1) -> {
                    Log.i(getClass().getSimpleName(), "i--" + i + "i1--" + i1);
                    mediaPlayer.setOnVideoSizeChangedListener((mediaPlayer1, j, j1) -> fixVideoSize(mediaPlayer));
                    return false;
                });
            }
        }
    }

    private void fixVideoSize(MediaPlayer mediaPlayer) {
        double videoWidth = mediaPlayer.getVideoWidth();
        double videoHeight = mediaPlayer.getVideoHeight();
        if (videoWidth > 0 && videoHeight > 0) {
            double scale = videoHeight / videoWidth;//视频比例
            double screenScale = (double) ScreenUtil.getScreenHeight(OnlineTVActivity.this)
                    / (double) ScreenUtil.getScreenWidth(OnlineTVActivity.this);
            if (scale < screenScale) {
                //以width为准
                videoWidth = ScreenUtil.getScreenWidth(OnlineTVActivity.this);
                videoHeight = videoWidth * scale;
            } else {
                //以height为准
                videoHeight = ScreenUtil.getScreenHeight(OnlineTVActivity.this);
                videoWidth = videoHeight / scale;
            }
            videoView.getHolder().setFixedSize((int) videoWidth, (int) videoHeight);
            videoView.setMeasure((int) videoWidth, (int) videoHeight);
            videoView.requestLayout();
        }
    }

    long now = 0;

    private void tvInfoShow() {
        tvName.setText((currentIndex + 1) + mDatas.get(currentIndex).title);
        time.setText(getNow());
        if (tvInfo.getVisibility() == View.GONE) {
            tvInfo.setVisibility(View.VISIBLE);
        }
    }

    private String getNow() {
        long millis = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return format.format(millis);
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - now <= 2000)
            finish();
        else {
            now = System.currentTimeMillis();
            Toast.makeText(this, R.string.two_click_exit, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TVSourceHelper.saveLastPositionByType(type, currentIndex);
    }

    @Override
    protected void onStop() {
        videoView.stopPlayback();
        super.onStop();
    }

    @Override
    protected void onPause() {
        savePosition = videoView.getCurrentPosition();
        if (videoView.canPause())
            videoView.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        videoView.start();
        videoView.seekTo(savePosition);
        savePosition = 0;
        super.onResume();
    }


    private void setStateListener() {
        handler = new CheckStateHandler();
        runnable = () -> {
            int duration = videoView.getCurrentPosition();
            if (old_duration == duration && videoView.isPlaying()) {
                progressWheel.setVisibility(View.VISIBLE);
            } else {
                progressWheel.setVisibility(View.GONE);
            }
            old_duration = duration;

            handler.sendEmptyMessage(CHECK_STATE);
        };
        handler.postDelayed(runnable, 0);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (currentIndex == 0) {
                currentIndex = mDatas.size() - 1;
            } else currentIndex--;
            refresh();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (currentIndex == mDatas.size() - 1) {
                currentIndex = 0;
            } else currentIndex++;
            refresh();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void refresh() {
        tvInfoShow();
        progressWheel.setVisibility(View.VISIBLE);
        videoView.stopPlayback();
        videoView.setVideoPath(mDatas.get(currentIndex).url);
        videoView.start();
    }

    class CheckStateHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == CHECK_STATE)
                handler.postDelayed(runnable, 200);
        }
    }
}
