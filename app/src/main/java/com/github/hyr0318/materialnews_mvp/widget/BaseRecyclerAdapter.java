package com.github.hyr0318.materialnews_mvp.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.github.hyr0318.materialnews_mvp.R;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BaseRecyclerAdapter<p>
 * Author:oubowu<p>
 * Fuction: RecyclerView通用适配器<p>
 * CreateDate:2016/2/16 22:47<p>
 * UpdateUser:<p>
 * UpdateDate:<p>
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    protected List<T> mData;
    protected Context mContext;
    protected boolean mUseAnimation;
    private RecyclerView.LayoutManager mLayoutManager;
    protected LayoutInflater mInflater;
    protected OnItemClickListener mClickListener;
    protected OnItemLongClickListener onItemLongClick;

    public void setOnItemLongClick(OnItemLongClickListener onItemLongClick) {
        this.onItemLongClick = onItemLongClick;
    }


    public BaseRecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }


    public BaseRecyclerAdapter(Context context, List<T> data) {
        this(context, data, true);
    }

    public BaseRecyclerAdapter(Context context, List<T> data, boolean useAnimation) {
        this(context, data, useAnimation, null);
    }

    public BaseRecyclerAdapter(Context context, List<T> data, boolean useAnimation, RecyclerView.LayoutManager layoutManager) {
        mContext = context;
        mUseAnimation = useAnimation;
        mLayoutManager = layoutManager;
        mData = data == null ? new ArrayList<T>() : data;

    }


    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(mContext);
        final BaseRecyclerViewHolder holder = new BaseRecyclerViewHolder(mContext,
                mInflater.inflate(getItemLayoutId(viewType), parent, false));
        if (mClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(v, holder.getLayoutPosition(), holder.itemView.getTag());
                }
            });
        }

        if (onItemLongClick!=null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    return onItemLongClick.onItemLongClickListener(v,holder.getLayoutPosition());
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {

        holder.itemView.setTag(mData.get(position));

        bindData(holder, position, mData.get(position));
        if (mUseAnimation) {
            setAnimation(holder.itemView, position);
        }
    }

    private int lastPosition = -1;

    protected void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils
                    .loadAnimation(viewToAnimate.getContext(), R.anim.item_bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(BaseRecyclerViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (mUseAnimation && holder.itemView.getAnimation() != null && holder.itemView
                .getAnimation().hasStarted()) {
            holder.itemView.clearAnimation();
        }
    }

    public void add(int pos, T item) {
        mData.add(pos, item);
        notifyItemInserted(pos);
    }

    public void delete(int pos) {
        mData.remove(pos);
        notifyItemRemoved(pos);
    }

    public void delete(T data) {
        mData.remove(data);
    }

    public void addMoreData(List<T> data) {
        int startPos = mData.size();
        mData.addAll(data);
        notifyItemRangeInserted(startPos, data.size());
    }


    public List<T> getData() {
        return mData;
    }

    public void setData(List<T> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size()   : 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    public abstract int getItemLayoutId(int viewType);

    public abstract void bindData(BaseRecyclerViewHolder holder, int position, T item);



}
