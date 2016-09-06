package com.github.hyr0318.materialnews_mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.github.hyr0318.baselibrary.base.activity.BaseActivity;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.net.NetUtils;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.api.ApiConstants;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.TuwenDetialContract;
import com.github.hyr0318.materialnews_mvp.entity.TuwenDetailEntity;
import com.github.hyr0318.materialnews_mvp.presenter.TuwenDetialPresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.adapter.TuwenDetailAdapter;

import static com.github.hyr0318.materialnews_mvp.R.id.rl_comment;

/**
 * Description:
 * 作者：hyr on 2016/8/31 12:07
 * 邮箱：2045446584@qq.com
 */
public class TuwenDetailActivity extends BaseActivity
    implements TuwenDetialContract.TuwenDetialView {

    private String detialURL;
    private RelativeLayout root;
    private TuwenDetialPresenterImpl tuwenDetialPresenter;
    private TextView title;
    private RecyclerView imgList;
    private TextView date;
    private TextView type;
    private TuwenDetailAdapter tuwenDetailAdapter;


    @Override protected int getContentViewLayoutID() {
        return R.layout.activity_tuwen_detail_lauout;
    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override protected void getViewById() {

        imgList = (RecyclerView) findViewById(R.id.imgsList);
        root = (RelativeLayout) findViewById(rl_comment);

        title = (TextView) findViewById(R.id.title);

        date = (TextView) findViewById(R.id.date);

        type = (TextView) findViewById(R.id.type);
    }


    @Override protected View getLoadingView() {
        return root;
    }


    @Override protected void initViewsAndEvents() {

        tuwenDetialPresenter = new TuwenDetialPresenterImpl(mContext, this);

        root.postDelayed(()-> tuwenDetialPresenter.loadTuwenDetail(TAG_LOG, Constants.EVENT_REFRESH_DATA,
            detialURL, false),ApiConstants.Integers.PAGE_LAZY_LOAD_DELAY_TIME_MS);

        tuwenDetailAdapter = new TuwenDetailAdapter(mContext);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        imgList.setLayoutManager(linearLayoutManager);
        imgList.setAdapter(tuwenDetailAdapter);

    }


    @Override protected void getIntentExtras(Bundle extras) {
        detialURL = extras.getString("DetialURL");
    }


    @Override protected void onNetworkConnected(NetUtils.NetType type) {

    }


    @Override protected void onNetworkDisConnected() {

    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }


    @Override public void initializedView(TuwenDetailEntity tuwenDetailEntity) {

        if (null != tuwenDetailEntity) {
            setTitle(tuwenDetailEntity.getTitle());

            date.setText(tuwenDetailEntity.getDate());

            title.setText(tuwenDetailEntity.getTitle());

            type.setText(tuwenDetailEntity.getType());

            tuwenDetailAdapter.getDetailImgs().addAll(tuwenDetailEntity.getImgList());

            tuwenDetailAdapter.getDetailDes().addAll(tuwenDetailEntity.getDetailDes());

            tuwenDetailAdapter.notifyDataSetChanged();

        }

    }
}
