package com.github.hyr0318.materialnews_mvp.entity;

/**
 * Author: hyr on 2016/8/28.
 * Email:2045446584@qq.com
 */
public class HomeNavigationEntity {

    int iconResID;

    String iconName ;

    String iconID;


    public HomeNavigationEntity(int iconResID, String iconName, String iconID) {
        this.iconResID = iconResID;
        this.iconName = iconName;
        this.iconID = iconID;
    }


    public int getIconResID() {
        return iconResID;
    }


    public void setIconResID(int iconResID) {
        this.iconResID = iconResID;
    }


    public String getIconName() {
        return iconName;
    }


    public void setIconName(String iconName) {
        this.iconName = iconName;
    }


    public String getIconID() {
        return iconID;
    }


    public void setIconID(String iconID) {
        this.iconID = iconID;
    }
}
