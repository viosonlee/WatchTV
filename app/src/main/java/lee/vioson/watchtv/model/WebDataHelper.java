package lee.vioson.watchtv.model;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;

import lee.vioson.watchtv.BuildConfig;
import lee.vioson.watchtv.MyApplication;
import lee.vioson.watchtv.model.api.IApi;
import lee.vioson.watchtv.model.pojo.Video;
import lee.vioson.watchtv.model.pojo.dianbo.DianBoFilter;
import lee.vioson.watchtv.model.pojo.dianbo.FilterParam;
import lee.vioson.watchtv.model.pojo.dianbo.FilterResult;
import lee.vioson.watchtv.model.pojo.homeData.HomeData;
import lee.vioson.watchtv.model.pojo.homeData.MovieList;
import lee.vioson.watchtv.model.pojo.homeData.MovieSetList;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author:李烽
 * Date:2016-11-18
 * FIXME
 * Todo
 */

public class WebDataHelper {
    private static IApi iApi;
    private static OkHttpClient okHttpClient;

    private static IApi getiApi() {
        if (iApi == null) {
            File cacheFile = new File(MyApplication.getContext().getCacheDir(), "[cacheRetrofit]");
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);
            Interceptor interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Response response = chain.proceed(request);
                    int maxStale = 60 * 60 * 24 * 1;//缓存时间：一天
                    return response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
            };
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor)
                    .cache(cache)
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.HOST)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            iApi = retrofit.create(IApi.class);
        }
        return iApi;
    }

    /**
     * 获取首页数据
     *
     * @param observer
     */
    public static void getHomeData(Observer<HomeData> observer) {
        getiApi().getHomeData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 获取更多豆瓣影集
     *
     * @param page
     * @param observer
     */
    public static void getMoreDBMovieSet(int page, Observer<MovieSetList> observer) {
        getiApi().getMoreDBMovieSet(page, BuildConfig.COUNT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 获取豆瓣影集的items
     *
     * @param page
     * @param id
     * @param observer
     */
    public static void getMoreDBMovieSetItems(int page, String id, Observer<MovieList> observer) {
        getiApi().getMoreDBMovieSetItems(page, BuildConfig.COUNT, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 获取排行的items
     *
     * @param page
     * @param id
     * @param observer
     */
    public static void getMoreTopicMovieItems(int page, String id, Observer<MovieList> observer) {
        getiApi().getMoreTopicMovieItems(page, BuildConfig.COUNT, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 获取影片（专辑）详情
     *
     * @param id
     * @param isAlbum
     * @param observer
     */
    public static void getVedioInfo(String id, boolean isAlbum, Observer<Video> observer) {
        getiApi().getVedioInfo(id, isAlbum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 获取点播筛选条件
     *
     * @param type
     * @param observer
     */
    public static void getDianboFilter(int type, SingleSubscriber<DianBoFilter> observer) {
        getiApi().getDianboFilter(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 获取筛选结果
     *
     * @param param
     * @param observer
     */
    public static void getFilterResult(FilterParam param, Observer<FilterResult> observer) {
        param.pageSize = BuildConfig.COUNT;
        getiApi().getFilterResult(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 获取筛选结果
     *
     * @param genre
     * @param country
     * @param sortby   （最新：time;评分：score）
     * @param year
     * @param page
     * @param type
     * @param observer
     */
    public static void getFilterResult(String genre, String country, String sortby, String year, int page,
                                       int type, Observer<FilterResult> observer) {
        getiApi().getFilterResult(genre, country, sortby, year, page, BuildConfig.COUNT, type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
