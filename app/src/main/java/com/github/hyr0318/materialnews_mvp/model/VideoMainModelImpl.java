package com.github.hyr0318.materialnews_mvp.model;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.entity.TabBaseEntity;
import com.github.hyr0318.materialnews_mvp.contract.VideoMainContract;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MVPHelper on 2016/08/29
 */

public class VideoMainModelImpl implements VideoMainContract.VideoMainModel {

    @Override public List<TabBaseEntity> getTabList(Context context) {
        List<TabBaseEntity> list = new ArrayList<>();

        String[] tabArrayType = context.getResources().getStringArray(R.array.tab_array_type);
        String[] tabArrayName = context.getResources().getStringArray(R.array.tab_array_name);

        list.add(new TabBaseEntity(tabArrayType[0], tabArrayName[0]));
        list.add(new TabBaseEntity(tabArrayType[1], tabArrayName[1]));
        list.add(new TabBaseEntity(tabArrayType[2], tabArrayName[2]));
        list.add(new TabBaseEntity(tabArrayType[3], tabArrayName[3]));
        list.add(new TabBaseEntity(tabArrayType[4], tabArrayName[4]));
        return list;
    }
}