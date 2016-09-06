package com.github.hyr0318.materialnews_mvp.model;

import android.util.Log;
import com.github.hyr0318.materialnews_mvp.api.Urls;
import com.github.hyr0318.materialnews_mvp.contract.TuwenContract;
import com.github.hyr0318.materialnews_mvp.entity.TuwenEntity;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by MVPHelper on 2016/08/30
 */

public class TuwenModelImpl implements TuwenContract.TuwenModel {
    private BaseMultiLoadedListener<List<TuwenEntity>> baseMultiLoadedListener;


    public TuwenModelImpl(BaseMultiLoadedListener<List<TuwenEntity>> baseMultiLoadedListener) {
        this.baseMultiLoadedListener = baseMultiLoadedListener;
    }


    @Override
    public void getCommonListData(String requestTag, int event_tag, String keyword, int page) {

        //http://www.tuweng.com/feeling/index_2.html   http://www.tuweng.com/feeling/
        String url;

        if (page != 0) {
            url = Urls.TUWEN_BASE_URL +keyword+ "/index_" + page + ".html";
        } else {
            url = Urls.TUWEN_BASE_URL + keyword+"/index.html";
        }

        List<TuwenEntity> list = new ArrayList<>();

        Observable.create(new Observable.OnSubscribe<Document>() {
            @Override public void call(Subscriber<? super Document> subscriber) {
                try {
                    Document document = Jsoup.connect(url).get();
                    subscriber.onNext(document);
                } catch (IOException e) {
                    e.printStackTrace();
                    subscriber.onNext(null);
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).doOnNext(document -> {
            list.clear();

            if (document == null) {
                return;
            } else {

         /*       Element column = document.getElementById("column");

                Elements lm = column.getElementsByClass("lm");*/

                Element tuWen = document.getElementById("TuWen");

                Elements lm = tuWen.getElementsByClass("lm");

                for (int i = 0; i < lm.size(); i++) {
                    TuwenEntity tuwenEntity = new TuwenEntity();

                    Element element = lm.get(i);

                    Element a = element.select("a").first();

                    String thumb = a.select("img").first().attr("src");
                    tuwenEntity.setThumb(thumb);
                    Log.i("thumb=====", thumb);

                    String title = a.select("img").first().attr("alt");
                    tuwenEntity.setTitle(title);
                    Log.i("title=====", title);

                    String href = a.attr("href");
                    tuwenEntity.setDetialURL(href);
                    Log.i("href=====", href);

                    Element select = element.select("h3").first().select("a").first();

                    String type = select.text();
                    tuwenEntity.setType(type);
                    Log.i("type=====", type);

                    String author = element.select("h3").first().select("i").text();
                    Log.i("author=====", author);
                    tuwenEntity.setAuthor(author);

                    String data = element.select("h3").first().select("span").text();
                    Log.i("data=====", data);
                    tuwenEntity.setDate(data);

                    String des = element.select("p").text();
                    Log.i("des=====", des);
                    tuwenEntity.setDes(des);

                    list.add(tuwenEntity);
                }

            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(document -> {
            baseMultiLoadedListener.onSuccess(event_tag, list);
        });
    }
}