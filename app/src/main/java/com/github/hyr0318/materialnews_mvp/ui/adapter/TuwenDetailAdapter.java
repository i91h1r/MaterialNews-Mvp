package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.entity.TuwenDetailEntity;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/8/31 14:34
 * 邮箱：2045446584@qq.com
 */
public class TuwenDetailAdapter
    extends RecyclerView.Adapter<TuwenDetailAdapter.TuwenDetailViewHolder> {

    private List<TuwenDetailEntity.DetailDes> detailDes = new ArrayList<>();

    private List<TuwenDetailEntity.DetailImg> detailImgs = new ArrayList<>();

    private Context mContext;


    public List<TuwenDetailEntity.DetailImg> getDetailImgs() {
        return detailImgs;
    }


    public List<TuwenDetailEntity.DetailDes> getDetailDes() {
        return detailDes;
    }


    public void setDetailDes(List<TuwenDetailEntity.DetailDes> detailDes) {
        this.detailDes = detailDes;
    }


    public void setDetailImgs(List<TuwenDetailEntity.DetailImg> detailImgs) {
        this.detailImgs = detailImgs;
    }


    public TuwenDetailAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public TuwenDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext)
            .inflate(R.layout.item_tuwen_detail_layout, parent, false);

        return new TuwenDetailViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(TuwenDetailViewHolder holder, int position) {

        Picasso.with(mContext).load(detailImgs.get(position).getImg()).into(holder.imageView);

        Log.i("size","des======"+detailDes.size()+"");

        Log.i("size","imgs====="+detailImgs.size()+"");
        Log.i("size","position====="+position+"");
        if(detailDes.size()>position){
            holder.des.setText(detailDes.get(position).getDes());
        }else {
            holder.des.setVisibility(View.INVISIBLE);

        }

    }


    @Override public int getItemCount() {

        return detailImgs != null ? detailImgs.size() : 0;
    }


    public class TuwenDetailViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView des;


        public TuwenDetailViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image);

            des = (TextView) itemView.findViewById(R.id.des);
        }
    }
}
