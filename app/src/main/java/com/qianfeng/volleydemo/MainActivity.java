package com.qianfeng.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
//注释
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPost();
    }

    /**
     * 使用post方法获取数据
     */
    protected void requestPost(){
        final  String strUrl="http://api.avatardata.cn/Face/CheckOne";

        final String key="5201b798ba3847e0acc0c7b114ff97ec";
        final String strPicUrl="http://f.hiphotos.baidu.com/image/pic/item/d31b0ef41bd5ad6ec8a8eee783cb39dbb6fd3c6d.jpg";
        StringRequest request =new StringRequest(Request.Method.POST, strUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("tag",response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("tag",error.toString());
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>mapParams=new HashMap<>();
                mapParams.put("key",key);
                mapParams.put("imgUrl",strPicUrl);
                return mapParams;
            }
        };
        MyApplication.requestQueue.add(request);
    }
}
