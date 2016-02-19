package com.qianfeng.volleydemo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/1/22.
 */
public class MyApplication extends Application{
    public static RequestQueue requestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue= Volley.newRequestQueue(this);
    }
}
