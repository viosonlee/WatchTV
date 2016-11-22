package lee.vioson.watchtv.UI.listeners;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Author:李烽
 * Date:2016-09-02
 * FIXME
 * Todo 上拉加载更多
 */
public abstract class UpLoadListener extends RecyclerView.OnScrollListener {
    private LinearLayoutManager layoutManager;
    private int childCount;
    private int itemCount;
    private int firstVisibleItemPosition;

    public UpLoadListener(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }


    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        childCount = recyclerView.getChildCount();//显示的数量
        itemCount = layoutManager.getItemCount();//总数量
        firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
      Log.i(getClass().getSimpleName(), "newState:" + newState +
                "\nchildCount:" + childCount + "\nitemCount:" + itemCount +
                "\nfirstVisibleItemPosition:" + firstVisibleItemPosition);
        if (newState == RecyclerView.SCROLL_STATE_IDLE && ((itemCount - childCount) <= firstVisibleItemPosition)) {
            onLoadMore();
        }
    }

    protected abstract void onLoadMore();
}
