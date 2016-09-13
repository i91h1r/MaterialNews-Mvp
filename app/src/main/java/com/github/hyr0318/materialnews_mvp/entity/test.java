package com.github.hyr0318.materialnews_mvp.entity;

import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/9 17:05
 * 邮箱：2045446584@qq.com
 */
public class test {

    /**
     * status : 4
     * comment : 45
     * tags : [{"id":1,"name":"搞笑"},{"id":59,"name":"萌"},{"id":480,"name":"动物"},{"id":542,"name":"喵星人"}]
     * bookmark : 61
     * text : 对的，就是这样个感觉。。。不要停！
     * gif : {"images":["http://ww3.sinaimg.cn/large/c1e8ffd5jw1f7q3rt2yz5g204m078hdu.gif","http://wimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1.gif","http://dimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1.gif"],"width":166,"gif_thumbnail":["http://wimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_a_1.jpg","http://dimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_a_1.jpg"],"download_url":["http://wimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_d.jpg","http://dimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_d.jpg","http://wimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_a_1.jpg","http://dimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_a_1.jpg"],"height":260}
     * up : 417
     * share_url : http://a.f.budejie.com/share/20581587.html?wx.qq.com
     * down : 44
     * forward : 56
     * u : {"header":["http://wimg.spriteapp.cn/profile/large/2016/08/24/57bd7122d085f_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/08/24/57bd7122d085f_mini.jpg"],"is_v":false,"uid":"7444040","is_vip":false,"name":"天空lil"}
     * passtime : 2016-09-12 08:52:01
     * type : gif
     * id : 20581587
     */

    private int status;
    private String comment;
    private String bookmark;
    private String text;
    /**
     * images : ["http://ww3.sinaimg.cn/large/c1e8ffd5jw1f7q3rt2yz5g204m078hdu.gif","http://wimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1.gif","http://dimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1.gif"]
     * width : 166
     * gif_thumbnail : ["http://wimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_a_1.jpg","http://dimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_a_1.jpg"]
     * download_url : ["http://wimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_d.jpg","http://dimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_d.jpg","http://wimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_a_1.jpg","http://dimg.spriteapp.cn/ugc/2016/09/11/57d5216bb85b1_a_1.jpg"]
     * height : 260
     */

    private GifBean gif;
    private String up;
    private String share_url;
    private int down;
    private int forward;
    /**
     * header : ["http://wimg.spriteapp.cn/profile/large/2016/08/24/57bd7122d085f_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/08/24/57bd7122d085f_mini.jpg"]
     * is_v : false
     * uid : 7444040
     * is_vip : false
     * name : 天空lil
     */

    private UBean u;
    private String passtime;
    private String type;
    private String id;
    /**
     * id : 1
     * name : 搞笑
     */

    private List<TagsBean> tags;


    public int getStatus() { return status;}


    public void setStatus(int status) { this.status = status;}


    public String getComment() { return comment;}


    public void setComment(String comment) { this.comment = comment;}


    public String getBookmark() { return bookmark;}


    public void setBookmark(String bookmark) { this.bookmark = bookmark;}


    public String getText() { return text;}


    public void setText(String text) { this.text = text;}


    public GifBean getGif() { return gif;}


    public void setGif(GifBean gif) { this.gif = gif;}


    public String getUp() { return up;}


    public void setUp(String up) { this.up = up;}


    public String getShare_url() { return share_url;}


    public void setShare_url(String share_url) { this.share_url = share_url;}


    public int getDown() { return down;}


    public void setDown(int down) { this.down = down;}


    public int getForward() { return forward;}


    public void setForward(int forward) { this.forward = forward;}


    public UBean getU() { return u;}


    public void setU(UBean u) { this.u = u;}


    public String getPasstime() { return passtime;}


    public void setPasstime(String passtime) { this.passtime = passtime;}


    public String getType() { return type;}


    public void setType(String type) { this.type = type;}


    public String getId() { return id;}


    public void setId(String id) { this.id = id;}


    public List<TagsBean> getTags() { return tags;}


    public void setTags(List<TagsBean> tags) { this.tags = tags;}


    public static class GifBean {
        private int width;
        private int height;
        private List<String> images;
        private List<String> gif_thumbnail;
        private List<String> download_url;


        public int getWidth() { return width;}


        public void setWidth(int width) { this.width = width;}


        public int getHeight() { return height;}


        public void setHeight(int height) { this.height = height;}


        public List<String> getImages() { return images;}


        public void setImages(List<String> images) { this.images = images;}


        public List<String> getGif_thumbnail() { return gif_thumbnail;}


        public void setGif_thumbnail(List<String> gif_thumbnail) {
            this.gif_thumbnail = gif_thumbnail;
        }


        public List<String> getDownload_url() { return download_url;}


        public void setDownload_url(List<String> download_url) { this.download_url = download_url;}
    }


    public static class UBean {
        private boolean is_v;
        private String uid;
        private boolean is_vip;
        private String name;
        private List<String> header;


        public boolean isIs_v() { return is_v;}


        public void setIs_v(boolean is_v) { this.is_v = is_v;}


        public String getUid() { return uid;}


        public void setUid(String uid) { this.uid = uid;}


        public boolean isIs_vip() { return is_vip;}


        public void setIs_vip(boolean is_vip) { this.is_vip = is_vip;}


        public String getName() { return name;}


        public void setName(String name) { this.name = name;}


        public List<String> getHeader() { return header;}


        public void setHeader(List<String> header) { this.header = header;}
    }


    public static class TagsBean {
        private int id;
        private String name;


        public int getId() { return id;}


        public void setId(int id) { this.id = id;}


        public String getName() { return name;}


        public void setName(String name) { this.name = name;}
    }
}
