package lee.vioson.watchtv.model.api;

import lee.vioson.watchtv.model.pojo.Video;
import lee.vioson.watchtv.model.pojo.dianbo.DianBoFilter;
import lee.vioson.watchtv.model.pojo.dianbo.FilterParam;
import lee.vioson.watchtv.model.pojo.dianbo.FilterResult;
import lee.vioson.watchtv.model.pojo.homeData.HomeData;
import lee.vioson.watchtv.model.pojo.homeData.MovieList;
import lee.vioson.watchtv.model.pojo.homeData.MovieSetList;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author:李烽
 * Date:2016-11-18
 * FIXME
 * Todo 网络请求
 */

public interface IApi {
    //首页数据排行数据
    @GET("/api/index")
    Observable<HomeData> getHomeData();

    //豆瓣影集更多
    @GET("/api/more_doulist")
    Observable<MovieSetList> getMoreDBMovieSet(@Query("page") int page, @Query("pageSize") int count);

    //影集详情
    @GET("/api/doulist_items")
    Observable<MovieList> getMoreDBMovieSetItems(@Query("page") int page,
                                                 @Query("pageSize") int count, @Query("id") String id);

    //首页分类排行更多
    @GET("/api/more_douban_topic_items")
    Observable<MovieList> getMoreTopicMovieItems(@Query("page") int page,
                                                 @Query("pageSize") int count, @Query("id") String id);

    //点播获取筛选条件
    @GET("/api/videosfilter")
    Observable<DianBoFilter> getDianboFilter(@Query("type") int type);

    //获取当前条件下的结果
    @POST("/api/videos")
    Observable<FilterResult> getFilterResult(@Body FilterParam param);

    //获取当前条件下的结果
    @POST("/api/videos")
    Observable<FilterResult> getFilterResult(@Field("genre") String genre, @Field("country") String country,
                                             @Field("sortby") String sortby, @Field("year") String year,
                                             @Field("page") int page, @Field("pageSize") int count,
                                             @Field("type") int type);

    //获取影片（专辑）详情
    @GET("/api/video")
    Observable<Video> getVedioInfo(@Query("videoId") String videoId, @Query("isAlbum") boolean isAlbum);
}
