package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.entity.TouTiaoVideoResult;
import com.github.hyr0318.materialnews_mvp.listener.OnRecyclerViewItemClickListener;
import com.github.hyr0318.materialnews_mvp.widget.CircleImageView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/8/29 14:45
 * 邮箱：2045446584@qq.com
 */
public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoListViewHolder>
    implements View.OnClickListener {

    private  List<TouTiaoVideoResult.DataBean> data = new ArrayList<>();

    private Context mContext;

    private OnRecyclerViewItemClickListener<TouTiaoVideoResult.DataBean> onRecyclerViewItemClickListener;

    private  String mCurrentType;
    public VideoListAdapter(Context context, String mCurrentType) {
        super();

        this.mContext = context;

        this.mCurrentType = mCurrentType;
    }


    @Override
    public VideoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext)
            .inflate(R.layout.video_list_item, parent, false);

        view.setOnClickListener(this);
        return new VideoListViewHolder(view);
    }


    @Override public void onBindViewHolder(VideoListViewHolder holder, int position) {

      if(data != null ){
          
          TouTiaoVideoResult.DataBean dataBean = data.get(position);

          holder.itemView.setTag(dataBean);

          holder.comment.setText(dataBean.getDatetime());

          if (null != dataBean.getMedia_avatar_url() &&
              !TextUtils.isEmpty(dataBean.getMedia_avatar_url())) {
              Picasso.with(mContext).load(dataBean.getMedia_avatar_url()).into(holder.image_url);
          }

          holder.source.setText(dataBean.getSource());

          holder.title.setText(dataBean.getTitle());

          Picasso.with(mContext).load(dataBean.getImage_url()).into(holder.thumb);
      }

    }


    @Override public int getItemCount() {
        return data != null ? data.size() : 0;
    }


    @Override public void onClick(View view) {

        if(null != onRecyclerViewItemClickListener){
            onRecyclerViewItemClickListener.onItemClick(view,
                ((TouTiaoVideoResult.DataBean) view.getTag()));
        }
    }


    public class VideoListViewHolder extends RecyclerView.ViewHolder {

        private final ImageView thumb;
        private final TextView title;
        private final CircleImageView image_url;
        private final TextView source;
        private final TextView comment;


        public VideoListViewHolder(View itemView) {
            super(itemView);
            thumb = (ImageView) itemView.findViewById(R.id.thumb);

            title = (TextView) itemView.findViewById(R.id.title);

            image_url = (CircleImageView) itemView.findViewById(R.id.image_url);

            source = (TextView) itemView.findViewById(R.id.source);

            comment = (TextView) itemView.findViewById(R.id.comment);
        }

    }

    public  List<TouTiaoVideoResult.DataBean> getDataList(){
        return data;
    }


    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener<TouTiaoVideoResult.DataBean> onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}
