package com.github.hyr0318.materialnews_mvp.data;

import com.github.hyr0318.materialnews_mvp.entity.ImageResult;
import com.github.hyr0318.materialnews_mvp.entity.JokeResult;
import com.github.hyr0318.materialnews_mvp.entity.TouTiaoVideoResult;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Description:
 * 作者：hyr on 2016/8/29 11:53
 * 邮箱：2045446584@qq.com
 */
public interface ApiService {

    //http://toutiao.com/api/article/recent/?category=video&as=A135870C95A0924
    @GET("/api/article/recent/")
    Observable<TouTiaoVideoResult> getvideoList(
        @Query("category") String category, @Query("as") String as);

    //https://route.showapi.com/255-1/?page=2&showapi_appid=23885&showapi_timestamp=20160901104936&showapi_sign=04e0e94a0431cd612af4bc818217b595
    @GET("/255-1/")
    Observable<JokeResult> getJokeList(
        @Query("page") int page,
        @Query("showapi_appid") String showapi_appid,
        @Query("showapi_timestamp") String showapi_timestamp,
        @Query("showapi_sign") String showapi_sign);

    //http://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&word=%E7%BE%8E%E5%A5%B3&cl=5
    @GET("/search/acjson ")
    Observable<ImageResult> getImageList(
        @Query("tn") String tn,
        @Query("ipn") String ipn, @Query("word") String word, @Query("cl") String  cl);

}
