package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.entity.JokeResult;
import com.github.hyr0318.materialnews_mvp.listener.OnRecyclerViewItemClickListener;
import com.github.hyr0318.materialnews_mvp.ui.activity.ImagesDetailActivity;
import com.github.hyr0318.materialnews_mvp.widget.CircleImageView;
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
    private List<JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist
        = new ArrayList<>();
    private OnRecyclerViewItemClickListener<JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean>
        onRecyclerViewItemClickListener;
    private Context mContext;

    private  FragmentActivity fragmentActivity ;

    public List<JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean> getContentlist() {
        return contentlist;
    }


    public OnRecyclerViewItemClickListener<JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean> getOnRecyclerViewItemClickListener() {
        return onRecyclerViewItemClickListener;
    }


    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener<JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean> onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }


    public void setContentlist(List<JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist) {
        this.contentlist = contentlist;



    }


    public JokeAdapter(Context mContext, FragmentActivity fragmentActivity) {
        this.mContext = mContext;
        this.fragmentActivity = fragmentActivity;
    }


    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (contentlist != null) {
            switch (viewType) {
                case 10:
                    //图片
                    View inflate = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_joke_imag_layout, parent, false);
                    inflate.setOnClickListener(this);
                    return new ImageViewHolder(inflate);

                case 29:
                    //段子
                    View inflate1 = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_joke_duanzi_layout, parent, false);
                    inflate1.setOnClickListener(this);
                    return new DuanziViewHolder(inflate1);
                case 31:
                    View inflate2 = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_joke_imag_layout, parent, false);
                    inflate2.setOnClickListener(this);
                    return new ImageViewHolder(inflate2);
                case 41:
                    View inflate3 = LayoutInflater.from(mContext)
                        .inflate(R.layout.item_joke_video_layout, parent, false);
                    inflate3.setOnClickListener(this);
                    return new VideoViewHoler(inflate3);
            }

        }

        return null;

    }


    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean contentlistBean
            = contentlist.get(position);

        if (contentlist != null) {

            if (holder instanceof ImageViewHolder) {
                holder.itemView.setTag(contentlistBean);

                Glide.with(mContext)
                    .load(contentlistBean.getProfile_image())
                    .into(((ImageViewHolder) holder).profile_image);

                ((ImageViewHolder) holder).name.setText(contentlistBean.getName());

                ((ImageViewHolder) holder).create_time.setText(contentlistBean.getCreate_time());

                ((ImageViewHolder) holder).text.setText(contentlistBean.getText());

                ((ImageViewHolder) holder).like.setText(contentlistBean.getLove());

                ((ImageViewHolder) holder).unlike.setText(contentlistBean.getHate());

                String image0 = contentlistBean.getImage0();

                if(null != image0){
                    boolean gif = image0.endsWith("gif");


                if (!gif) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                    ((ImageViewHolder) holder).image0.setLayoutParams(layoutParams);
                } else {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        500,
                        500);
                    layoutParams.gravity = Gravity.CENTER;
                    ((ImageViewHolder) holder).image0.setLayoutParams(layoutParams);
                }
                }

                ((ImageViewHolder) holder).image0.setOnClickListener(view -> imageClick(contentlistBean,view,position));


                Glide.with(mContext)
                    .load(contentlistBean.getImage0())
                    .into(((ImageViewHolder) holder).image0);

            } else if (holder instanceof DuanziViewHolder) {
                holder.itemView.setTag(contentlistBean);

                Glide.with(mContext)
                    .load(contentlistBean.getProfile_image())
                    .into(((DuanziViewHolder) holder).profile_image);

                ((DuanziViewHolder) holder).name.setText(contentlistBean.getName());

                ((DuanziViewHolder) holder).create_time.setText(contentlistBean.getCreate_time());

                ((DuanziViewHolder) holder).content.setText(contentlistBean.getText());

                ((DuanziViewHolder) holder).like.setText(contentlistBean.getLove());

                ((DuanziViewHolder) holder).unlike.setText(contentlistBean.getHate());
            } else if (holder instanceof VideoViewHoler) {
                holder.itemView.setTag(contentlistBean);

                Glide.with(mContext)
                    .load(contentlistBean.getProfile_image())
                    .into(((VideoViewHoler) holder).profile_image);

                ((VideoViewHoler) holder).name.setText(contentlistBean.getName());

                ((VideoViewHoler) holder).create_time.setText(contentlistBean.getCreate_time());

                ((VideoViewHoler) holder).like.setText(contentlistBean.getLove());

                ((VideoViewHoler) holder).unlike.setText(contentlistBean.getHate());

                ((VideoViewHoler) holder).videoPlayerStandard.setUp(contentlistBean.getVideo_uri(),
                    JCVideoPlayer.SCREEN_LAYOUT_LIST, contentlistBean.getText());

            }

        }
    }


    private void imageClick(JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean contentlistBean, View v, int position) {

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

        intent.putExtra(ImagesDetailActivity.PHOTO_SOURCE_ID,
            contentlistBean.getImage0());
        intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_X_TAG, location[0]);
        intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_Y_TAG, location[1]);
        intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_W_TAG, width);
        intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_H_TAG, height);

        mContext.startActivity(intent);
        fragmentActivity.overridePendingTransition(0, 0);

    }


    @Override public int getItemCount() {
        return contentlist != null ? contentlist.size() : 0;
    }


    @Override public int getItemViewType(int position) {
        return contentlist != null ? Integer.parseInt(contentlist.get(position).getType()) : -1;
    }


    @Override public void onClick(View view) {

        if (null != onRecyclerViewItemClickListener) {
            onRecyclerViewItemClickListener.onItemClick(view,
                (JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean) view.getTag());
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
