package lee.vioson.watchtv.UI.fragments;

import android.app.ProgressDialog;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.open.androidtvwidget.bridge.RecyclerViewBridge;
import com.open.androidtvwidget.leanback.recycle.GridLayoutManagerTV;
import com.open.androidtvwidget.leanback.recycle.RecyclerViewTV;
import com.open.androidtvwidget.view.ListViewTV;
import com.open.androidtvwidget.view.MainUpView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.UI.activities.ActivitySwitcher;
import lee.vioson.watchtv.UI.adapters.ContentGridViewAdapter;
import lee.vioson.watchtv.model.WebDataHelper;
import lee.vioson.watchtv.model.pojo.homeData.HomeData;
import lee.vioson.watchtv.model.pojo.homeData.Movie;
import lee.vioson.watchtv.model.pojo.homeData.TopicMovieSet;
import lee.vioson.watchtv.utils.DimenUtil;
import lee.vioson.watchtv.widgets.adapters.BaseRecyclerAdapter;
import lee.vioson.watchtv.widgets.adapters.CommonAdapter;
import lee.vioson.watchtv.widgets.adapters.RecyclerViewHolder;
import lee.vioson.watchtv.widgets.adapters.ViewHolder;
import lee.vioson.watchtv.widgets.customViews.ProgressWheel;
import rx.Observer;

/**
 * Author:李烽
 * Date:2016-11-16
 * FIXME
 * Todo
 */

public class FirstFragmentNew extends Fragment implements Observer<HomeData> {

    private RecyclerViewTV leftMenuRv;
    private RecyclerViewTV recyclerView;
    private ProgressWheel loadMorePb;
    private com.open.androidtvwidget.view.MainUpView mainUpView1;
    private RecyclerViewBridge mRecyclerBridge;

    public static FirstFragmentNew newInstance() {
        Bundle args = new Bundle();
        FirstFragmentNew fragment = new FirstFragmentNew();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_first_new, null);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        WebDataHelper.getHomeData(this);
    }

    private void initView(View view) {
        leftMenuRv = (RecyclerViewTV) view.findViewById(R.id.left_menu_rv);
        recyclerView = (RecyclerViewTV) view.findViewById(R.id.recyclerView);
        loadMorePb = (ProgressWheel) view.findViewById(R.id.load_more_pb);
        loadMorePb.setVisibility(View.VISIBLE);
        mainUpView1 = (MainUpView) view.findViewById(R.id.mainUpView1);
        mainUpView1.setEffectBridge(new RecyclerViewBridge());
        mRecyclerBridge = (RecyclerViewBridge)mainUpView1.getEffectBridge();
        float density = getResources().getDisplayMetrics().density;
        RectF receF = new RectF(DimenUtil.getDimension(getActivity(),R.dimen.w_45) * density,
                DimenUtil.getDimension(getActivity(),R.dimen.h_40) * density,
                DimenUtil.getDimension(getActivity(),R.dimen.w_45) * density,
                DimenUtil.getDimension(getActivity(),R.dimen.h_40) * density);
        mRecyclerBridge.setDrawUpRectPadding(receF);
    }

    @Override
    public void onCompleted() {
        loadMorePb.setVisibility(View.GONE);
    }

    @Override
    public void onError(Throwable e) {
        Log.e(getClass().getSimpleName(), e.getMessage());
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(HomeData homeData) {
        if (homeData != null && homeData.body != null) {
            initTypeList(homeData.body.doubanTopicList);
        }
    }

    private void initTypeList(List<TopicMovieSet> doubanTopicList) {

    }

}
