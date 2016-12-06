package lee.vioson.watchtv.widgets.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

import lee.vioson.watchtv.utils.ScreenUtil;

/**
 * Author:李烽
 * Date:2016-12-06
 * FIXME
 * Todo
 */

public class MyVideoView extends VideoView {
    private int mVideoWidth;
    private int mVideoHeight;

    public MyVideoView(Context context) {
        this(context, null);
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mVideoHeight = ScreenUtil.getScreenHeight(context);
        mVideoWidth = ScreenUtil.getScreenWidth(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(mVideoWidth, widthMeasureSpec);
        int height = getDefaultSize(mVideoHeight, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    public void setMeasure(int videoWidth, int videoHeight) {
        mVideoWidth = videoWidth;
        mVideoHeight = videoHeight;
        invalidate();
    }
}
