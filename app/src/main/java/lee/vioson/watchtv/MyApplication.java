package lee.vioson.watchtv;

import android.app.Application;
import android.content.Context;

/**
 * Author:李烽
 * Date:2016-11-25
 * FIXME
 * Todo
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
