package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.entity.TuwenEntity;
import com.github.hyr0318.materialnews_mvp.widget.BaseRecyclerAdapter;
import com.github.hyr0318.materialnews_mvp.widget.BaseRecyclerViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Description:
 * 作者：hyr on 2016/8/31 10:18
 * 邮箱：2045446584@qq.com
 */
public class TuwenAapter extends BaseRecyclerAdapter<TuwenEntity> {

    public TuwenAapter(Context mContext) {
        super(mContext);
    }


    @Override public int getItemLayoutId(int viewType) {
        return R.layout.item_tuwen_layout;
    }


    @Override public void bindData(BaseRecyclerViewHolder holder, int position, TuwenEntity item) {

        Picasso.with(mContext).load(item.getThumb()).into(holder.getImageView(R.id.thumb));

        holder.getTextView(R.id.type).setText(item.getType());

        holder.getTextView(R.id.author).setText(item.getAuthor());

        holder.getTextView(R.id.data).setText(item.getDate());

        holder.getTextView(R.id.title).setText(item.getTitle());

        holder.getTextView(R.id.des).setText(item.getDes());
    }
}
