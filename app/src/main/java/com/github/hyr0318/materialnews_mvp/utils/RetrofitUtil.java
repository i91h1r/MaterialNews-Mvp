package com.github.hyr0318.materialnews_mvp.utils;

import com.github.hyr0318.materialnews_mvp.data.ApiService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description:
 * 作者：hyr on 2016/8/29 12:01
 * 邮箱：2045446584@qq.com
 */
public class RetrofitUtil {
    public  static Retrofit.Builder get(String baseUrl){
        OkHttpClient okHttpClient =new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).build();

        Retrofit.Builder builder = new Retrofit.Builder();

        builder.client(okHttpClient).baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(
            RxJavaCallAdapterFactory.create());

        return builder ;

    }

    public  static ApiService getApi (String baseuRL){

        return  get(baseuRL).build().create(ApiService.class);
    }

}
