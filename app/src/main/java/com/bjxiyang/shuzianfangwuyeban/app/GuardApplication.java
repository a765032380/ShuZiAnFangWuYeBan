package com.bjxiyang.shuzianfangwuyeban.app;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


/**
 * Created by sander on 2017/4/7.
 */

public class GuardApplication extends Application {

    /**
     * 是否加密数据库.
     */

    public static GuardApplication instance;

    public GuardApplication(){
        instance = this;
    }

    public static GuardApplication getContent(){
        return instance;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        YZTEsdk.getXulie(this);
//        YZTEsdk.initServer(this);
//        YZTEsdk.initYZT(this);
//        Fresco.initialize(this);
//        CustomActivityOnCrash.install(this);
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisc(true).build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext()).defaultDisplayImageOptions(
                defaultOptions).build();
        ImageLoader.getInstance().init(config);

    }
}
