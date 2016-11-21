package lee.vioson.watchtv.UI.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.model.WebDataHelper;
import lee.vioson.watchtv.model.pojo.homeData.HomeData;
import lee.vioson.watchtv.model.pojo.homeData.TopicMovieSet;
import lee.vioson.watchtv.widgets.adapters.CommonAdapter;
import lee.vioson.watchtv.widgets.adapters.ViewHolder;
import rx.Observer;

/**
 * Author:李烽
 * Date:2016-11-16
 * FIXME
 * Todo
 */

public class FirstFragment extends Fragment implements Observer<HomeData> {
    private android.widget.ListView typeList;
    private android.widget.GridView contentGrid;

    private ProgressDialog dialog;

    public static FirstFragment newInstance() {
        Bundle args = new Bundle();
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_first, null);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        typeList = (ListView) view.findViewById(R.id.type_list);
        contentGrid = (GridView) view.findViewById(R.id.content_grid);
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage(getString(R.string.loading));
        dialog.show();
        WebDataHelper.getHomeData(this);
    }

    @Override
    public void onCompleted() {
        dialog.dismiss();
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
        typeList.setAdapter(new CommonAdapter<TopicMovieSet>(getActivity(), doubanTopicList,
                R.layout.item_type_list) {
            @Override
            public void convert(ViewHolder helper, TopicMovieSet item, int position) {
                helper.setText(R.id.type, item.name);
            }
        });

        typeList.setChoiceMode(ListView.FOCUSABLES_TOUCH_MODE);

    }
}
