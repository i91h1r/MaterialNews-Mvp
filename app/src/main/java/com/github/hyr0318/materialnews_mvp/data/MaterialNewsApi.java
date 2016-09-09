package com.github.hyr0318.materialnews_mvp.data;

import com.github.hyr0318.materialnews_mvp.api.Urls;
import com.github.hyr0318.materialnews_mvp.entity.HomeOneIdResult;
import com.github.hyr0318.materialnews_mvp.entity.HomeOneResult;
import com.github.hyr0318.materialnews_mvp.entity.ImageResult;
import com.github.hyr0318.materialnews_mvp.entity.JokeResult;
import com.github.hyr0318.materialnews_mvp.entity.TouTiaoVideoResult;
import com.github.hyr0318.materialnews_mvp.utils.RetrofitUtil;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Description:
 * 作者：hyr on 2016/8/29 11:59
 * 邮箱：2045446584@qq.com
 */
public class MaterialNewsApi implements ApiService {

    @Override
    public Observable<TouTiaoVideoResult> getvideoList(
        @Query("category") String category, @Query("as") String as) {
        return RetrofitUtil.getApi(Urls.TOUTIAO_BASE_URL)
            .getvideoList(category, as)
            .subscribeOn(Schedulers.io())
            .observeOn(
                AndroidSchedulers.mainThread());
    }


    @Override
    public Observable<JokeResult> getJokeList(
        @Query("page") int page,
        @Query("showapi_appid") String showapi_appid,
        @Query("showapi_timestamp") String showapi_timestamp,
        @Query("showapi_sign") String showapi_sign) {
        return RetrofitUtil.getApi(Urls.JOKE_BASE_URL)
            .getJokeList(page, showapi_appid, showapi_timestamp, showapi_sign)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }


    @Override
    public Observable<ImageResult> getImageList(
        @Query("tn") String tn,
        @Query("ipn") String ipn, @Query("word") String word, @Query("cl") String cl) {
        return RetrofitUtil.getApi(Urls.BAIDU_IMAGE_BASE_URL)
            .getImageList(tn, ipn, word, cl)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }


    @Override public Observable<HomeOneIdResult> getHomeOneId() {
        return RetrofitUtil.getApi(Urls.ONE_BASE_URL)
            .getHomeOneId()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }


    @Override public Observable<HomeOneResult> getHomeOneData(@Path("id") String id) {
        return RetrofitUtil.getApi(Urls.ONE_BASE_URL)
            .getHomeOneData(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

}
