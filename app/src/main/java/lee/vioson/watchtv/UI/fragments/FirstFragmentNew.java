package lee.vioson.watchtv.UI.fragments;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.open.androidtvwidget.bridge.RecyclerViewBridge;
import com.open.androidtvwidget.leanback.recycle.GridLayoutManagerTV;
import com.open.androidtvwidget.leanback.recycle.RecyclerViewTV;
import com.open.androidtvwidget.view.MainUpView;

import java.util.ArrayList;
import java.util.List;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.UI.activities.ActivitySwitcher;
import lee.vioson.watchtv.UI.adapters.GridRecyclerViewAdapter;
import lee.vioson.watchtv.UI.listeners.OnMoreListClickListener;
import lee.vioson.watchtv.model.WebDataHelper;
import lee.vioson.watchtv.model.pojo.homeData.HomeData;
import lee.vioson.watchtv.model.pojo.homeData.TopicMovieSet;
import lee.vioson.watchtv.utils.DimenUtil;
import lee.vioson.watchtv.widgets.adapters.BaseRecyclerAdapter;
import lee.vioson.watchtv.widgets.adapters.RecyclerViewHolder;
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
    private RecyclerViewBridge mRecyclerViewBridge;
    private View oldView;

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
        mRecyclerViewBridge = (RecyclerViewBridge) mainUpView1.getEffectBridge();
        mRecyclerViewBridge.setUpRectResource(R.drawable.white_light_10);
//        float density = getResources().getDisplayMetrics().density;
//        RectF receF = new RectF(DimenUtil.getDimension(getActivity(), R.dimen.w_45) * density,
//                DimenUtil.getDimension(getActivity(), R.dimen.h_40) * density,
//                DimenUtil.getDimension(getActivity(), R.dimen.w_45) * density,
//                DimenUtil.getDimension(getActivity(), R.dimen.h_40) * density);
//        mRecyclerViewBridge.setDrawUpRectPadding(receF);
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

    private List<TopicMovieSet> mTopicMovieSets;

    private void initTypeList(List<TopicMovieSet> doubanTopicList) {
        this.mTopicMovieSets = new ArrayList<>();
        mTopicMovieSets.addAll(doubanTopicList);
        leftMenuRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        leftMenuRv.setFocusable(false);
        leftMenuRv.setAdapter(new BaseRecyclerAdapter<TopicMovieSet>(getActivity(), doubanTopicList) {

            @Override
            protected void bindData(RecyclerViewHolder holder, int position, TopicMovieSet topicMovieSet) {
                holder.setText(R.id.type, topicMovieSet.name);
            }

            @Override
            protected int getItemLayout(int viewType) {
                return R.layout.item_type_list;
            }

        });
        leftMenuRv.setOnItemListener(new RecyclerViewTV.OnItemListener() {
            @Override
            public void onItemPreSelected(RecyclerViewTV parent, View itemView, int position) {
                // 传入 itemView也可以, 自己保存的 oldView也可以.
                mRecyclerViewBridge.setUnFocusView(itemView);
            }

            @Override
            public void onItemSelected(RecyclerViewTV parent, View itemView, int position) {
                mRecyclerViewBridge.setFocusView(itemView, 1.2f);
                oldView = itemView;
                onViewItemClick(itemView, position);
            }

            @Override
            public void onReviseFocusFollow(RecyclerViewTV parent, View itemView, int position) {
                mRecyclerViewBridge.setFocusView(itemView, 1.2f);
                oldView = itemView;
            }
        });
        leftMenuRv.setOnItemClickListener((parent, itemView, position) -> {
            // 测试.
            mRecyclerViewBridge.setFocusView(itemView, oldView, 1.0f);
            oldView = itemView;
            //
            onViewItemClick(itemView, position);
        });
    }

    private void onViewItemClick(View itemView, int position) {
        GridLayoutManagerTV gridLayoutManagerTV = new GridLayoutManagerTV(getActivity(), 4);
        gridLayoutManagerTV.setOrientation(GridLayoutManagerTV.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManagerTV);
        recyclerView.setFocusable(false);
        recyclerView.setSelectedItemAtCentered(true);// 设置item在中间移动.
        GridRecyclerViewAdapter adapter = new GridRecyclerViewAdapter
                (mTopicMovieSets.get(position).subjects, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setOnItemListener(new RecyclerViewTV.OnItemListener() {
            @Override
            public void onItemPreSelected(RecyclerViewTV parent, View itemView, int position) {
                // 传入 itemView也可以, 自己保存的 oldView也可以.
                mRecyclerViewBridge.setUnFocusView(itemView);
            }

            @Override
            public void onItemSelected(RecyclerViewTV parent, View itemView, int position) {
                mRecyclerViewBridge.setFocusView(itemView, 1.2f);
                oldView = itemView;
            }

            @Override
            public void onReviseFocusFollow(RecyclerViewTV parent, View itemView, int position) {
                mRecyclerViewBridge.setFocusView(itemView, 1.2f);
                oldView = itemView;
            }
        });
        adapter.setOnMoreListClickListener(new OnMoreListClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                //点击
                ActivitySwitcher.toPlayMovie(getActivity(),
                        mTopicMovieSets.get(position).subjects.get(position));
            }

            @Override
            public void onMoreClick() {
                //点击更多
            }
        });
    }

}
