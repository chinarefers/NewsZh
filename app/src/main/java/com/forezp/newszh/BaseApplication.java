package com.forezp.newszh;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by b508a on 2016/3/30.
 */
public class BaseApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext= getApplicationContext();
        Fresco.initialize(getApplicationContext());
        OkHttpUtils.getInstance().debug("OkHttpUtils").setConnectTimeout(100000, TimeUnit.MILLISECONDS);
        OkHttpUtils.getInstance().setCertificates();
    }

    public static Context getContext(){
        return  mContext;
    }
}
