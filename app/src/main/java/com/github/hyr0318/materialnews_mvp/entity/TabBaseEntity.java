package com.github.hyr0318.materialnews_mvp.entity;

/**
 * Description:
 * 作者：hyr on 2016/8/29 10:32
 * 邮箱：2045446584@qq.com
 */
public class TabBaseEntity {
    String type ;

    String name ;


    public TabBaseEntity(String type, String name) {
        this.type = type;
        this.name = name;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
