package com.bawei.songjiahao.songjiahao.utils;

import android.os.Handler;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 时间：2020/1/2 0002
 * 作者：Songjiahao
 * 类的作用：
 */
public class OkHttpUtils {
    private static OkHttpUtils okHttp;
    private final OkHttpClient okHttpClient;
    Handler handler=new Handler();

    public OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpUtils getInstance() {
        if (okHttp==null){
            synchronized (OkHttpUtils.class){
                if (okHttp==null){
                    okHttp=new OkHttpUtils();
                }
            }
        }
        return okHttp;
    }

    public void doGet(String url,OkHttpCallBack okHttpCallBack){
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        okHttpCallBack.failure(e);
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                handler.post(new Runnable() {
                    String s = response.body().string();
                    @Override
                    public void run() {
                        okHttpCallBack.success(s);
                    }
                });
            }
        });
    }

    public interface OkHttpCallBack{
        void success(String s);
        void failure(Throwable throwable);
    }
}
