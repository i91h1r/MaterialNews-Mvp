package com.github.hyr0318.materialnews_mvp.model;
import android.content.Context;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.contract.TuwenMainContract;
import com.github.hyr0318.materialnews_mvp.entity.TuwenTabBaseEntity;
import java.util.ArrayList;
import java.util.List;

/**
* Created by MVPHelper on 2016/09/01
*/

public class TuwenMainModelImpl implements TuwenMainContract.TuwenMainModel{



    @Override public List<TuwenTabBaseEntity> getTabList(Context context) {

        List<TuwenTabBaseEntity> tabBaseEntities = new ArrayList<>();

        String[] typeArray = context.getResources().getStringArray(R.array.tab_array_tuwen_type);
        String[] nameArray = context.getResources().getStringArray(R.array.tab_array_tuwen_name);

        tabBaseEntities.add(new TuwenTabBaseEntity(typeArray[0],nameArray[0]));
        tabBaseEntities.add(new TuwenTabBaseEntity(typeArray[1],nameArray[1]));
        tabBaseEntities.add(new TuwenTabBaseEntity(typeArray[2],nameArray[2]));
        tabBaseEntities.add(new TuwenTabBaseEntity(typeArray[3],nameArray[3]));
        tabBaseEntities.add(new TuwenTabBaseEntity(typeArray[4],nameArray[4]));

        return tabBaseEntities;
    }
}