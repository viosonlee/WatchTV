package lee.vioson.watchtv.widgets;

import java.lang.reflect.Field;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import lee.vioson.watchtv.R;

public class MediaController extends android.widget.MediaController {

    private Activity mActivity;

    private View mView;

    public MediaController(Activity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    public void setAnchorView(View view) {
        super.setAnchorView(view);
        mView = LayoutInflater.from(getContext()).inflate(
                R.layout.video_button, null);
        try {
            SeekBar sb = (SeekBar) LayoutInflater.from(getContext()).inflate(
                    R.layout.video_seekbar, null);
            Field mRoot = android.widget.MediaController.class
                    .getDeclaredField("mRoot");
            mRoot.setAccessible(true);
            ViewGroup mRootVg = (ViewGroup) mRoot.get(this);
            mRootVg.setFocusableInTouchMode(false);
            mRootVg.setFocusable(false);
            mRootVg.clearFocus();
            ViewGroup vg = findSeekBarParent(mRootVg);
            vg.setFocusable(false);
            vg.setFocusableInTouchMode(false);
            vg.clearFocus();
            int index = 1;
            for (int i = 0; i < vg.getChildCount(); i++) {
                if (vg.getChildAt(i) instanceof SeekBar) {
                    index = i;
                    break;
                }
            }
            vg.removeViewAt(index);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.weight = 1;
            vg.addView(sb, index, params);
            Field mProgress = android.widget.MediaController.class
                    .getDeclaredField("mProgress");
            mProgress.setAccessible(true);
            mProgress.set(this, sb);
            Field mSeekListener = android.widget.MediaController.class
                    .getDeclaredField("mSeekListener");
            mSeekListener.setAccessible(true);
            sb.setOnSeekBarChangeListener((OnSeekBarChangeListener) mSeekListener
                    .get(this));
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ViewGroup findSeekBarParent(ViewGroup vg) {
        ViewGroup viewGroup = null;
        for (int i = 0; i < vg.getChildCount(); i++) {
            View view = vg.getChildAt(i);
            if (view instanceof SeekBar) {
                viewGroup = (ViewGroup) view.getParent();
                break;
            } else if (view instanceof ViewGroup) {
                viewGroup = findSeekBarParent((ViewGroup) view);
            } else {
                continue;
            }
        }
        return viewGroup;
    }

    @Override
    public void show(int timeout) {
        super.show(timeout);
        ((ViewGroup) mActivity.findViewById(android.R.id.content))
                .removeView(mView);
        ((ViewGroup) mActivity.findViewById(android.R.id.content))
                .addView(mView);
    }

    @Override
    public void hide() {
        super.hide();
        ((ViewGroup) mActivity.findViewById(android.R.id.content))
                .removeView(mView);
    }

}
