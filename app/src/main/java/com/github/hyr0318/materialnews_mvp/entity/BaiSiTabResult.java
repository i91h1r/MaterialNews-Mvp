package com.github.hyr0318.materialnews_mvp.entity;

import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/9 15:29
 * 邮箱：2045446584@qq.com
 */
public class BaiSiTabResult extends BaseResult {

    /**
     * offline_day_3 : 0_0
     * initial : 0_0
     * offline_day_7 : 0_5
     */

    private DefaultMenuBean default_menu;
    /**
     * name : 精华
     * submenus : [{"url":"http://s.budejie.com/topic/list/jingxuan/1/","god_topic_type":"nan","type":"topic","entrytype":"self.koushu.android.feed.16081610415837","name":"推荐"},{"url":"http://s.budejie.com/topic/list/jingxuan/41/","god_topic_type":"nan","type":"topic","entrytype":"self.koushu.android.feed.16081610415837","name":"视频"},{"url":"http://s.budejie.com/topic/list/jingxuan/10/","god_topic_type":"nan","type":"topic","entrytype":"self.koushu.android.feed.16081610415837","name":"图片"},{"url":"http://s.budejie.com/topic/tag-topic/64/hot/","god_topic_type":"nan","type":"topic","entrytype":"self.koushu.android.feed.16081610415837","name":"段子"},{"url":"http://s.budejie.com/topic/tag-topic/3096/hot/","god_topic_type":"nan","type":"topic","entrytype":"self.koushu.android.feed.16081610415837","name":"网红"},{"url":"http://s.budejie.com/topic/list/remen/1/","god_topic_type":"nan","type":"topic","entrytype":"self.koushu.android.feed.16081610415837","name":"排行"},{"url":"http://s.budejie.com/topic/tag-topic/473/hot/","god_topic_type":"nan","type":"topic","entrytype":"self.koushu.android.feed.16081610415837","name":"社会"},{"url":"http://s.budejie.com/topic/tag-topic/117/hot/","god_topic_type":"nan","type":"topic","entrytype":"self.koushu.android.feed.16081610415837","name":"美女"},{"url":"http://s.budejie.com/topic/tag-topic/3176/hot/","god_topic_type":"nan","type":"topic","entrytype":"self.koushu.android.feed.16081610415837","name":"冷知识"},{"url":"http://s.budejie.com/topic/tag-topic/164/hot/","god_topic_type":"nan","type":"topic","entrytype":"self.koushu.android.feed.16081610415837","name":"游戏"}]
     */

    private List<MenusBean> menus;


    public DefaultMenuBean getDefault_menu() { return default_menu;}


    public void setDefault_menu(DefaultMenuBean default_menu) { this.default_menu = default_menu;}


    public List<MenusBean> getMenus() { return menus;}


    public void setMenus(List<MenusBean> menus) { this.menus = menus;}


    public static class DefaultMenuBean {
        private String offline_day_3;
        private String initial;
        private String offline_day_7;


        public String getOffline_day_3() { return offline_day_3;}


        public void setOffline_day_3(String offline_day_3) { this.offline_day_3 = offline_day_3;}


        public String getInitial() { return initial;}


        public void setInitial(String initial) { this.initial = initial;}


        public String getOffline_day_7() { return offline_day_7;}


        public void setOffline_day_7(String offline_day_7) { this.offline_day_7 = offline_day_7;}
    }


    public static class MenusBean {
        private String name;
        /**
         * url : http://s.budejie.com/topic/list/jingxuan/1/
         * god_topic_type : nan
         * type : topic
         * entrytype : self.koushu.android.feed.16081610415837
         * name : 推荐
         */

        private List<SubmenusBean> submenus;


        public String getName() { return name;}


        public void setName(String name) { this.name = name;}


        public List<SubmenusBean> getSubmenus() { return submenus;}


        public void setSubmenus(List<SubmenusBean> submenus) { this.submenus = submenus;}


        public static class SubmenusBean {
            private String url;
            private String god_topic_type;
            private String type;
            private String entrytype;
            private String name;


            public String getUrl() { return url;}


            public void setUrl(String url) { this.url = url;}


            public String getGod_topic_type() { return god_topic_type;}


            public void setGod_topic_type(String god_topic_type) {
                this.god_topic_type = god_topic_type;
            }


            public String getType() { return type;}


            public void setType(String type) { this.type = type;}


            public String getEntrytype() { return entrytype;}


            public void setEntrytype(String entrytype) { this.entrytype = entrytype;}


            public String getName() { return name;}


            public void setName(String name) { this.name = name;}
        }
    }
}
