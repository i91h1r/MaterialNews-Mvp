package com.github.hyr0318.materialnews_mvp.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Description:
 * 作者：hyr on 2016/9/2 12:12
 * 邮箱：2045446584@qq.com
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space;


    public SpacesItemDecoration(int space) {
        this.space = space;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = space;
        }
    }
}