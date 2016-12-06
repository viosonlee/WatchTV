package lee.vioson.watchtv.UI.activities;

import android.content.Context;
import android.content.Intent;

import lee.vioson.watchtv.UI.fragments.OnlineTVFragment;
import lee.vioson.watchtv.model.CommonType;
import lee.vioson.watchtv.model.TVSource;
import lee.vioson.watchtv.model.pojo.homeData.Movie;

/**
 * Author:李烽
 * Date:2016-11-21
 * FIXME
 * Todo
 */

public class ActivitySwitcher {
    public static void toPlayMovie(Context context, String movie) {
        Intent intent = new Intent(context, PlayVideoActivity.class);
        intent.putExtra(PlayVideoActivity.MOVIE_DATA, movie);
        context.startActivity(intent);
    }

    @Deprecated
    public static void toOnlineTV(Context context) {
        Intent intent = new Intent(context, OnlineTVActivity.class);
        context.startActivity(intent);
    }

    public static void toCCTVOnline(Context context) {
        Intent intent = new Intent(context, OnlineTVActivity.class);
        intent.putExtra(OnlineTVActivity.TV_TYPE, TVSource.Type.cctv);
        context.startActivity(intent);
    }

    public static void toWSOnline(Context context) {
        Intent intent = new Intent(context, OnlineTVActivity.class);
        intent.putExtra(OnlineTVActivity.TV_TYPE, TVSource.Type.weishi);
        context.startActivity(intent);
    }

    public static void toOtherOnline(Context context) {
        Intent intent = new Intent(context, OnlineTVActivity.class);
        intent.putExtra(OnlineTVActivity.TV_TYPE, TVSource.Type.other);
        context.startActivity(intent);
    }

    public static void toMovieList(Context context, String typeID) {
        Intent intent = new Intent(context, MovieListActivity.class);
        intent.putExtra(MovieListActivity.ID, typeID);
        context.startActivity(intent);
    }

    public static void toFilterMovie(Context context) {
        Intent intent = new Intent(context, FilterListActivity.class);
        intent.putExtra(FilterListActivity.TYPE, CommonType.MOVIE);
        context.startActivity(intent);
    }

    public static void toFilterTV(Context context) {
        Intent intent = new Intent(context, FilterListActivity.class);
        intent.putExtra(FilterListActivity.TYPE, CommonType.TV);
        context.startActivity(intent);
    }

    public static void toFilterCarton(Context context) {
        Intent intent = new Intent(context, FilterListActivity.class);
        intent.putExtra(FilterListActivity.TYPE, CommonType.CARTON);
        context.startActivity(intent);
    }

    public static void toFilterVariety(Context context) {
        Intent intent = new Intent(context, FilterListActivity.class);
        intent.putExtra(FilterListActivity.TYPE, CommonType.VARIETY);
        context.startActivity(intent);
    }

    public static void toVideoInfo(Context context, String videoID, String img, boolean isAlbum) {
        Intent intent = new Intent(context, VideoInfoActivity.class);
        intent.putExtra(VideoInfoActivity.VIDEO_ID, videoID);
        intent.putExtra(VideoInfoActivity.VIDEO_THUMB, img);
        intent.putExtra(VideoInfoActivity.IS_ALBUM, isAlbum);
        context.startActivity(intent);
    }
}
