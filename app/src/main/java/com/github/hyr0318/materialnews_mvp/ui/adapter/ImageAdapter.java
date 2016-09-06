package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.entity.ImageResult;
import com.github.hyr0318.materialnews_mvp.ui.activity.ImagesDetailActivity;
import com.github.hyr0318.materialnews_mvp.ui.fragment.ImageFragment;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/2 12:03
 * 邮箱：2045446584@qq.com
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImgaeViewHolder> {

    public List<ImageResult.DataBean> data = new ArrayList<>();

    private Context mContext;
    private final LayoutInflater inflater;

    private ImageFragment imageFragment;


    public ImageAdapter(ImageFragment imageFragment, Context mContext) {

        inflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.imageFragment = imageFragment;
    }


    public List<ImageResult.DataBean> getData() {
        return data;
    }


    public void setData(List<ImageResult.DataBean> data) {
        this.data = data;
    }


    @Override
    public ImgaeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = inflater.inflate(R.layout.item_image_layout, parent, false);

        return new ImgaeViewHolder(inflate);
    }


    @Override public void onBindViewHolder(ImgaeViewHolder holder, int position) {

        Picasso.with(mContext).load(data.get(position).getThumbURL()).into(holder.imageView);



        holder.imageView.setOnClickListener(v -> {
            int[] location = new int[2];
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Rect frame = new Rect();
                imageFragment.getActivity().getWindow()
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
                data.get(position).getThumbURL());
            intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_X_TAG, location[0]);
            intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_Y_TAG, location[1]);
            intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_W_TAG, width);
            intent.putExtra(ImagesDetailActivity.PHOTO_SELECT_H_TAG, height);

            mContext.startActivity(intent);
            imageFragment.getActivity().overridePendingTransition(0, 0);
        });

    }


    @Override public int getItemCount() {
        return null != data ? data.size() : 0;
    }


    public class ImgaeViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;


        public ImgaeViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }
}
