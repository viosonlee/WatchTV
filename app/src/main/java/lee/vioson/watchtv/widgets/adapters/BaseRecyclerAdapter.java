package lee.vioson.watchtv.widgets.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:李烽
 * Date:2016-05-04
 * FIXME
 * Todo 通用的adapter
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {
    protected List<T> mData;
    protected Context mContext;

    protected LayoutInflater mInflater;

    public BaseRecyclerAdapter(Context context, List<T> list) {
        mData = (list != null) ? list : new ArrayList<T>();

        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerViewHolder holder
                = new RecyclerViewHolder(mContext, mInflater.inflate(getItemLayout(viewType), parent, false));
        if (onItemClickListener == null) {
            onItemClickListener = getOnItemClickListener();
        }
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
        }
        if (onItemLongClickListener == null) {
            onItemLongClickListener = getOnItemLongClickListener();
        }
        if (onItemLongClickListener != null)
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemLongClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                    return true;
                }
            });

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        bindData(holder, position, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void add(int position, T item) {
        mData.add(position, item);
        notifyItemInserted(position);
    }

    public void delete(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    protected abstract void bindData(RecyclerViewHolder holder, int position, T t);

    protected abstract int getItemLayout(int viewType);

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    protected OnItemClickListener getOnItemClickListener() {
        return null;
    }

    protected OnItemLongClickListener getOnItemLongClickListener() {
        return null;
    }

    private OnItemLongClickListener onItemLongClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }
}
