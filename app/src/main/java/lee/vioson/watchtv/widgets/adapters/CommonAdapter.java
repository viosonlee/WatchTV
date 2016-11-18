package lee.vioson.watchtv.widgets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 通用listView GridView adapter
 *
 * @author viosonlee
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    private Context context;
    private List<T> mDatas;
    private LayoutInflater inflater;
    private final int mItemLayoutId;

    public CommonAdapter(Context context, List<T> mDatas, int mItemLayoutId) {
        super();
        this.context = context;
        this.mDatas = mDatas;
        this.inflater = LayoutInflater.from(context);
        this.mItemLayoutId = mItemLayoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(convertView, parent,
                position);
        convert(viewHolder, getItem(position), position);
        return viewHolder.getconvertView();
    }


    public abstract void convert(ViewHolder helper, T item, int position);

    private ViewHolder getViewHolder(View convertView, ViewGroup parent,
                                     int position) {
        return ViewHolder.get(context, convertView, parent, mItemLayoutId,
                position);
    }
}
