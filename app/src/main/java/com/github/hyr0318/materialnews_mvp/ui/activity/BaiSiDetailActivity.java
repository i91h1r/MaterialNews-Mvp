package com.github.hyr0318.materialnews_mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.hyr0318.baselibrary.base.activity.BaseActivity;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.net.NetUtils;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.BaiSiDetailContract;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiDetailResult;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiResult;
import com.github.hyr0318.materialnews_mvp.presenter.BaiSiDetailPresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.adapter.BaiSiCommentAdapter;
import com.github.hyr0318.materialnews_mvp.widget.CircleImageView;
import com.github.hyr0318.materialnews_mvp.widget.FullyLinearLayoutManager;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/12 17:37
 * 邮箱：2045446584@qq.com
 */
public class BaiSiDetailActivity extends BaseActivity
    implements BaiSiDetailContract.BaiSiDetailView, BGARefreshLayout.BGARefreshLayoutDelegate {

    private RelativeLayout content;
    private BaiSiResult.ListBean entity;

    private int mCurrentPage;
    private RecyclerView recyclerView;
    private BGARefreshLayout bgaRefreshLayout;
    private BaiSiCommentAdapter baiSiCommentAdapter;
    private Toolbar toolbar;


    @Override protected void getViewById() {

        content = (RelativeLayout) findViewById(R.id.content);

        recyclerView = (RecyclerView) findViewById(R.id.rcy);

        bgaRefreshLayout = (BGARefreshLayout) findViewById(R.id.bga);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }


    @Override protected View getLoadingView() {
        return null;
    }


    @Override protected void initViewsAndEvents() {

        switch (entity.getType()) {

            case "video":
                View videoView = LayoutInflater.from(this)
                    .inflate(R.layout.item_joke_video_layout, null);

                content.addView(videoView);

                CircleImageView mIcon = (CircleImageView) videoView.findViewById(
                    R.id.profile_image);
                TextView name = (TextView) videoView.findViewById(R.id.name);

                TextView create_time = (TextView) videoView.findViewById(R.id.create_time);

                JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(
                    R.id.video);

                TextView like = (TextView) videoView.findViewById(R.id.like);

                TextView unLike = (TextView) videoView.findViewById(R.id.unlike);

                Glide.with(this).load(entity.getU().getHeader().get(0)).into(mIcon);

                name.setText(entity.getU().getName());

                create_time.setText(entity.getPasstime());

                jcVideoPlayerStandard.setUp(entity.getVideo().getVideo().get(0),
                    JCVideoPlayer.SCREEN_LAYOUT_LIST, entity.getText());

                like.setText(entity.getForward() + "");

                unLike.setText(entity.getDown() + "");

                break;
            case "image":

                View imageView = LayoutInflater.from(this)
                    .inflate(R.layout.item_joke_imag_layout, null);

                content.addView(imageView);

                CircleImageView iIcon = (CircleImageView) imageView.findViewById(
                    R.id.profile_image);
                TextView iName = (TextView) imageView.findViewById(R.id.name);

                TextView iCreateTime = (TextView) imageView.findViewById(R.id.create_time);

                TextView text = (TextView) imageView.findViewById(R.id.text);

                ImageView imageView0 = (ImageView) imageView.findViewById(R.id.image0);

                TextView iLike = (TextView) imageView.findViewById(R.id.like);

                TextView iUnLike = (TextView) imageView.findViewById(R.id.unlike);

                Glide.with(this).load(entity.getU().getHeader().get(0)).into(iIcon);

                iName.setText(entity.getU().getName());

                iCreateTime.setText(entity.getPasstime());

                iLike.setText(entity.getForward() + "");

                iUnLike.setText(entity.getDown() + "");

                text.setText(entity.getText());

                Glide.with(this).load(entity.getImage().getDownload_url().get(0)).into(imageView0);

                break;

            case "gif":
                View gifView = LayoutInflater.from(this)
                    .inflate(R.layout.item_joke_gif_layout, null);

                content.addView(gifView);

                CircleImageView gIcon = (CircleImageView) gifView.findViewById(
                    R.id.profile_image);
                TextView gName = (TextView) gifView.findViewById(R.id.name);

                TextView gCreateTime = (TextView) gifView.findViewById(R.id.create_time);

                TextView gText = (TextView) gifView.findViewById(R.id.text);

                ImageView gImageView0 = (ImageView) gifView.findViewById(R.id.image0);

                TextView gLike = (TextView) gifView.findViewById(R.id.like);

                TextView gUnLike = (TextView) gifView.findViewById(R.id.unlike);

                Glide.with(this).load(entity.getU().getHeader().get(0)).into(gIcon);

                gName.setText(entity.getU().getName());

                gCreateTime.setText(entity.getPasstime());

                gLike.setText(entity.getForward() + "");

                gUnLike.setText(entity.getDown() + "");

                gText.setText(entity.getText());

                Glide.with(this)
                    .load(entity.getGif().getImages().get(0))
                    .asGif()
                    .diskCacheStrategy(
                        DiskCacheStrategy.SOURCE)
                    .into(gImageView0);

                break;
            case "text":
                View textView = LayoutInflater.from(this)
                    .inflate(R.layout.item_joke_duanzi_layout, null);

                content.addView(textView);

                CircleImageView tIcon = (CircleImageView) textView.findViewById(
                    R.id.profile_image);
                TextView tName = (TextView) textView.findViewById(R.id.name);

                TextView tCreateTime = (TextView) textView.findViewById(R.id.create_time);

                TextView tLike = (TextView) textView.findViewById(R.id.like);

                TextView tUnLike = (TextView) textView.findViewById(R.id.unlike);

                TextView tvContent = (TextView) textView.findViewById(R.id.content);

                tLike.setText(entity.getForward() + "");

                tUnLike.setText(entity.getDown() + "");

                Glide.with(this).load(entity.getU().getHeader().get(0)).into(tIcon);

                tName.setText(entity.getU().getName());

                tCreateTime.setText(entity.getPasstime());

                tvContent.setText(entity.getText());

                break;

            case "audio":
                View audioView = LayoutInflater.from(this)
                    .inflate(R.layout.item_joke_duanzi_layout, null);

                content.addView(audioView);

                CircleImageView aIcon = (CircleImageView) audioView.findViewById(
                    R.id.profile_image);
                TextView aName = (TextView) audioView.findViewById(R.id.name);

                TextView aCreateTime = (TextView) audioView.findViewById(R.id.create_time);

                TextView aLike = (TextView) audioView.findViewById(R.id.like);

                TextView aUnLike = (TextView) audioView.findViewById(R.id.unlike);

                TextView avContent = (TextView) audioView.findViewById(R.id.content);

                aLike.setText(entity.getForward() + "");

                aUnLike.setText(entity.getDown() + "");

                Glide.with(this).load(entity.getU().getHeader().get(0)).into(aIcon);

                aName.setText(entity.getU().getName());

                aCreateTime.setText(entity.getPasstime());

                avContent.setText(entity.getText());
                break;
        }

        BaiSiDetailPresenterImpl baiSiDetailPresenter = new BaiSiDetailPresenterImpl(mContext,
            this);

        baiSiDetailPresenter.loadCommentList(TAG_LOG, Constants.EVENT_REFRESH_DATA, mCurrentPage,
            entity.getId(), false);

        bgaRefreshLayout.setDelegate(this);

        bgaRefreshLayout.setPullDownRefreshEnable(false);

        BGANormalRefreshViewHolder bgaNormalRefreshViewHolder = new BGANormalRefreshViewHolder(this,
            true);

        bgaRefreshLayout.setRefreshViewHolder(bgaNormalRefreshViewHolder);

        baiSiCommentAdapter = new BaiSiCommentAdapter(mContext);

        recyclerView.setLayoutManager(new FullyLinearLayoutManager(this));

        recyclerView.setAdapter(baiSiCommentAdapter);

    }


    @Override protected void getIntentExtras(Bundle extras) {

        entity = extras.getParcelable("entity");

        String type = entity.getType();

        Log.d("BaiSiDetailActivity", "type ==============" + type);
    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }


    @Override protected int getContentViewLayoutID() {
        return R.layout.activity_baisi_deail_layout;
    }


    @Override protected void onNetworkConnected(NetUtils.NetType type) {

    }


    @Override protected void onNetworkDisConnected() {

    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override public void initCommentList(BaiSiDetailResult baiSiDetailResult) {
        List<BaiSiDetailResult.DataBean> data = baiSiDetailResult.getData();

        baiSiCommentAdapter.getData().addAll(data);

        baiSiCommentAdapter.notifyDataSetChanged();

    }


    @Override public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {

    }


    @Override public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }
}
