package lee.vioson.watchtv.UI.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.UI.listeners.OnMoreListClickListener;
import lee.vioson.watchtv.model.pojo.homeData.Movie;

/**
 * Author:李烽
 * Date:2016-11-21
 * FIXME
 * Todo
 */

public class ContentGridViewAdapter extends BaseAdapter {
    private List<Movie> mData;
    private Context context;

    public ContentGridViewAdapter(List<Movie> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size() + 1;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (i == getCount() - 1) {
            view = LayoutInflater.from(context).inflate(R.layout.item_more, null);
            view.setOnClickListener(view1 -> {
                if (onMoreListClickListener != null) {
                    onMoreListClickListener.onMoreClick();
                }
            });
        } else {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.item_normal_content, null);
                holder = new ViewHolder();
                holder.name = (TextView) view.findViewById(R.id.name);
                holder.scroe = (TextView) view.findViewById(R.id.score);
                holder.pic = (ImageView) view.findViewById(R.id.pic);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.name.setText(mData.get(i).name);
            holder.scroe.setText(context.getString(R.string.score) + mData.get(i).score);
            Picasso.with(context).load(mData.get(i).img).into(holder.pic);
            View finalView = view;
            view.setOnClickListener(view1 -> {
                if (onMoreListClickListener != null) {
                    onMoreListClickListener.onItemClick(i, finalView);
                }
            });
        }
        return view;
    }

    public class ViewHolder {
        private TextView name, scroe;
        private ImageView pic;
    }

    public void setOnMoreListClickListener(OnMoreListClickListener onMoreListClickListener) {
        this.onMoreListClickListener = onMoreListClickListener;
    }

    private OnMoreListClickListener onMoreListClickListener;


}
