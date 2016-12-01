package lee.vioson.watchtv.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import lee.vioson.watchtv.MyApplication;
import lee.vioson.watchtv.R;
import lee.vioson.watchtv.model.TVSource;

/**
 * Author:李烽
 * Date:2016-11-25
 * FIXME
 * Todo
 */

public class TVSourceHelper {
    private static String tVSource;

    public static void initTVSource() {
        tVSource = MyApplication.getContext().getString(R.string.tv_source);
        if (SPUtil.getTVSource(MyApplication.getContext()).isEmpty()) {
            ArrayList<TVSource> tvSources = new ArrayList<>();
            String[] split = tVSource.split("-");
            for (String s : split) {
                try {
                    String[] split1 = s.split(",");
                    if (split1.length >= 2) {
                        TVSource tvSource = new TVSource(split1[0].trim(), split1[1].trim());
                        tvSources.add(tvSource);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String json = JSONUtils.toJson(tvSources);
            SPUtil.saveTVSource(MyApplication.getContext(), json);
        }
    }
}
