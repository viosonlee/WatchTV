package lee.vioson.watchtv.UI.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.open.androidtvwidget.bridge.RecyclerViewBridge;
import com.open.androidtvwidget.leanback.recycle.GridLayoutManagerTV;
import com.open.androidtvwidget.leanback.recycle.RecyclerViewTV;
import com.open.androidtvwidget.view.MainUpView;

import java.util.List;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.UI.activities.ActivitySwitcher;
import lee.vioson.watchtv.model.WebDataHelper;
import lee.vioson.watchtv.model.pojo.homeData.HomeData;
import lee.vioson.watchtv.model.pojo.homeData.TopicMovieSet;
import lee.vioson.watchtv.widgets.adapters.BaseRecyclerAdapter;
import lee.vioson.watchtv.widgets.adapters.RecyclerViewHolder;
import lee.vioson.watchtv.widgets.customViews.ProgressWheel;
import rx.Observer;

/**
 * Author:李烽
 * Date:2016-11-22
 * FIXME
 * Todo
 */

public class TypeFragment extends Fragment implements Observer<HomeData> {
    private com.open.androidtvwidget.leanback.recycle.RecyclerViewTV typeList;
    private lee.vioson.watchtv.widgets.customViews.ProgressWheel progressBar;
    private com.open.androidtvwidget.view.MainUpView mainUpView1;
    private RecyclerViewBridge mRecyclerViewBridge;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_type, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        WebDataHelper.getHomeData(this);
    }

    public static TypeFragment newInstance() {
        Bundle args = new Bundle();
        TypeFragment fragment = new TypeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void initView(View view) {
        typeList = (RecyclerViewTV) view.findViewById(R.id.type_list);
        progressBar = (ProgressWheel) view.findViewById(R.id.progress_bar);
        progressBar.postDelayed(() -> progressBar.setVisibility(View.VISIBLE), 500);
        mainUpView1 = (MainUpView) view.findViewById(R.id.mainUpView1);
        mainUpView1.setEffectBridge(new RecyclerViewBridge());
        mRecyclerViewBridge = (RecyclerViewBridge) mainUpView1.getEffectBridge();
//        mRecyclerViewBridge.setUpRectResource(R.drawable.white_light_10);
    }

    @Override
    public void onCompleted() {
        progressBar.postDelayed(() -> progressBar.setVisibility(View.GONE), 500);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(HomeData homeData) {
        setUpList(homeData.body.doubanTopicList);
    }

    private void setUpList(List<TopicMovieSet> doubanTopicList) {
        GridLayoutManagerTV gridLayoutManagerTV = new GridLayoutManagerTV(getActivity(), 3);
        gridLayoutManagerTV.setOrientation(GridLayoutManagerTV.VERTICAL);
        typeList.setLayoutManager(gridLayoutManagerTV);
        typeList.setFocusable(false);
        typeList.setAdapter(new BaseRecyclerAdapter<TopicMovieSet>(getActivity(), doubanTopicList) {

            @Override
            protected void bindData(RecyclerViewHolder holder, int position, TopicMovieSet topicMovieSet) {
                holder.setText(R.id.type, topicMovieSet.name);
            }

            @Override
            protected int getItemLayout(int viewType) {
                return R.layout.item_type;
            }

            @Override
            protected OnItemClickListener getOnItemClickListener() {
                return (view, position) -> ActivitySwitcher.toMovieList(getActivity(),
                        doubanTopicList.get(position).id);
            }
        });
        typeList.setOnItemListener(new RecyclerViewTV.OnItemListener() {
            @Override
            public void onItemPreSelected(RecyclerViewTV parent, View itemView, int position) {
                mRecyclerViewBridge.setUnFocusView(itemView);
            }

            @Override
            public void onItemSelected(RecyclerViewTV parent, View itemView, int position) {
                mRecyclerViewBridge.setFocusView(itemView, 1.2f);
            }

            @Override
            public void onReviseFocusFollow(RecyclerViewTV parent, View itemView, int position) {
                mRecyclerViewBridge.setFocusView(itemView, 1.2f);
            }
        });
        typeList.setOnItemClickListener((parent, itemView, position) -> {
            mRecyclerViewBridge.setFocusView(itemView, 1.2f);
            //跳转
            ActivitySwitcher.toMovieList(getActivity(), doubanTopicList.get(position).id);
        });
    }
}
