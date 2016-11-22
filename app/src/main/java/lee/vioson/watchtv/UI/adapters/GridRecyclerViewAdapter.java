package lee.vioson.watchtv.UI.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.UI.listeners.OnMoreListClickListener;
import lee.vioson.watchtv.model.pojo.homeData.Movie;

/**
 * Author:李烽
 * Date:2016-11-22
 * FIXME
 * Todo
 */

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Movie> mData;
    private static final int ITEM_NORMAL = 000;
    private static final int ITEM_FOOTER = 001;

    public GridRecyclerViewAdapter(List<Movie> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    private Context context;

    @Override
    public int getItemViewType(int position) {
        if (getItemCount() == 0)
            return super.getItemViewType(position);
        else {
            if (position == getItemCount() - 1)
                return ITEM_FOOTER;
            else return ITEM_NORMAL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == ITEM_NORMAL) {
            view = LayoutInflater.from(context).inflate(R.layout.item_normal_content, null);
            return new ViewHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_more, null);
            return new FooterViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM_NORMAL) {
            ViewHolder holder1 = (ViewHolder) holder;
            Movie movie = mData.get(position);
            holder1.name.setText(movie.name);
            holder1.score.setText(context.getString(R.string.score) + movie.score);
            Picasso.with(context).load(movie.img).into(holder1.pic);
            holder1.itemView.setOnClickListener(view -> {
                if (onMoreListClickListener != null) {
                    onMoreListClickListener.onItemClick(position, holder1.itemView);
                }
            });
        } else {
            FooterViewHolder holder1 = (FooterViewHolder) holder;
            holder1.itemView.setOnClickListener(view -> {
                if (onMoreListClickListener != null) {
                    onMoreListClickListener.onMoreClick();
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size() + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView pic;
        private TextView name, score;

        public ViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.pic);
            name = (TextView) itemView.findViewById(R.id.name);
            score = (TextView) itemView.findViewById(R.id.score);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    private OnMoreListClickListener onMoreListClickListener;

    public void setOnMoreListClickListener(OnMoreListClickListener onMoreListClickListener) {
        this.onMoreListClickListener = onMoreListClickListener;
    }
}
