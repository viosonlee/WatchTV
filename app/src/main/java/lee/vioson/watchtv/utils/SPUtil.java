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
    private static final String LAST_TV_POSITION = "last_tv_position";
    private static final String CCTV_SOURCE = "cctv";
    private static final String WS_SOURCE = "weishi";
    private static final String LAST_CCTV_POSITION = "last_cctv_position";
    private static final String LAST_WS_POSITION = "last_weishi_position";
    private static SharedPreferences sharedPreferences;

    private static SharedPreferences getSharedPreferences(Context context) {
        if (sharedPreferences == null)
            sharedPreferences = context.getSharedPreferences("sp", Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    public static void saveTVSource(Context c, String json) {
        getSharedPreferences(c).edit().putString(TVSOURCE, json).apply();
    }

    public static ArrayList<TVSource> getTVSource(Context c) {
        String string = getSharedPreferences(c).getString(TVSOURCE, "[]");
        ArrayList<TVSource> tvSources = JSONUtils.fromJson(string, new TypeToken<ArrayList<TVSource>>() {
        });
        return tvSources;
    }

    public static void saveCCTVSource(Context context, String json) {
        getSharedPreferences(context).edit()
                .putString(CCTV_SOURCE, json).apply();
    }

    public static ArrayList<TVSource> getCCTVSource(Context context) {
        String json = getSharedPreferences(context).getString(CCTV_SOURCE, "[]");
        ArrayList<TVSource> tvSources = JSONUtils.fromJson(json, new TypeToken<ArrayList<TVSource>>() {
        });
        return tvSources;
    }

    public static void saveWSSource(Context context, String json) {
        getSharedPreferences(context).edit()
                .putString(WS_SOURCE, json).apply();
    }

    public static ArrayList<TVSource> getWSSource(Context context) {
        String json = getSharedPreferences(context).getString(WS_SOURCE, "[]");
        ArrayList<TVSource> tvSources = JSONUtils.fromJson(json, new TypeToken<ArrayList<TVSource>>() {
        });
        return tvSources;
    }

    public static void saveLastTVPosition(int position, Context context) {
        getSharedPreferences(context).edit()
                .putInt(LAST_TV_POSITION, position)
                .apply();
    }

    public static int getLastTVPosition(Context context) {
        return getSharedPreferences(context).getInt(LAST_TV_POSITION, 0);
    }

    public static void saveCCTVLastPosition(int position, Context context) {
        getSharedPreferences(context).edit()
                .putInt(LAST_CCTV_POSITION, position)
                .apply();
    }

    public static int getCCTVLastPosition(Context context) {
        return getSharedPreferences(context).getInt(LAST_CCTV_POSITION, 0);
    }

    public static void saveWSLastPosition(int position, Context context) {
        getSharedPreferences(context).edit()
                .putInt(LAST_WS_POSITION, position)
                .apply();
    }

    public static int getWSLastPosition(Context context) {
        return getSharedPreferences(context).getInt(LAST_WS_POSITION, 0);
    }
}
