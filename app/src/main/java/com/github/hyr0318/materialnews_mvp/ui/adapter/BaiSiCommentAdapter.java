package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiDetailResult;
import com.github.hyr0318.materialnews_mvp.widget.CircleImageView;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/13 11:37
 * 邮箱：2045446584@qq.com
 */
public class BaiSiCommentAdapter
    extends RecyclerView.Adapter<BaiSiCommentAdapter.CommentViewHolder> {

    private List<BaiSiDetailResult.DataBean> data = new ArrayList<>();
    private final LayoutInflater inflater;

    private  Context mContext ;

    public BaiSiCommentAdapter(Context mContext) {
        inflater = LayoutInflater.from(mContext);
        this.mContext =mContext;
    }


    public List<BaiSiDetailResult.DataBean> getData() {
        return data;
    }


    public void setData(List<BaiSiDetailResult.DataBean> data) {
        this.data = data;
    }


    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.item_baisi_comment_layout, parent, false);

        return new CommentViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {

        BaiSiDetailResult.DataBean comment = data.get(position);

        Glide.with(mContext).load(comment.getUser().getProfile_image()).into(holder.icon);

        holder.username.setText(comment.getUser().getUsername());

        holder.comment.setText(comment.getContent());


    }


    @Override public int getItemCount() {
        return data != null ? data.size() : 0;
    }


    public class CommentViewHolder extends RecyclerView.ViewHolder {

        private final TextView comment;
        private final TextView username;
        private final CircleImageView icon;


        public CommentViewHolder(View itemView) {
            super(itemView);

            comment = (TextView) itemView.findViewById(R.id.comment);
            username = (TextView) itemView.findViewById(R.id.username);

            icon = (CircleImageView) itemView.findViewById(R.id.icon);
        }
    }
}
