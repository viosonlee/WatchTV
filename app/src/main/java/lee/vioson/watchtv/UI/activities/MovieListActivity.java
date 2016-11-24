package lee.vioson.watchtv.UI.activities;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
import lee.vioson.watchtv.model.WebDataHelper;
import lee.vioson.watchtv.model.pojo.homeData.Movie;
import lee.vioson.watchtv.model.pojo.homeData.MovieList;
import lee.vioson.watchtv.utils.DimenUtil;
import lee.vioson.watchtv.widgets.adapters.BaseRecyclerAdapter;
import lee.vioson.watchtv.widgets.adapters.RecyclerViewHolder;
import lee.vioson.watchtv.widgets.customViews.ProgressWheel;
import rx.Observer;

public class MovieListActivity extends Activity implements Observer<MovieList> {

    public static final String ID = "id";
    private String id = "";
    private RecyclerViewTV movieList;
    private ProgressWheel progressBar;
    private MainUpView mainUpView1;
    private RecyclerViewBridge mRecyclerViewBridge;
    private List<Movie> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        id = getIntent().getStringExtra(ID);
        initView();
        initRecyclerView();
        loadData();
    }

    private void initRecyclerView() {
        GridLayoutManagerTV gridLayoutManagerTV = new GridLayoutManagerTV(this, 3);
        gridLayoutManagerTV.setOrientation(GridLayoutManagerTV.VERTICAL);
        movieList.setLayoutManager(gridLayoutManagerTV);
        movieList.setFocusable(false);
        movieList.setAdapter(new BaseRecyclerAdapter<Movie>(this, mData) {

            @Override
            protected void bindData(RecyclerViewHolder holder, int position, Movie movie) {
                holder.setText(R.id.name, movie.name);
                holder.setText(R.id.score, getString(R.string.score) + movie.score);
                ImageView imageView = holder.getImageView(R.id.pic);
                Picasso.with(MovieListActivity.this)
                        .load(movie.img).into(imageView);
            }

            @Override
            protected int getItemLayout(int viewType) {
                return R.layout.item_normal_content;
            }

            @Override
            protected OnItemClickListener getOnItemClickListener() {
                return (view, position) -> {
                    ActivitySwitcher.toPlayMovie(MovieListActivity.this, mData.get(position));
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

    private static final int INIT_PAGE = 1;
    private int page = 1;

    private void loadData() {
        page = INIT_PAGE;
        progressBar.setVisibility(View.VISIBLE);
        WebDataHelper.getMoreTopicMovieItems(page, id, this);
    }

    private void initView() {
        movieList = (RecyclerViewTV) findViewById(R.id.movie_list);
        progressBar = (ProgressWheel) findViewById(R.id.progress_bar);
        mainUpView1 = (MainUpView) findViewById(R.id.mainUpView1);
        mainUpView1.setEffectBridge(new RecyclerViewBridge());
        mRecyclerViewBridge = (RecyclerViewBridge) mainUpView1.getEffectBridge();
        mRecyclerViewBridge.setUpRectResource(R.drawable.white_light_10);
        float dimension = getResources().getDimension(R.dimen.d_15);
        RectF receF = new RectF(dimension, dimension, dimension, dimension);
        mRecyclerViewBridge.setDrawUpRectPadding(receF);
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
    public void onNext(MovieList data) {
        if (data.body == null || data.body.isEmpty()) {
            Toast.makeText(this, R.string.no_more, Toast.LENGTH_SHORT).show();
            movieList.setOnLoadMoreComplete();
            return;
        }
        if (page == INIT_PAGE)
            mData.clear();
        mData.addAll(data.body);
        movieList.getAdapter().notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }

    private void loadMore() {
        Log.i(getClass().getSimpleName(), "loadMore");
        page++;
        WebDataHelper.getMoreTopicMovieItems(page, id, this);
    }
}
