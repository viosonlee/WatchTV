package lee.vioson.watchtv.utils;

import lee.vioson.watchtv.BuildConfig;

/**
 * Author:李烽
 * Date:2016-11-18
 * FIXME
 * Todo 播放地址获取
 */

public class PlayUrlUtil {
    public static String getMovieUrl(String movieId) {
        return BuildConfig.HOST + "/btmovie/MoviePlay.m3u8?movieid=" + movieId;
    }

    public static String getVideoUrlWithIndex(String vedeoId, int index) {
        return BuildConfig.HOST + "/btmovie/MoviePlay.m3u8?movieid=" + vedeoId + "&index=" + index;
    }
}
