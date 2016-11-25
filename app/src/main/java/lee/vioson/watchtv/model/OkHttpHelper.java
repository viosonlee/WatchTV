package lee.vioson.watchtv.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import lee.vioson.watchtv.MyApplication;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author:李烽
 * Date:2016-11-25
 * FIXME
 * Todo
 */

public class OkHttpHelper {
    private static final long DEFULT_TIME_OUT = 10 * 1000;

    public static OkHttpClient getHttpClient() {
        //缓存路径
        File cacheFile = new File(MyApplication.getContext().getCacheDir().getAbsolutePath(), "HttpCache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);//缓存文件为100MB
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        int maxAge = 60 * 60 * 24;//有网缓存24小时;
                        int maxStale = 60 * 60 * 24 * 28;//无网情况 4周
                        Request request = chain.request();
                        if (isNetworkReachable(MyApplication.getContext()))
                            request = request.newBuilder()
                                    .cacheControl(CacheControl.FORCE_NETWORK)
                                    .build();
                        else request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build();
                        Response response = chain.proceed(request);
                        if (isNetworkReachable(MyApplication.getContext()))
                            response = response.newBuilder()
                                    .removeHeader("Pragma")
                                    .header("Cache-Control", "public,max-age=" + maxAge)
                                    .build();
                        else response = response.newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                .build();
                        return response;
                    }
                })
                .connectTimeout(DEFULT_TIME_OUT, TimeUnit.SECONDS)
                .cache(cache)
                .build();
        return okHttpClient;
    }

    /**
     * 判断网络是否可用
     *
     * @param context Context对象
     */
    public static Boolean isNetworkReachable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = cm.getActiveNetworkInfo();
        if (current == null) {
            return false;
        }
        return (current.isAvailable());
    }
}
