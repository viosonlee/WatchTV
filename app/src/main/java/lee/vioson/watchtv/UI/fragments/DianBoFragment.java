package lee.vioson.watchtv.UI.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import com.open.androidtvwidget.bridge.EffectNoDrawBridge;
import com.open.androidtvwidget.bridge.RecyclerViewBridge;
import com.open.androidtvwidget.view.MainUpView;
import com.open.androidtvwidget.view.RelativeMainLayout;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.UI.activities.ActivitySwitcher;

/**
 * Author:李烽
 * Date:2016-11-23
 * FIXME
 * Todo 点播
 */

public class DianBoFragment extends BaseFragment implements View.OnClickListener {
    private android.widget.LinearLayout movie;
    private android.widget.LinearLayout tv;
    private android.widget.LinearLayout carton;
    private android.widget.LinearLayout variety;
    private com.open.androidtvwidget.view.MainUpView mainUpView1;
    private EffectNoDrawBridge noDrawBridge;
    private TableLayout parent;
    private View oldFocusView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_db, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initEvent();
    }


    public static DianBoFragment newInstance() {

        Bundle args = new Bundle();

        DianBoFragment fragment = new DianBoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void initView(View view) {
        movie = (LinearLayout) view.findViewById(R.id.movie);
        tv = (LinearLayout) view.findViewById(R.id.tv);
        carton = (LinearLayout) view.findViewById(R.id.carton);
        variety = (LinearLayout) view.findViewById(R.id.variety);
        mainUpView1 = (MainUpView) view.findViewById(R.id.mainUpView1);
        parent = (TableLayout) view.findViewById(R.id.parent);
        mainUpView1.setEffectBridge(new EffectNoDrawBridge());
        noDrawBridge = (EffectNoDrawBridge) mainUpView1.getEffectBridge();
        parent.getViewTreeObserver().addOnGlobalFocusChangeListener((view12, view1) -> {
            noDrawBridge.setFocusView(view1, view12, 1.2f);

        });
    }

    public void initEvent() {
        movie.setOnClickListener(this);
        tv.setOnClickListener(this);
        carton.setOnClickListener(this);
        variety.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.movie:
                ActivitySwitcher.toFilterMovie(getContext());
                break;
            case R.id.tv:
                ActivitySwitcher.toFilterTV(getContext());
                break;
            case R.id.carton:
                ActivitySwitcher.toFilterCarton(getContext());
                break;
            case R.id.variety:
                ActivitySwitcher.toFilterVariety(getContext());
                break;

        }
    }
}
