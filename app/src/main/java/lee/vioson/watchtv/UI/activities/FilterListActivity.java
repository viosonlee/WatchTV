package lee.vioson.watchtv.UI.activities;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

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
import lee.vioson.watchtv.model.pojo.dianbo.DianBoFilter;
import lee.vioson.watchtv.model.pojo.dianbo.FilterParam;
import lee.vioson.watchtv.model.pojo.dianbo.FilterResult;
import lee.vioson.watchtv.utils.DimenUtil;
import lee.vioson.watchtv.widgets.adapters.BaseRecyclerAdapter;
import lee.vioson.watchtv.widgets.adapters.CommonAdapter;
import lee.vioson.watchtv.widgets.adapters.RecyclerViewHolder;
import lee.vioson.watchtv.widgets.adapters.ViewHolder;
import lee.vioson.watchtv.widgets.customViews.ProgressWheel;
import rx.Observer;
import rx.SingleSubscriber;

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
    private CheckedTextView sort;
    private CheckedTextView type;
    private CheckedTextView area;
    private CheckedTextView time;
    //    private ListView sortList;
    private ListView typeList;
    private ListView areaList;
    private ListView timeList;

    private List<String> types = new ArrayList<>();
    private List<String> areas = new ArrayList<>();
    private List<String> times = new ArrayList<>();

    private List<FilterResult.Result> mData = new ArrayList<>();

    private FilterParam param;

    private RecyclerViewBridge mRecyclerViewBridge;
    private DrawerLayout drawerlayout;

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
        progressBar.setVisibility(View.VISIBLE);
//        WebDataHelper.getFilterResult(param, this);
        WebDataHelper.getFilterResult(param.genre, param.country, param.sortby, param.year
                , param.page, param.type, this);
    }


    private void initMain() {
        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
//        drawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        progressBar = (ProgressWheel) findViewById(R.id.progress_bar);
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
        GridLayoutManagerTV gridLayoutManagerTV = new GridLayoutManagerTV(this, 3);
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
        sort = (CheckedTextView) findViewById(R.id.sort);
        type = (CheckedTextView) findViewById(R.id.type);
        area = (CheckedTextView) findViewById(R.id.area);
        time = (CheckedTextView) findViewById(R.id.time);
        sort.setOnClickListener(view -> {
            if (param.sortby.equals("time")) {
                sort.setChecked(false);
                param.sortby = "score";
                sort.setText(getString(R.string.by_score));
            } else {
                sort.setChecked(true);
                param.sortby = "time";
                sort.setText(getString(R.string.by_time));
            }
            type.setChecked(false);
            area.setChecked(false);
            time.setChecked(false);
            loadData();
        });

        type.setOnClickListener(view -> {
            sort.setChecked(false);
            type.setChecked(true);
            area.setChecked(false);
            time.setChecked(false);
            typeList.setVisibility(View.VISIBLE);
            areaList.setVisibility(View.GONE);
            timeList.setVisibility(View.GONE);
        });
        area.setOnClickListener(view -> {
            sort.setChecked(false);
            type.setChecked(false);
            area.setChecked(true);
            time.setChecked(false);
            areaList.setVisibility(View.VISIBLE);
            typeList.setVisibility(View.GONE);
            timeList.setVisibility(View.GONE);
        });
        time.setOnClickListener(view -> {
            sort.setChecked(false);
            time.setChecked(true);
            area.setChecked(false);
            type.setChecked(false);
            timeList.setVisibility(View.VISIBLE);
            areaList.setVisibility(View.GONE);
            typeList.setVisibility(View.GONE);
        });
//        sortList = (ListView) findViewById(R.id.sort_list);
        typeList = (ListView) findViewById(R.id.type_list);
        areaList = (ListView) findViewById(R.id.area_list);
        timeList = (ListView) findViewById(R.id.time_list);
        typeList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        areaList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        timeList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        typeList.setAdapter(new CommonAdapter<String>(this, types, R.layout.item_type_list) {
            @Override
            public void convert(ViewHolder helper, String item, int position) {
                helper.setText(R.id.type, item);
            }
        });
        areaList.setAdapter(new CommonAdapter<String>(this, areas, R.layout.item_type_list) {
            @Override
            public void convert(ViewHolder helper, String item, int position) {
                helper.setText(R.id.type, item);
            }
        });
        timeList.setAdapter(new CommonAdapter<String>(this, times, R.layout.item_type_list) {
            @Override
            public void convert(ViewHolder helper, String item, int position) {
                helper.setText(R.id.type, item);
            }
        });
        typeList.setOnItemClickListener((adapterView, view, i, l) -> {
            typeList.setSelection(i);
            param.genre = types.get(i);
            loadData();
        });
        areaList.setOnItemClickListener((adapterView, view, i, l) -> {
            areaList.setSelection(i);
            param.country = areas.get(i);
            loadData();
        });
        timeList.setOnItemClickListener((adapterView, view, i, l) -> {
            timeList.setSelection(i);
            param.year = times.get(i);
            loadData();
        });

        WebDataHelper.getDianboFilter(getType(), new SingleSubscriber<DianBoFilter>() {
            @Override
            public void onSuccess(DianBoFilter value) {
                if (value == null || value.body == null) {
                    return;
                }
                types.clear();
                types.addAll(value.body.types);
                areas.clear();
                areas.addAll(value.body.areas);
                times.clear();
                times.addAll(value.body.years);
                ((CommonAdapter) typeList.getAdapter()).notifyDataSetChanged();
                ((CommonAdapter) areaList.getAdapter()).notifyDataSetChanged();
                ((CommonAdapter) timeList.getAdapter()).notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable error) {

            }
        });

    }

    @Override
    public void onCompleted() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && event.getAction() == KeyEvent.ACTION_DOWN) {
            boolean drawerOpen = drawerlayout.isDrawerOpen(Gravity.RIGHT);
            if (drawerOpen)
                drawerlayout.closeDrawer(Gravity.RIGHT);
            else {
                drawerlayout.openDrawer(Gravity.RIGHT);
                sort.requestFocus();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (drawerlayout.isDrawerOpen(Gravity.RIGHT))
            drawerlayout.closeDrawers();
        else finish();
    }
}
