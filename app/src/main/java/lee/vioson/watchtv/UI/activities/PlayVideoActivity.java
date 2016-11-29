package lee.vioson.watchtv.UI.activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.utils.AudioUtil;
import lee.vioson.watchtv.widgets.MediaController;
import lee.vioson.watchtv.widgets.customViews.ProgressWheel;

/**
 * Author:李烽
 * Date:2016-11-21
 * FIXME
 * Todo 播放视频
 */

public class PlayVideoActivity extends Activity {
    public static final String MOVIE_DATA = "movie_data";
    private static final int CHECK_STATE = 00;
    private VideoView videoView;
    //    private Movie movie;
    private int savePosition;//保存进度
    private ProgressWheel progressWheel;
    private int old_duration = 0;
    private Runnable runnable;
    private CheckStateHandler handler;

    private String movieUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        initMovie();
        initView();
        setStateListener();
    }

    private void initMovie() {
        if (getIntent() != null) {
            movieUrl = getIntent().getStringExtra(MOVIE_DATA);
        }
    }

    private void initView() {
        progressWheel = (ProgressWheel) findViewById(R.id.progress_wheel);
        videoView = (VideoView) findViewById(R.id.video_view);
        if (!TextUtils.isEmpty(movieUrl)) {
//            String movieUrl = PlayUrlUtil.getMovieUrl(movie.movieId + "");
            videoView.setVideoPath(movieUrl);
            Log.d(getClass().getSimpleName(), movieUrl);
            MediaController controller = new MediaController(this);
            videoView.setMediaController(controller);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.FILL_PARENT,
                    RelativeLayout.LayoutParams.FILL_PARENT);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            videoView.setLayoutParams(layoutParams);
            videoView.start();
            progressWheel.postDelayed(() -> progressWheel.setVisibility(View.VISIBLE), 50);
            videoView.requestFocus();
            videoView.setOnPreparedListener(mediaPlayer -> progressWheel.setVisibility(View.GONE));
            //错误信息处理
            videoView.setOnErrorListener((mediaPlayer, what, extra) -> {
                if (what == MediaPlayer.MEDIA_ERROR_SERVER_DIED) {
                    Log.e(getClass().getSimpleName(), "Media Error,Server Died" + extra);
                } else if (what == MediaPlayer.MEDIA_ERROR_UNKNOWN) {
                    Log.e(getClass().getSimpleName(), "Media Error,Error Unknown " + extra);
                }
                return true;
            });
            videoView.setOnCompletionListener(mediaPlayer -> {
                Toast.makeText(PlayVideoActivity.this, "播放完成", Toast.LENGTH_SHORT).show();
            });
            if (Build.VERSION.SDK_INT >= 17) {
                videoView.setOnInfoListener((mediaPlayer, i, i1) -> {
                    Log.i(getClass().getSimpleName(), "i--" + i + "i1--" + i1);
                    return false;
                });
            }

        }

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

    long now = 0;

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void toggle() {
        boolean playing = videoView.isPlaying();
        if (playing)
            videoView.pause();
        else videoView.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_CENTER:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_CENTER");
                    toggle();
                    break;
                case KeyEvent.KEYCODE_ENTER:
                    Log.i(getClass().getSimpleName(), "KEYCODE_ENTER");
                    toggle();
                    break;
                case KeyEvent.KEYCODE_DPAD_UP:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_UP");
                    AudioUtil.setVoiceVolume(this, true);
                    return true;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_DOWN");
                    AudioUtil.setVoiceVolume(this, false);
                    return true;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_LEFT");
                    seekToBack();
                    return true;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_RIGHT");
                    seekToAword();
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void seekToAword() {
        int currentPosition = videoView.getCurrentPosition();
        currentPosition += 2;
        videoView.seekTo(currentPosition);
    }

    private void seekToBack() {
        int currentPosition = videoView.getCurrentPosition();
        currentPosition -= 2;
        videoView.seekTo(currentPosition);
    }

    class CheckStateHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == CHECK_STATE)
                handler.postDelayed(runnable, 200);
        }
    }
}
