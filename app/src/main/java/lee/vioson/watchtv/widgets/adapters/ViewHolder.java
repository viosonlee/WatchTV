package lee.vioson.watchtv.widgets.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
	private SparseArray<View> mViews;
	private View convertView;


	private ViewHolder(Context context, ViewGroup parent, int layoutId,
					   int position) {
		this.mViews = new SparseArray<View>();
		convertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		// setTag
		convertView.setTag(this);
			}

	/**
	 * 拿到�?��ViewHolder对象
	 * 
	 * @param context
	 * @param convertView
	 * @param parent
	 * @param layoutId
	 * @param position
	 * @return
	 */
	public static ViewHolder get(Context context, View convertView,
								 ViewGroup parent, int layoutId, int position) {
		if (convertView == null)
			return new ViewHolder(context, parent, layoutId, position);
		else
			return (ViewHolder) convertView.getTag();

	}

	/**
	 * 通过id获取对应的控�?如果没有则找到并添加进去
	 * 
	 * @param viewId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = convertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	public View getconvertView() {
		return convertView;
	}

	/**
	 * 为TextView设置文本内容
	 * 
	 * @param viewId 控件id
	 * @param text 文本内容
	 * @return
	 */
	public ViewHolder setText(int viewId, String text) {
		TextView view = getView(viewId);
		view.setText(text);
		return this;
	}

	/**
	 * 为ImageView 设置图片
	 * 
	 * @param viewId
	 * @param drawableId
	 * @return
	 */
	public ViewHolder setImageResource(int viewId, int drawableId) {
		ImageView view = getView(viewId);
		view.setImageResource(drawableId);
		return this;
	}

	/**
	 * 为ImageView 设置图片
	 * 
	 * @param viewId
	 * @param bitmap
	 * @return
	 */
	public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
		ImageView view = getView(viewId);
		view.setImageBitmap(bitmap);
		return this;
	}
}
