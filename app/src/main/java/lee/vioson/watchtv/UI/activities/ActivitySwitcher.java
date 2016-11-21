package lee.vioson.watchtv.UI.activities;

import android.content.Context;
import android.content.Intent;

import lee.vioson.watchtv.model.pojo.homeData.Movie;

/**
 * Author:李烽
 * Date:2016-11-21
 * FIXME
 * Todo
 */

public class ActivitySwitcher {
    public static void toPlayMovie(Context context, Movie movie) {
        Intent intent = new Intent(context, PlayVideoActivity.class);
        intent.putExtra(PlayVideoActivity.MOVIE_DATA, movie);
        context.startActivity(intent);
    }
}
