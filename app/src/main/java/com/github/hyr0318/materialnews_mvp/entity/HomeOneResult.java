package com.github.hyr0318.materialnews_mvp.entity;

/**
 * Description:
 * 作者：hyr on 2016/9/9 10:57
 * 邮箱：2045446584@qq.com
 */
public class HomeOneResult extends BaseResult {

    /**
     * res : 0
     * data : {"hpcontent_id":"1457","hp_title":"VOL.1432","author_id":"-1","hp_img_url":"http://image.wufazhuce.com/Fuj_SS-1K3Evk-055OwtSual7xF7","hp_img_original_url":"http://image.wufazhuce.com/Fuj_SS-1K3Evk-055OwtSual7xF7","hp_author":"相伴&排骨chop 作品","ipad_url":"http://image.wufazhuce.com/FiBABZzzMYVx6DEBPOTWjK9WsnY6","hp_content":"为什么会怀念过去？原因很简单。那时候你除了丰沛的感情之外一无所有。当你步入一个年纪，所有人都开始渴望索取，通过计算所得，衡量一件事或一个人的价值。在为整个世界估价的同时，人就越来越难被满足。不是变坏了，只是变老了。 by 赫恩曼尼","hp_makettime":"2016-09-07 21:00:00","last_update_date":"2016-09-01 15:50:40","web_url":"http://m.wufazhuce.com/one/1457","wb_img_url":"","praisenum":18478,"sharenum":3156,"commentnum":0}
     */

    private int res;
    /**
     * hpcontent_id : 1457
     * hp_title : VOL.1432
     * author_id : -1
     * hp_img_url : http://image.wufazhuce.com/Fuj_SS-1K3Evk-055OwtSual7xF7
     * hp_img_original_url : http://image.wufazhuce.com/Fuj_SS-1K3Evk-055OwtSual7xF7
     * hp_author : 相伴&排骨chop 作品
     * ipad_url : http://image.wufazhuce.com/FiBABZzzMYVx6DEBPOTWjK9WsnY6
     * hp_content : 为什么会怀念过去？原因很简单。那时候你除了丰沛的感情之外一无所有。当你步入一个年纪，所有人都开始渴望索取，通过计算所得，衡量一件事或一个人的价值。在为整个世界估价的同时，人就越来越难被满足。不是变坏了，只是变老了。 by 赫恩曼尼
     * hp_makettime : 2016-09-07 21:00:00
     * last_update_date : 2016-09-01 15:50:40
     * web_url : http://m.wufazhuce.com/one/1457
     * wb_img_url :
     * praisenum : 18478
     * sharenum : 3156
     * commentnum : 0
     */

    private DataBean data;


    public int getRes() { return res;}


    public void setRes(int res) { this.res = res;}


    public DataBean getData() { return data;}


    public void setData(DataBean data) { this.data = data;}


    public static class DataBean {
        private String hpcontent_id;
        private String hp_title;
        private String author_id;
        private String hp_img_url;
        private String hp_img_original_url;
        private String hp_author;
        private String ipad_url;
        private String hp_content;
        private String hp_makettime;
        private String last_update_date;
        private String web_url;
        private String wb_img_url;
        private int praisenum;
        private int sharenum;
        private int commentnum;


        public String getHpcontent_id() { return hpcontent_id;}


        public void setHpcontent_id(String hpcontent_id) { this.hpcontent_id = hpcontent_id;}


        public String getHp_title() { return hp_title;}


        public void setHp_title(String hp_title) { this.hp_title = hp_title;}


        public String getAuthor_id() { return author_id;}


        public void setAuthor_id(String author_id) { this.author_id = author_id;}


        public String getHp_img_url() { return hp_img_url;}


        public void setHp_img_url(String hp_img_url) { this.hp_img_url = hp_img_url;}


        public String getHp_img_original_url() { return hp_img_original_url;}


        public void setHp_img_original_url(String hp_img_original_url) {
            this.hp_img_original_url = hp_img_original_url;
        }


        public String getHp_author() { return hp_author;}


        public void setHp_author(String hp_author) { this.hp_author = hp_author;}


        public String getIpad_url() { return ipad_url;}


        public void setIpad_url(String ipad_url) { this.ipad_url = ipad_url;}


        public String getHp_content() { return hp_content;}


        public void setHp_content(String hp_content) { this.hp_content = hp_content;}


        public String getHp_makettime() { return hp_makettime;}


        public void setHp_makettime(String hp_makettime) { this.hp_makettime = hp_makettime;}


        public String getLast_update_date() { return last_update_date;}


        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }


        public String getWeb_url() { return web_url;}


        public void setWeb_url(String web_url) { this.web_url = web_url;}


        public String getWb_img_url() { return wb_img_url;}


        public void setWb_img_url(String wb_img_url) { this.wb_img_url = wb_img_url;}


        public int getPraisenum() { return praisenum;}


        public void setPraisenum(int praisenum) { this.praisenum = praisenum;}


        public int getSharenum() { return sharenum;}


        public void setSharenum(int sharenum) { this.sharenum = sharenum;}


        public int getCommentnum() { return commentnum;}


        public void setCommentnum(int commentnum) { this.commentnum = commentnum;}
    }
}
