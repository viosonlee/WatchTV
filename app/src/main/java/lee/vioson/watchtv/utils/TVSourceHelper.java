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
    public static void initTVSource() {
        /////////////////////////////OTHER/////////////////////////////
        if (SPUtil.getTVSource(MyApplication.getContext()).isEmpty()) {
            String tVSource = MyApplication.getContext().getString(R.string.tv_source);
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
        /////////////////////////////CCTV//////////////////////////////
        if (SPUtil.getCCTVSource(MyApplication.getContext()).isEmpty()) {
            String cctv = MyApplication.getContext().getString(R.string.tv_source_cctv);
            ArrayList<TVSource> tvSources = new ArrayList<>();
            String[] split = cctv.split("-");
            for (String s : split) {
                try {
                    String[] split1 = s.split(",");
                    if (split1.length >= 2) {
                        TVSource tvSource =
                                new TVSource(split1[0].trim(), split1[1].trim(), TVSource.Type.cctv);
                        tvSources.add(tvSource);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String json = JSONUtils.toJson(tvSources);
            SPUtil.saveCCTVSource(MyApplication.getContext(), json);
        }
        /////////////////////////WEISHI////////////////////////////////
        if (SPUtil.getWSSource(MyApplication.getContext()).isEmpty()) {
            String ws = MyApplication.getContext().getString(R.string.tv_source_weishi);
            ArrayList<TVSource> tvSources = new ArrayList<>();
            String[] split = ws.split("-");
            for (String s : split) {
                try {
                    String[] split1 = s.split(",");
                    if (split1.length >= 2) {
                        TVSource tvSource =
                                new TVSource(split1[0].trim(), split1[1].trim(), TVSource.Type.weishi);
                        tvSources.add(tvSource);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String json = JSONUtils.toJson(tvSources);
            SPUtil.saveWSSource(MyApplication.getContext(), json);
        }
    }

    public static ArrayList<TVSource> getTvSourceByType(TVSource.Type type) {
        ArrayList<TVSource> arrayList = new ArrayList<>();
        if (type != null) {
            if (type == TVSource.Type.cctv) {
                arrayList = SPUtil.getCCTVSource(MyApplication.getContext());
            } else if (type == TVSource.Type.weishi)
                arrayList = SPUtil.getWSSource(MyApplication.getContext());
            else if (type == TVSource.Type.other)
                arrayList = SPUtil.getTVSource(MyApplication.getContext());
            else {
                arrayList.addAll(SPUtil.getCCTVSource(MyApplication.getContext()));
                arrayList.addAll(SPUtil.getWSSource(MyApplication.getContext()));
                arrayList.addAll(SPUtil.getTVSource(MyApplication.getContext()));
            }
        } else {
            arrayList.addAll(SPUtil.getCCTVSource(MyApplication.getContext()));
            arrayList.addAll(SPUtil.getWSSource(MyApplication.getContext()));
            arrayList.addAll(SPUtil.getTVSource(MyApplication.getContext()));
        }
        return arrayList;
    }

    public static int getLastPositionByType(TVSource.Type type) {
        if (type != null) {
            if (type == TVSource.Type.cctv)
                return SPUtil.getCCTVLastPosition(MyApplication.getContext());
            else if (type == TVSource.Type.weishi)
                return SPUtil.getWSLastPosition(MyApplication.getContext());
            else if (type == TVSource.Type.other)
                return SPUtil.getLastTVPosition(MyApplication.getContext());
        }
        return 0;
    }

    public static void saveLastPositionByType(TVSource.Type type, int index) {
        if (type != null) {
            if (type == TVSource.Type.cctv)
                SPUtil.saveCCTVLastPosition(index, MyApplication.getContext());
            else if (type == TVSource.Type.weishi)
                SPUtil.saveWSLastPosition(index, MyApplication.getContext());
            else if (type == TVSource.Type.other)
                SPUtil.saveLastTVPosition(index, MyApplication.getContext());
        }
    }
}
