package com.github.hyr0318.materialnews_mvp.model;

import android.util.Log;
import com.github.hyr0318.materialnews_mvp.contract.TuwenDetialContract;
import com.github.hyr0318.materialnews_mvp.entity.TuwenDetailEntity;
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
 * Created by MVPHelper on 2016/08/31
 */

public class TuwenDetialModelImpl implements TuwenDetialContract.TuwenDetialModel {
    private BaseMultiLoadedListener<TuwenDetailEntity> baseMultiLoadedListener;


    public TuwenDetialModelImpl(BaseMultiLoadedListener<TuwenDetailEntity> baseMultiLoadedListener) {
        this.baseMultiLoadedListener = baseMultiLoadedListener;

    }


    @Override
    public void getTuwenDetailContent(String requestTag, int event_tag, String url) {
        TuwenDetailEntity tuwenDetailEntity = new TuwenDetailEntity();
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

            Element docContent = document.getElementById("DocContent");

            String title = docContent.select("h1").text();

            tuwenDetailEntity.setTitle(title);

            String type = docContent.select("a").first().text();

            tuwenDetailEntity.setType(type);

            String date = docContent.select("span").first().text();

            tuwenDetailEntity.setDate(date);

            Elements content = docContent.getElementsByClass("content");
            Elements p = content.select("p");
            List<TuwenDetailEntity.DetailImg> imgs = new ArrayList<TuwenDetailEntity.DetailImg>();
            List<TuwenDetailEntity.DetailDes> dess = new ArrayList<TuwenDetailEntity.DetailDes>();

            String span = p.text();

            Log.i("span","span================"+span+"================");

            String[] split = span.split("\\s+\\s+");
            Log.i("split","split================"+split+"================");
            for (int k = 0; k < split.length; k++) {
                String s = split[k];
                TuwenDetailEntity.DetailDes detailDes = tuwenDetailEntity.new
                    DetailDes();
                detailDes.setDes(s);
                dess.add(detailDes);

                Log.i("des","des================"+s+"================");
            }


            Elements imgss = p.select("img");

            for (int i = 0; i < imgss.size(); i++) {
                Element element = imgss.get(i);
                String src = element.attr("src");

                TuwenDetailEntity.DetailImg detailImg = tuwenDetailEntity.new DetailImg(src);
                imgs.add(detailImg);

            }


            tuwenDetailEntity.setImgList(imgs);
            tuwenDetailEntity.setDetailDes(dess);

        }).observeOn(AndroidSchedulers.mainThread()).subscribe(document -> {

            baseMultiLoadedListener.onSuccess(event_tag, tuwenDetailEntity);
        });

    }
}