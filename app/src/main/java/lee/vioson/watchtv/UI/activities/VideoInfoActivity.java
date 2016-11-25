package lee.vioson.watchtv.UI.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import lee.vioson.watchtv.model.WebDataHelper;
import lee.vioson.watchtv.model.pojo.Video;
import lee.vioson.watchtv.model.pojo.VideoInfo;
import lee.vioson.watchtv.widgets.adapters.BaseRecyclerAdapter;
import lee.vioson.watchtv.widgets.adapters.RecyclerViewHolder;
import lee.vioson.watchtv.widgets.customViews.ProgressWheel;
import rx.Observer;


public class VideoInfoActivity extends Activity implements Observer<Video> {

    public static final String IS_ALBUM = "is_ablum";
    public static final String VIDEO_THUMB = "img_thumb";
    public static final String VIDEO_ID = "video_id";
    private RelativeLayout activityVideoInfo;
    private ImageView pic;
    private TextView des;
    private RecyclerViewTV chooseUnit;
    private ProgressWheel progressWheel;
    private MainUpView mainUpView1;
    private boolean isAlbum;
    private String videoID;
    private String img;//带过来

    private List<VideoInfo> mDatas = new ArrayList<>();//播放的链接
    private RecyclerViewBridge mRecyclerViewBridge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_info);
        isAlbum = getIntent().getBooleanExtra(IS_ALBUM, false);
        img = getIntent().getStringExtra(VIDEO_THUMB);
        videoID = getIntent().getStringExtra(VIDEO_ID);
        initView();
        loadData();
    }

    private void loadData() {
        progressWheel.setVisibility(View.VISIBLE);
        WebDataHelper.getVedioInfo(videoID, isAlbum, this);
    }

    private void initView() {
        activityVideoInfo = (RelativeLayout) findViewById(R.id.activity_video_info);
        pic = (ImageView) findViewById(R.id.pic);
        Picasso.with(this).load(img).into(pic);
        des = (TextView) findViewById(R.id.des);
        chooseUnit = (RecyclerViewTV) findViewById(R.id.choose_unit);
        progressWheel = (ProgressWheel) findViewById(R.id.progress_wheel);
        mainUpView1 = (MainUpView) findViewById(R.id.mainUpView1);
        mainUpView1.setEffectBridge(new RecyclerViewBridge());
        mRecyclerViewBridge = (RecyclerViewBridge) mainUpView1.getEffectBridge();

        GridLayoutManagerTV layoutManagerTV = new GridLayoutManagerTV(this, 6);
        layoutManagerTV.setOrientation(GridLayoutManagerTV.VERTICAL);
        chooseUnit.setLayoutManager(layoutManagerTV);
        chooseUnit.clearFocus();
        chooseUnit.setAdapter(new BaseRecyclerAdapter<VideoInfo>(this, mDatas) {
            @Override
            protected void bindData(RecyclerViewHolder holder, int position, VideoInfo videoInfo) {
                holder.setText(R.id.unit, videoInfo.videoName);
            }

            @Override
            protected int getItemLayout(int viewType) {
                return R.layout.item_album;
            }

            @Override
            protected OnItemClickListener getOnItemClickListener() {
                return new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        ActivitySwitcher.toPlayMovie(VideoInfoActivity.this, mDatas.get(position).playerUrl);
                    }
                };
            }
        });
        chooseUnit.setOnItemListener(new MyOnItemListener(mRecyclerViewBridge, 1.1f));
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        progressWheel.setVisibility(View.GONE);
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(Video video) {
        progressWheel.setVisibility(View.GONE);
        des.setText(Html.fromHtml(video.body.desc));
        mDatas.clear();
        mDatas.addAll(video.body.videos);
        chooseUnit.getAdapter().notifyDataSetChanged();
    }
}
