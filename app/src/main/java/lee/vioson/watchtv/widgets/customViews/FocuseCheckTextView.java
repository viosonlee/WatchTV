package lee.vioson.watchtv.widgets.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.utils.ScreenUtil;

/**
 * Author:李烽
 * Date:2016-11-18
 * FIXME
 * Todo
 */

public class FocuseCheckTextView extends TextView implements View.OnFocusChangeListener {
    public static float currentTextSize;
    public static float normalTextSize;

    public FocuseCheckTextView(Context context) {
        this(context, null);
    }

    public FocuseCheckTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FocuseCheckTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnFocusChangeListener(this);
//        currentTextSize = ScreenUtil.sp2px(context,30);
//        normalTextSize = ScreenUtil.sp2px(context,25);
        currentTextSize = 23;
        normalTextSize = 20;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            ((TextView) view).setTextSize(currentTextSize);
            invalidate();
        } else {
            ((TextView) view).setTextSize(normalTextSize);
            invalidate();
        }
    }
}
