package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiResult;
import com.github.hyr0318.materialnews_mvp.listener.OnRecyclerViewItemClickListener;
import com.github.hyr0318.materialnews_mvp.ui.activity.ImagesDetailActivity;
import com.github.hyr0318.materialnews_mvp.widget.CircleImageView;
import com.orhanobut.logger.Logger;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/1 11:39
 * 邮箱：2045446584@qq.com
 */
public class JokeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
    implements View.OnClickListener {
    private List<BaiSiResult.ListBean> baiSiResultList
        = new ArrayList<>();
    private OnRecyclerViewItemClickListener<BaiSiResult.ListBean>
        onRecyclerViewItemClickListener;
    private Context mContext;

    private FragmentActivity fragmentActivity;


    public OnRecyclerViewItemClickListener<BaiSiResult.ListBean> getOnRecyclerViewItemClickListener() {
        return onRecyclerViewItemClickListener;
    }


    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener<BaiSiResult.ListBean> onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }


    public List<BaiSiResult.ListBean> getBaiSiResultList() {
        return baiSiResultList;
    }


    public void setBaiSiResultList(List<BaiSiResult.ListBean> baiSiResultList) {
        this.baiSiResultList = baiSiResultList;
    }


    public JokeAdapter(Context mContext, FragmentActivity fragmentActivity) {
        this.mContext = mContext;
        this.fragmentActivity = fragmentActivity;
    }


    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (baiSiResultList != null) {
            switch (viewType) {
                case 1:
                    //图片
                    View inflate = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_joke_imag_layout, parent, false);
                    inflate.setOnClickListener(this);

                    return new ImageViewHolder(inflate);

                case 2:
                    //段子
                    View inflate1 = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_joke_duanzi_layout, parent, false);
                    inflate1.setOnClickListener(this);
                    return new DuanziViewHolder(inflate1);
                case 3:
                    View inflate2 = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_joke_gif_layout, parent, false);
                    inflate2.setOnClickListener(this);
                    return new ImageViewHolder(inflate2);
                case 0:
                    View inflate3 = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_joke_video_layout, parent, false);
                    inflate3.setOnClickListener(this);
                    return new VideoViewHoler(inflate3);
            }

        }

        return null;

    }


    @Override public int getItemViewType(int position) {

        String type = baiSiResultList.get(position).getType();

        switch (type) {
            case "video":
                return 0;
            case "gif":
                return 3;
            case "image":
                return 1;
            case "text":
                return 2;

        }
        return 2;
    }


    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        BaiSiResult.ListBean listBean = baiSiResultList.get(position);

        if (listBean != null) {

            if (holder instanceof ImageViewHolder) {
                holder.itemView.setTag(listBean);

                Glide.with(mContext)
                    .load(listBean.getU().getHeader().get(0))
                    .into(((ImageViewHolder) holder).profile_image);

                ((ImageViewHolder) holder).name.setText(listBean.getU().getName());

                ((ImageViewHolder) holder).create_time.setText(listBean.getPasstime());

                ((ImageViewHolder) holder).text.setText(listBean.getText());

                ((ImageViewHolder) holder).like.setText(listBean.getForward() + "");

                ((ImageViewHolder) holder).unlike.setText(listBean.getDown() + "");
                String image0;

                if (listBean.getType().equals("gif")) {
                    image0 = listBean.getGif().getImages().get(0);

                    Logger.d("gif=====", image0);
                    Glide.with(mContext)
                        .load(image0).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(((ImageViewHolder) holder).image0);

                } else {
                    image0 = listBean.getImage().getDownload_url().get(0);

                    Glide.with(mContext)
                        .load(image0)
                        .into(((ImageViewHolder) holder).image0);
                }

                ((ImageViewHolder) holder).image0.setOnClickListener(
                    view -> imageClick(listBean, view, position));

            } else if (holder instanceof DuanziViewHolder) {
                holder.itemView.setTag(listBean);

                Glide.with(mContext)
                    .load(listBean.getU().getHeader().get(0))
                    .into(((DuanziViewHolder) holder).profile_image);

                ((DuanziViewHolder) holder).name.setText(listBean.getU().getName());

                ((DuanziViewHolder) holder).create_time.setText(listBean.getPasstime());

                ((DuanziViewHolder) holder).content.setText(listBean.getText());

                ((DuanziViewHolder) holder).like.setText(listBean.getForward() + "");

                ((DuanziViewHolder) holder).unlike.setText(listBean.getDown() + "");
            } else if (holder instanceof VideoViewHoler) {
                holder.itemView.setTag(listBean);

                Glide.with(mContext)
                    .load(listBean.getU().getHeader().get(0))
                    .into(((VideoViewHoler) holder).profile_image);

                ((VideoViewHoler) holder).name.setText(listBean.getU().getName());

                ((VideoViewHoler) holder).create_time.setText(listBean.getPasstime());

                ((VideoViewHoler) holder).like.setText(listBean.getForward() + "");

                ((VideoViewHoler) holder).unlike.setText(listBean.getDown() + "");

                ((VideoViewHoler) holder).videoPlayerStandard.setUp(
                    listBean.getVideo().getVideo().get(0),
                    JCVideoPlayer.SCREEN_LAYOUT_LIST, listBean.getText());

                Glide.with(mContext)
                    .load(listBean.getVideo().getThumbnail().get(0))
                    .into(((VideoViewHoler) holder).videoPlayerStandard.thumbImageView);
            }

        }
    }


    private void imageClick(BaiSiResult.ListBean listBean, View v, int position) {

        int[] location = new int[2];
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Rect frame = new Rect();
            fragmentActivity.getWindow()
                .getDecorView()
                .getWindowVisibleDisplayFrame(frame);
            int statusBarHeight = frame.top;
            v.getLocationOnScreen(location);
            location[1] += statusBarHeight;
        } else {
            v.getLocationOnScreen(location);
        }
        v.invalidate();
        int width = v.getWidth();
        int height = v.getHeight();

        Intent intent = new Intent(mContext,
            ImagesDetailActivity.class);

        if (listBean.getType().equals("gif")) {
            intent.putExtra(ImagesDetailActivity.PHOTO_SOURCE_ID,
                listBean.getGif().getDownload_url().get(0));
        } else {
            intent.putExtra(ImagesDetailActivity.PHOTO_SOURCE_ID,
                listBean.getImage().getBig().get(0));
        }

        intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_X_TAG, location[0]);
        intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_Y_TAG, location[1]);
        intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_W_TAG, width);
        intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_H_TAG, height);

        mContext.startActivity(intent);
        fragmentActivity.overridePendingTransition(0, 0);

    }


    @Override public int getItemCount() {
        return baiSiResultList != null ? baiSiResultList.size() : 0;
    }


    @Override public void onClick(View view) {

        if (onRecyclerViewItemClickListener != null) {
            onRecyclerViewItemClickListener.onItemClick(view, (BaiSiResult.ListBean) view.getTag());
        }
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private final CircleImageView profile_image;
        private final TextView name;
        private final TextView create_time;
        private final TextView text;
        private final ImageView image0;

        private final TextView like;
        private final TextView unlike;


        public ImageViewHolder(View itemView) {
            super(itemView);
            profile_image = (CircleImageView) itemView.findViewById(R.id.profile_image);

            name = (TextView) itemView.findViewById(R.id.name);
            create_time = (TextView) itemView.findViewById(R.id.create_time);

            text = (TextView) itemView.findViewById(R.id.text);

            image0 = (ImageView) itemView.findViewById(R.id.image0);

            like = (TextView) itemView.findViewById(R.id.like);
            unlike = (TextView) itemView.findViewById(R.id.unlike);
        }
    }


    public class DuanziViewHolder extends RecyclerView.ViewHolder {

        private final CircleImageView profile_image;
        private final TextView name;
        private final TextView create_time;
        private final TextView content;
        private final TextView like;
        private final TextView unlike;


        public DuanziViewHolder(View itemView) {
            super(itemView);
            profile_image = (CircleImageView) itemView.findViewById(R.id.profile_image);

            name = (TextView) itemView.findViewById(R.id.name);
            create_time = (TextView) itemView.findViewById(R.id.create_time);

            content = (TextView) itemView.findViewById(R.id.content);

            like = (TextView) itemView.findViewById(R.id.like);
            unlike = (TextView) itemView.findViewById(R.id.unlike);

        }
    }


    public class VideoViewHoler extends RecyclerView.ViewHolder {
        private final CircleImageView profile_image;
        private final TextView name;
        private final TextView create_time;

        private final TextView like;
        private final TextView unlike;
        private final JCVideoPlayerStandard videoPlayerStandard;


        public VideoViewHoler(View itemView) {
            super(itemView);
            profile_image = (CircleImageView) itemView.findViewById(R.id.profile_image);

            name = (TextView) itemView.findViewById(R.id.name);
            create_time = (TextView) itemView.findViewById(R.id.create_time);

            like = (TextView) itemView.findViewById(R.id.like);
            unlike = (TextView) itemView.findViewById(R.id.unlike);
            videoPlayerStandard = (JCVideoPlayerStandard) itemView.findViewById(
                R.id.video);
        }
    }
}
