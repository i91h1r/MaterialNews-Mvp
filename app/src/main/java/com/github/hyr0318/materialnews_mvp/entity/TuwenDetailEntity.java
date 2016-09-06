package com.github.hyr0318.materialnews_mvp.entity;

import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/8/31 12:11
 * 邮箱：2045446584@qq.com
 */
public class TuwenDetailEntity {

    String title ;

    String type ;


    String date;

    String des ;


        List<DetailImg> imgList ;


    List<DetailDes> detailDes;


    public class DetailImg {
        String img ;


        public DetailImg(String img) {
            this.img = img;
        }


        public String getImg() {
            return img;
        }


        public void setImg(String img) {
            this.img = img;
        }
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getDes() {
        return des;
    }


    public void setDes(String des) {
        this.des = des;
    }


    public List<DetailImg> getImgList() {
        return imgList;
    }


    public void setImgList(List<DetailImg> imgList) {
        this.imgList = imgList;
    }


    public class DetailDes {
        String des ;


        public String getDes() {
            return des;
        }


        public void setDes(String des) {
            this.des = des;
        }
    }


    public List<DetailDes> getDetailDes() {
        return detailDes;
    }


    public void setDetailDes(List<DetailDes> detailDes) {
        this.detailDes = detailDes;
    }
}
