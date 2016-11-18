package lee.vioson.watchtv.UI.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.open.androidtvwidget.bridge.OpenEffectBridge;
import com.open.androidtvwidget.utils.Utils;
import com.open.androidtvwidget.view.FrameMainLayout;
import com.open.androidtvwidget.view.MainUpView;
import com.open.androidtvwidget.view.RelativeMainLayout;
import com.open.androidtvwidget.view.SmoothHorizontalScrollView;

import lee.vioson.watchtv.R;

public class MainActivity extends AppCompatActivity {

    private OpenEffectBridge mOpenEffectBridge;
    MainUpView mainUpView1;
    private View mOldFocus;
    public float getDimension(int id) {
        return getResources().getDimension(id);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmoothHorizontalScrollView hscroll_view = (SmoothHorizontalScrollView) findViewById(R.id.hscroll_view);
        hscroll_view.setFadingEdge((int)getDimension(R.dimen.w_100)); // 滚动窗口也需要适配.
        //
        /* MainUpView 设置. */
        mainUpView1 = (MainUpView) findViewById(R.id.mainUpView1);
        // mainUpView1 = new MainUpView(this); // 手动添加(test)
        // mainUpView1.attach2Window(this); // 手动添加(test)
        mOpenEffectBridge = (OpenEffectBridge) mainUpView1.getEffectBridge();
        // 4.2 绘制有问题，所以不使用绘制边框.
        // 也不支持倒影效果，绘制有问题.
        // 请大家不要按照我这样写.
        // 如果你不想放大小人超出边框(demo，张靓颖的小人)，可以不使用OpenEffectBridge.
        // 我只是测试----DEMO.(建议大家使用 NoDrawBridge)
        if (Utils.getSDKVersion() == 17) { // 测试 android 4.2版本.
            switchNoDrawBridgeVersion();
        } else { // 其它版本（android 4.3以上）.
            mainUpView1.setUpRectResource(R.drawable.test_rectangle); // 设置移动边框的图片.
//            mainUpView1.setShadowResource(R.drawable.item_shadow); // 设置移动边框的阴影.
        }
        // mainUpView1.setUpRectResource(R.drawable.item_highlight); //
        // 设置移动边框的图片.(test)
        // mainUpView1.setDrawUpRectPadding(new Rect(0, 0, 0, -26)); //
        // 设置移动边框的距离.
        // mainUpView1.setDrawShadowPadding(0); // 阴影图片设置距离.
        // mOpenEffectBridge.setTranDurAnimTime(500); // 动画时间.

        RelativeMainLayout main_lay11 = (RelativeMainLayout) findViewById(R.id.main_lay);
        main_lay11.getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(final View oldFocus, final View newFocus) {
                if (newFocus != null)
                    newFocus.bringToFront(); // 防止放大的view被压在下面. (建议使用MainLayout)
                float scale = 1.25f;
                mainUpView1.setFocusView(newFocus, mOldFocus, scale);
                mOldFocus = newFocus; // 4.3以下需要自己保存.
                // 测试是否让边框绘制在下面，还是上面. (建议不要使用此函数)
//                if (newFocus != null) {
//                    testTopDemo(newFocus, scale);
//                }
            }
        });
    }

    private void switchNoDrawBridgeVersion() {

    }
}
