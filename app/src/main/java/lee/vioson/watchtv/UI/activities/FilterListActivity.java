package lee.vioson.watchtv.UI.activities;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.open.androidtvwidget.bridge.RecyclerViewBridge;
import com.open.androidtvwidget.leanback.recycle.GridLayoutManagerTV;
import com.open.androidtvwidget.leanback.recycle.RecyclerViewTV;
import com.open.androidtvwidget.view.MainUpView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import lee.vioson.watchtv.R;
import lee.vioson.watchtv.UI.listeners.MyOnItemListener;
import lee.vioson.watchtv.UI.listeners.UpLoadListener;
import lee.vioson.watchtv.model.CommonType;
import lee.vioson.watchtv.model.WebDataHelper;
import lee.vioson.watchtv.model.pojo.dianbo.FilterParam;
import lee.vioson.watchtv.model.pojo.dianbo.FilterResult;
import lee.vioson.watchtv.model.pojo.homeData.Movie;
import lee.vioson.watchtv.utils.DimenUtil;
import lee.vioson.watchtv.widgets.adapters.BaseRecyclerAdapter;
import lee.vioson.watchtv.widgets.adapters.RecyclerViewHolder;
import lee.vioson.watchtv.widgets.customViews.ProgressWheel;
import rx.Observer;

/**
 * Author:李烽
 * Date:2016-11-23
 * FIXME
 * Todo
 */

public class FilterListActivity extends Activity implements Observer<FilterResult> {
    public static final String TYPE = "type";
    private RecyclerViewTV movieList;
    private ProgressWheel progressBar;
    private MainUpView mainUpView1;

    //menu
    private TextView sort;
    private TextView type;
    private TextView area;
    private TextView time;
    private ListView sortList;
    private ListView typeList;
    private ListView areaList;
    private ListView timeList;

    private List<FilterResult.Result> mData = new ArrayList<>();

    private FilterParam param;

    private RecyclerViewBridge mRecyclerViewBridge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_list);
        initParams();
        initMain();
        initMenu();
        initRecyclerView();
        loadData();
    }

    private void initParams() {
        String all = getString(R.string.all);
        param = new FilterParam();
        param.genre = all;
        param.country = all;
        param.year = all;
        param.sortby = "time";
        param.pageSize = 20;
        param.page = 1;
        param.type = getType();
    }

    private int getType() {
        return getIntent().getIntExtra(TYPE, CommonType.MOVIE);
    }

    private void loadData() {
        WebDataHelper.getFilterResult(param, this);
    }


    private void initMain() {
        progressBar = (ProgressWheel) findViewById(R.id.progress_bar);
        progressBar.postDelayed(() -> progressBar.setVisibility(View.VISIBLE), 50);
        mainUpView1 = (MainUpView) findViewById(R.id.mainUpView1);
        mainUpView1 = (MainUpView) findViewById(R.id.mainUpView1);
        mainUpView1.setEffectBridge(new RecyclerViewBridge());
        mRecyclerViewBridge = (RecyclerViewBridge) mainUpView1.getEffectBridge();
        mRecyclerViewBridge.setUpRectResource(R.drawable.white_light_10);
        float density = getResources().getDisplayMetrics().density;
        RectF receF = new RectF(0, DimenUtil.getDimension(this, R.dimen.d_15) * density, 0,
                DimenUtil.getDimension(this, R.dimen.d_5) * density);
        mRecyclerViewBridge.setDrawUpRectPadding(receF);
    }

    private void initRecyclerView() {
        movieList = (RecyclerViewTV) findViewById(R.id.movie_list);
        GridLayoutManagerTV gridLayoutManagerTV = new GridLayoutManagerTV(this, 4);
        gridLayoutManagerTV.setOrientation(GridLayoutManagerTV.VERTICAL);
        movieList.setLayoutManager(gridLayoutManagerTV);
        movieList.setFocusable(false);
        movieList.setAdapter(new BaseRecyclerAdapter<FilterResult.Result>(this, mData) {

            @Override
            protected void bindData(RecyclerViewHolder holder, int position, FilterResult.Result movie) {
                holder.setText(R.id.name, movie.name);
                holder.setText(R.id.score, getString(R.string.score) + movie.score);
                ImageView imageView = holder.getImageView(R.id.pic);
                Picasso.with(FilterListActivity.this)
                        .load(movie.img).into(imageView);
            }

            @Override
            protected int getItemLayout(int viewType) {
                return R.layout.item_normal_content;
            }

            @Override
            protected OnItemClickListener getOnItemClickListener() {
                return (view, position) -> {
                    ActivitySwitcher.toPlayMovie(FilterListActivity.this, mData.get(position));
                };
            }
        });
        movieList.setOnItemListener(new MyOnItemListener(mRecyclerViewBridge));
        movieList.addOnScrollListener(new UpLoadListener(gridLayoutManagerTV) {
            @Override
            protected void onLoadMore() {
                loadMore();
            }
        });
    }

    private void loadMore() {
        param.page++;
        loadData();
    }

    private void initMenu() {
        sort = (TextView) findViewById(R.id.sort);
        type = (TextView) findViewById(R.id.type);
        area = (TextView) findViewById(R.id.area);
        time = (TextView) findViewById(R.id.time);
        sortList = (ListView) findViewById(R.id.sort_list);
        typeList = (ListView) findViewById(R.id.type_list);
        areaList = (ListView) findViewById(R.id.area_list);
        timeList = (ListView) findViewById(R.id.time_list);
    }

    @Override
    public void onCompleted() {
        progressBar.postDelayed(() -> progressBar.setVisibility(View.GONE), 50);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(FilterResult filterResult) {
        if (filterResult == null) {
            return;
        }
        if (param.page == 1)
            mData.clear();
        mData.addAll(filterResult.body);
        movieList.getAdapter().notifyDataSetChanged();
    }
}
