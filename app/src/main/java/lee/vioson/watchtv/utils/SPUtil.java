package lee.vioson.watchtv.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import lee.vioson.watchtv.model.TVSource;

/**
 * Author:李烽
 * Date:2016-11-25
 * FIXME
 * Todo
 */

public class SPUtil {
    private static final String TVSOURCE = "tv_source";
    private static SharedPreferences sharedPreferences;

    private static SharedPreferences getSharedPreferences(Context context) {
        if (sharedPreferences == null)
            sharedPreferences = context.getSharedPreferences("sp", Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    public static void saveTVSource(Context c, String json) {
        getSharedPreferences(c).edit().putString(TVSOURCE, json).commit();
    }

    public static ArrayList<TVSource> getTVSource(Context c) {
        String string = getSharedPreferences(c).getString(TVSOURCE, "[]");
        ArrayList<TVSource> tvSources = JSONUtils.fromJson(string, new TypeToken<ArrayList<TVSource>>() {
        });
        return tvSources;
    }
}
