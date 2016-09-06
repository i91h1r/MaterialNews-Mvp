package com.github.hyr0318.materialnews_mvp.listener;

import android.view.View;

/**
 * Description:
 * 作者：hyr on 2016/8/30 13:13
 * 邮箱：2045446584@qq.com
 */
public interface OnRecyclerViewItemClickListener<T> {
    void onItemClick(View view, T entity);
}