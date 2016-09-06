package com.github.hyr0318.materialnews_mvp.model;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.contract.ImageMainContract;
import com.github.hyr0318.materialnews_mvp.entity.TabBaseEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MVPHelper on 2016/09/02
 */

public class ImageMainModelImpl implements ImageMainContract.ImageMainModel {

    @Override public List<TabBaseEntity> getTabList(Context context) {

        String[] stringArray = context.getResources().getStringArray(R.array.baidu_image_tab_type);

        List<TabBaseEntity> tabBaseEntities = new ArrayList<>();

        tabBaseEntities.add(new TabBaseEntity(stringArray[0], stringArray[0]));
        tabBaseEntities.add(new TabBaseEntity(stringArray[1], stringArray[1]));
        tabBaseEntities.add(new TabBaseEntity(stringArray[2], stringArray[2]));
        tabBaseEntities.add(new TabBaseEntity(stringArray[3], stringArray[3]));
        tabBaseEntities.add(new TabBaseEntity(stringArray[4], stringArray[4]));
        tabBaseEntities.add(new TabBaseEntity(stringArray[5], stringArray[5]));
        tabBaseEntities.add(new TabBaseEntity(stringArray[6], stringArray[6]));
        tabBaseEntities.add(new TabBaseEntity(stringArray[7], stringArray[7]));

        return tabBaseEntities;
    }
}