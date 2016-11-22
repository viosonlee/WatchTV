package lee.vioson.watchtv.UI.listeners;

import android.view.View;

import com.open.androidtvwidget.bridge.RecyclerViewBridge;
import com.open.androidtvwidget.leanback.recycle.RecyclerViewTV;

/**
 * Author:李烽
 * Date:2016-11-22
 * FIXME
 * Todo
 */

public class MyOnItemListener implements RecyclerViewTV.OnItemListener {
    public MyOnItemListener(RecyclerViewBridge recyclerViewBridge) {
        this.recyclerViewBridge = recyclerViewBridge;
    }

    private RecyclerViewBridge recyclerViewBridge;

    public MyOnItemListener(RecyclerViewBridge recyclerViewBridge, float scale) {
        this.recyclerViewBridge = recyclerViewBridge;
        this.scale = scale;
    }

    private float scale = 1.2f;

    @Override
    public void onItemPreSelected(RecyclerViewTV parent, View itemView, int position) {
        recyclerViewBridge.setUnFocusView(itemView);
    }

    @Override
    public void onItemSelected(RecyclerViewTV parent, View itemView, int position) {
        recyclerViewBridge.setFocusView(itemView, scale);
    }

    @Override
    public void onReviseFocusFollow(RecyclerViewTV parent, View itemView, int position) {
        recyclerViewBridge.setFocusView(itemView, scale);
    }
}
