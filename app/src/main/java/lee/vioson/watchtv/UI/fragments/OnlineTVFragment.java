package lee.vioson.watchtv.UI.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.open.androidtvwidget.bridge.EffectNoDrawBridge;
import com.open.androidtvwidget.view.MainUpView;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.UI.activities.ActivitySwitcher;

/**
 * Author:李烽
 * Date:2016-11-23
 * FIXME
 * Todo
 */

public class OnlineTVFragment extends Fragment {
    private com.open.androidtvwidget.view.MainUpView mainUpView1;
    private EffectNoDrawBridge noDrawBridge;
    private TableLayout parent;
    private LinearLayout cctv;
    private LinearLayout weishi;
    private LinearLayout local;
    private LinearLayout other;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_online_tv, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initEvent();
    }

    public static OnlineTVFragment newInstance() {

        Bundle args = new Bundle();

        OnlineTVFragment fragment = new OnlineTVFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private void initView(View view) {
        cctv = (LinearLayout) view.findViewById(R.id.cctv);
        weishi = (LinearLayout) view.findViewById(R.id.weishi);
        local = (LinearLayout) view.findViewById(R.id.local);
        other = (LinearLayout) view.findViewById(R.id.other);

        mainUpView1 = (MainUpView) view.findViewById(R.id.mainUpView1);
        parent = (TableLayout) view.findViewById(R.id.parent);
        mainUpView1.setEffectBridge(new EffectNoDrawBridge());
        noDrawBridge = (EffectNoDrawBridge) mainUpView1.getEffectBridge();
        parent.getViewTreeObserver().addOnGlobalFocusChangeListener((view12, view1) -> {
            noDrawBridge.setFocusView(view1, view12, 1.2f);
        });

    }

    private void initEvent() {
        cctv.setOnClickListener(view -> ActivitySwitcher.toOnlineTV(getContext()));
    }
}
