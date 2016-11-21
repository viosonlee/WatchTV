package lee.vioson.watchtv.utils;

import android.content.Context;
import android.media.AudioManager;

/**
 * Author:李烽
 * Date:2016-11-21
 * FIXME
 * Todo
 */

public class AudioUtil {
    public static void setVoiceVolume(Context context, boolean volumeUp) {
        AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
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
}
