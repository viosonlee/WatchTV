package lee.vioson.watchtv.UI.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.model.pojo.homeData.Movie;
import lee.vioson.watchtv.utils.PlayUrlUtil;

/**
 * Author:李烽
 * Date:2016-11-21
 * FIXME
 * Todo 播放视频
 */

public class PlayVideoActivity extends Activity {
    public static final String MOVIE_DATA = "movie_data";
    private VideoView videoView;
    private Movie movie;
    //    private EditText et;
    private ProgressDialog dialog;
    private int savePosition;//保存进度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        initMovie();
        initView();
    }

    private void initMovie() {
        if (getIntent() != null) {
            movie = (Movie) getIntent().getSerializableExtra(MOVIE_DATA);
        }
    }

    private void initView() {
        dialog = new ProgressDialog(this);
        dialog.show();
        videoView = (VideoView) findViewById(R.id.video_view);
//        et = (EditText) findViewById(R.id.et);
        if (movie != null) {
            String movieUrl = PlayUrlUtil.getMovieUrl(movie.movieId + "");
//            et.setText(movieUrl);
            videoView.setVideoPath(movieUrl);
            Log.d(getClass().getSimpleName(), movieUrl);
            videoView.setMediaController(new MediaController(this));

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.FILL_PARENT,
                    RelativeLayout.LayoutParams.FILL_PARENT);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            videoView.setLayoutParams(layoutParams);
            videoView.start();
            videoView.requestFocus();
            videoView.setOnPreparedListener(mediaPlayer -> {
                dialog.dismiss();
            });
            //错误信息处理
            videoView.setOnErrorListener((mediaPlayer, what, extra) -> {
                if (what == MediaPlayer.MEDIA_ERROR_SERVER_DIED) {
                    Log.v(getClass().getSimpleName(), "Media Error,Server Died" + extra);
                } else if (what == MediaPlayer.MEDIA_ERROR_UNKNOWN) {
                    Log.v(getClass().getSimpleName(), "Media Error,Error Unknown " + extra);
                }
                return true;
            });
            videoView.setOnCompletionListener(mediaPlayer -> {
                Toast.makeText(this, "播放完成", Toast.LENGTH_SHORT).show();
            });
        }
    }


    long now = 0;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - now <= 1000)
            finish();
        else {
            now = System.currentTimeMillis();
            Toast.makeText(this, R.string.two_click_exit, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 设置系统音量
     *
     * @param volumeUp
     */
    private void setVoiceVolume(boolean volumeUp) {
        AudioManager mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //  设置音量绝对值的话,我在小米上突破不了限制,最大音量15,但是设置到10的时候就没法再增加了,最后使用系统的音量控制才可以
//        int currentVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
//        int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//        int flag = volumeUp ? 1 : -1;
//        currentVolume += flag * 1;
//        if (currentVolume >= maxVolume) {
//            currentVolume = maxVolume;
//        } else if (currentVolume <= 1) {
//            currentVolume = 1;
//        }
//        Log.i(getClass().getSimpleName(), "setVoiceVolume currentVolume = " + currentVolume + " ,maxVolume = " + maxVolume);
//        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, 0);

        if (volumeUp) {
            //增加音量，调出系统音量控制
            mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE,
                    AudioManager.FX_FOCUS_NAVIGATION_UP);
        } else {
            //降低音量，调出系统音量控制
            mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER,
                    AudioManager.FX_FOCUS_NAVIGATION_UP);
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
                    setVoiceVolume(true);
                    return true;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_DOWN");
                    setVoiceVolume(false);
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
}
