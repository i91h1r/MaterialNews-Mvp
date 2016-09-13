package com.github.hyr0318.materialnews_mvp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/9 15:59
 * 邮箱：2045446584@qq.com
 */
public class BaiSiResult extends BaseResult  {

    /**
     * count : 4492
     * np : 1473397825
     */

    private InfoBean info;
    /**
     * status : 4
     * comment : 178
     * top_comments : [{"voicetime":0,"precid":0,"content":"我就问大学生一次性交多少钱？","like_count":45,"u":{"header":["http://qzapp.qlogo.cn/qzapp/100336987/843D0D2262BA8179309445FEAFB431C1/100","http://qzapp.qlogo.cn/qzapp/100336987/843D0D2262BA8179309445FEAFB431C1/100"],"sex":"m","uid":"9598385","name":"半透 灵魂 "},"preuid":0,"passtime":"2016-09-09 16:02:59","voiceuri":"","id":63288654}]
     * tags : [{"id":1,"name":"搞笑"},{"id":60,"name":"吐槽"},{"id":62,"name":"内涵"},{"id":7723,"name":"极品"}]
     * bookmark : 55
     * text : 反正是女屌丝上大学有什么用？
     * image : {"medium":["http://ww4.sinaimg.cn/bmiddle/c1e8ffd5jw1f7n79bzj88j209654hthd.jpg"],"big":["http://ww4.sinaimg.cn/large/c1e8ffd5jw1f7n79bzj88j209654hthd.jpg","http://wimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea_1.jpg","http://dimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea_1.jpg"],"download_url":["http://wimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea_d.jpg","http://dimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea_d.jpg","http://wimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea.jpg","http://dimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea.jpg"],"height":6641,"width":330,"small":["http://ww4.sinaimg.cn/mw240/c1e8ffd5jw1f7n79bzj88j209654hthd.jpg"],"thumbnail_small":["http://wimg.spriteapp.cn/crop/150x150/ugc/2016/09/08/57d163e9154ea.jpg","http://dimg.spriteapp.cn/crop/150x150/ugc/2016/09/08/57d163e9154ea.jpg"]}
     * up : 614
     * share_url : http://a.f.budejie.com/share/20516163.html?wx.qq.com
     * down : 79
     * forward : 99
     * u : {"header":["http://wimg.spriteapp.cn/profile/large/2016/07/11/5783627acf3fc_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/07/11/5783627acf3fc_mini.jpg"],"is_v":true,"uid":"13584284","is_vip":false,"name":"昵称审核中"}
     * passtime : 2016-09-09 13:20:02
     * type : image
     * id : 20516163
     */

    private List<ListBean> list;


    public InfoBean getInfo() { return info;}


    public void setInfo(InfoBean info) { this.info = info;}


    public List<ListBean> getList() { return list;}


    public void setList(List<ListBean> list) { this.list = list;}


    public static class InfoBean {
        private int count;
        private int np;


        public int getCount() { return count;}


        public void setCount(int count) { this.count = count;}


        public int getNp() { return np;}


        public void setNp(int np) { this.np = np;}
    }


    public static class ListBean implements Parcelable {
        private int status;
        private String comment;
        private String bookmark;
        private String text;
        /**
         * medium : ["http://ww4.sinaimg.cn/bmiddle/c1e8ffd5jw1f7n79bzj88j209654hthd.jpg"]
         * big : ["http://ww4.sinaimg.cn/large/c1e8ffd5jw1f7n79bzj88j209654hthd.jpg","http://wimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea_1.jpg","http://dimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea_1.jpg"]
         * download_url : ["http://wimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea_d.jpg","http://dimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea_d.jpg","http://wimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea.jpg","http://dimg.spriteapp.cn/ugc/2016/09/08/57d163e9154ea.jpg"]
         * height : 6641
         * width : 330
         * small : ["http://ww4.sinaimg.cn/mw240/c1e8ffd5jw1f7n79bzj88j209654hthd.jpg"]
         * thumbnail_small : ["http://wimg.spriteapp.cn/crop/150x150/ugc/2016/09/08/57d163e9154ea.jpg","http://dimg.spriteapp.cn/crop/150x150/ugc/2016/09/08/57d163e9154ea.jpg"]
         */

        private GifBean gif;
        private VideoBean video;
        private ImageBean image;
        private String up;
        private String share_url;
        private int down;
        private int forward;
        /**
         * header : ["http://wimg.spriteapp.cn/profile/large/2016/07/11/5783627acf3fc_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/07/11/5783627acf3fc_mini.jpg"]
         * is_v : true
         * uid : 13584284
         * is_vip : false
         * name : 昵称审核中
         */

        private UBean u;
        private String passtime;
        private String type;
        private String id;
        /**
         * voicetime : 0
         * precid : 0
         * content : 我就问大学生一次性交多少钱？
         * like_count : 45
         * u : {"header":["http://qzapp.qlogo.cn/qzapp/100336987/843D0D2262BA8179309445FEAFB431C1/100","http://qzapp.qlogo.cn/qzapp/100336987/843D0D2262BA8179309445FEAFB431C1/100"],"sex":"m","uid":"9598385","name":"半透 灵魂 "}
         * preuid : 0
         * passtime : 2016-09-09 16:02:59
         * voiceuri :
         * id : 63288654
         */

        private List<TopCommentsBean> top_comments;
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


        public ImageBean getImage() { return image;}


        public void setImage(ImageBean image) { this.image = image;}


        public String getUp() { return up;}


        public void setUp(String up) { this.up = up;}


        public String getShare_url() { return share_url;}


        public void setShare_url(String share_url) { this.share_url = share_url;}


        public int getDown() { return down;}


        public void setDown(int down) { this.down = down;}


        public int getForward() { return forward;}


        public void setForward(int forward) { this.forward = forward;}


        public GifBean getGif() {
            return gif;
        }


        public void setGif(GifBean gif) {
            this.gif = gif;
        }


        public UBean getU() { return u;}


        public void setU(UBean u) { this.u = u;}


        public String getPasstime() { return passtime;}


        public void setPasstime(String passtime) { this.passtime = passtime;}


        public String getType() { return type;}


        public void setType(String type) { this.type = type;}


        public String getId() { return id;}


        public void setId(String id) { this.id = id;}


        public List<TopCommentsBean> getTop_comments() { return top_comments;}


        public void setTop_comments(List<TopCommentsBean> top_comments) {
            this.top_comments = top_comments;
        }


        public List<TagsBean> getTags() { return tags;}


        public VideoBean getVideo() {
            return video;
        }


        public void setVideo(VideoBean video) {
            this.video = video;
        }

        public static class GifBean implements Parcelable {
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


            @Override public int describeContents() { return 0; }


            @Override public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.width);
                dest.writeInt(this.height);
                dest.writeStringList(this.images);
                dest.writeStringList(this.gif_thumbnail);
                dest.writeStringList(this.download_url);
            }


            public GifBean() {}


            protected GifBean(Parcel in) {
                this.width = in.readInt();
                this.height = in.readInt();
                this.images = in.createStringArrayList();
                this.gif_thumbnail = in.createStringArrayList();
                this.download_url = in.createStringArrayList();
            }


            public static final Creator<GifBean> CREATOR = new Creator<GifBean>() {
                @Override public GifBean createFromParcel(Parcel source) {
                    return new GifBean(source);
                }


                @Override public GifBean[] newArray(int size) {return new GifBean[size];}
            };
        }

        public void setTags(List<TagsBean> tags) { this.tags = tags;}
        public static class VideoBean implements Parcelable {
            private int playfcount;
            private int height;
            private int width;
            private int duration;
            private int playcount;
            private List<String> video;
            private List<String> download;
            private List<String> thumbnail;
            private List<String> thumbnail_small;


            public int getPlayfcount() { return playfcount;}


            public void setPlayfcount(int playfcount) { this.playfcount = playfcount;}


            public int getHeight() { return height;}


            public void setHeight(int height) { this.height = height;}


            public int getWidth() { return width;}


            public void setWidth(int width) { this.width = width;}


            public int getDuration() { return duration;}


            public void setDuration(int duration) { this.duration = duration;}


            public int getPlaycount() { return playcount;}


            public void setPlaycount(int playcount) { this.playcount = playcount;}


            public List<String> getVideo() { return video;}


            public void setVideo(List<String> video) { this.video = video;}


            public List<String> getDownload() { return download;}


            public void setDownload(List<String> download) { this.download = download;}


            public List<String> getThumbnail() { return thumbnail;}


            public void setThumbnail(List<String> thumbnail) { this.thumbnail = thumbnail;}


            public List<String> getThumbnail_small() { return thumbnail_small;}


            public void setThumbnail_small(List<String> thumbnail_small) {
                this.thumbnail_small = thumbnail_small;
            }


            @Override public int describeContents() { return 0; }


            @Override public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.playfcount);
                dest.writeInt(this.height);
                dest.writeInt(this.width);
                dest.writeInt(this.duration);
                dest.writeInt(this.playcount);
                dest.writeStringList(this.video);
                dest.writeStringList(this.download);
                dest.writeStringList(this.thumbnail);
                dest.writeStringList(this.thumbnail_small);
            }


            public VideoBean() {}


            protected VideoBean(Parcel in) {
                this.playfcount = in.readInt();
                this.height = in.readInt();
                this.width = in.readInt();
                this.duration = in.readInt();
                this.playcount = in.readInt();
                this.video = in.createStringArrayList();
                this.download = in.createStringArrayList();
                this.thumbnail = in.createStringArrayList();
                this.thumbnail_small = in.createStringArrayList();
            }


            public static final Creator<VideoBean> CREATOR = new Creator<VideoBean>() {
                @Override public VideoBean createFromParcel(Parcel source) {
                    return new VideoBean(source);
                }


                @Override public VideoBean[] newArray(int size) {return new VideoBean[size];}
            };
        }


        public static class ImageBean implements Parcelable {
            private int height;
            private int width;
            private List<String> medium;
            private List<String> big;
            private List<String> download_url;
            private List<String> small;
            private List<String> thumbnail_small;


            public int getHeight() { return height;}


            public void setHeight(int height) { this.height = height;}


            public int getWidth() { return width;}


            public void setWidth(int width) { this.width = width;}


            public List<String> getMedium() { return medium;}


            public void setMedium(List<String> medium) { this.medium = medium;}


            public List<String> getBig() { return big;}


            public void setBig(List<String> big) { this.big = big;}


            public List<String> getDownload_url() { return download_url;}


            public void setDownload_url(List<String> download_url) {
                this.download_url = download_url;
            }


            public List<String> getSmall() { return small;}


            public void setSmall(List<String> small) { this.small = small;}


            public List<String> getThumbnail_small() { return thumbnail_small;}


            public void setThumbnail_small(List<String> thumbnail_small) {
                this.thumbnail_small = thumbnail_small;
            }


            @Override public int describeContents() { return 0; }


            @Override public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.height);
                dest.writeInt(this.width);
                dest.writeStringList(this.medium);
                dest.writeStringList(this.big);
                dest.writeStringList(this.download_url);
                dest.writeStringList(this.small);
                dest.writeStringList(this.thumbnail_small);
            }


            public ImageBean() {}


            protected ImageBean(Parcel in) {
                this.height = in.readInt();
                this.width = in.readInt();
                this.medium = in.createStringArrayList();
                this.big = in.createStringArrayList();
                this.download_url = in.createStringArrayList();
                this.small = in.createStringArrayList();
                this.thumbnail_small = in.createStringArrayList();
            }


            public static final Creator<ImageBean> CREATOR = new Creator<ImageBean>() {
                @Override public ImageBean createFromParcel(Parcel source) {
                    return new ImageBean(source);
                }


                @Override public ImageBean[] newArray(int size) {return new ImageBean[size];}
            };
        }


        public static class UBean implements Parcelable {
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


            @Override public int describeContents() { return 0; }


            @Override public void writeToParcel(Parcel dest, int flags) {
                dest.writeByte(this.is_v ? (byte) 1 : (byte) 0);
                dest.writeString(this.uid);
                dest.writeByte(this.is_vip ? (byte) 1 : (byte) 0);
                dest.writeString(this.name);
                dest.writeStringList(this.header);
            }


            public UBean() {}


            protected UBean(Parcel in) {
                this.is_v = in.readByte() != 0;
                this.uid = in.readString();
                this.is_vip = in.readByte() != 0;
                this.name = in.readString();
                this.header = in.createStringArrayList();
            }


            public static final Creator<UBean> CREATOR = new Creator<UBean>() {
                @Override public UBean createFromParcel(Parcel source) {return new UBean(source);}


                @Override public UBean[] newArray(int size) {return new UBean[size];}
            };
        }


        public static class TopCommentsBean implements Parcelable {
            private int voicetime;
            private int precid;
            private String content;
            private int like_count;
            /**
             * header : ["http://qzapp.qlogo.cn/qzapp/100336987/843D0D2262BA8179309445FEAFB431C1/100","http://qzapp.qlogo.cn/qzapp/100336987/843D0D2262BA8179309445FEAFB431C1/100"]
             * sex : m
             * uid : 9598385
             * name : 半透 灵魂
             */

            private UBean u;
            private int preuid;
            private String passtime;
            private String voiceuri;
            private int id;


            public int getVoicetime() { return voicetime;}


            public void setVoicetime(int voicetime) { this.voicetime = voicetime;}


            public int getPrecid() { return precid;}


            public void setPrecid(int precid) { this.precid = precid;}


            public String getContent() { return content;}


            public void setContent(String content) { this.content = content;}


            public int getLike_count() { return like_count;}


            public void setLike_count(int like_count) { this.like_count = like_count;}


            public UBean getU() { return u;}


            public void setU(UBean u) { this.u = u;}


            public int getPreuid() { return preuid;}


            public void setPreuid(int preuid) { this.preuid = preuid;}


            public String getPasstime() { return passtime;}


            public void setPasstime(String passtime) { this.passtime = passtime;}


            public String getVoiceuri() { return voiceuri;}


            public void setVoiceuri(String voiceuri) { this.voiceuri = voiceuri;}


            public int getId() { return id;}


            public void setId(int id) { this.id = id;}


            public static class UBean implements Parcelable {
                private String sex;
                private String uid;
                private String name;
                private List<String> header;


                public String getSex() { return sex;}


                public void setSex(String sex) { this.sex = sex;}


                public String getUid() { return uid;}


                public void setUid(String uid) { this.uid = uid;}


                public String getName() { return name;}


                public void setName(String name) { this.name = name;}


                public List<String> getHeader() { return header;}


                public void setHeader(List<String> header) { this.header = header;}


                @Override public int describeContents() { return 0; }


                @Override public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.sex);
                    dest.writeString(this.uid);
                    dest.writeString(this.name);
                    dest.writeStringList(this.header);
                }


                public UBean() {}


                protected UBean(Parcel in) {
                    this.sex = in.readString();
                    this.uid = in.readString();
                    this.name = in.readString();
                    this.header = in.createStringArrayList();
                }


                public static final Creator<UBean> CREATOR = new Creator<UBean>() {
                    @Override public UBean createFromParcel(Parcel source) {
                        return new UBean(source);
                    }


                    @Override public UBean[] newArray(int size) {return new UBean[size];}
                };
            }


            @Override public int describeContents() { return 0; }


            @Override public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.voicetime);
                dest.writeInt(this.precid);
                dest.writeString(this.content);
                dest.writeInt(this.like_count);
                dest.writeParcelable(this.u, flags);
                dest.writeInt(this.preuid);
                dest.writeString(this.passtime);
                dest.writeString(this.voiceuri);
                dest.writeInt(this.id);
            }


            public TopCommentsBean() {}


            protected TopCommentsBean(Parcel in) {
                this.voicetime = in.readInt();
                this.precid = in.readInt();
                this.content = in.readString();
                this.like_count = in.readInt();
                this.u = in.readParcelable(UBean.class.getClassLoader());
                this.preuid = in.readInt();
                this.passtime = in.readString();
                this.voiceuri = in.readString();
                this.id = in.readInt();
            }


            public static final Creator<TopCommentsBean> CREATOR = new Creator<TopCommentsBean>() {
                @Override
                public TopCommentsBean createFromParcel(Parcel source) {
                    return new TopCommentsBean(source);
                }


                @Override
                public TopCommentsBean[] newArray(int size) {return new TopCommentsBean[size];}
            };
        }


        public static class TagsBean implements Parcelable {
            private int id;
            private String name;


            public int getId() { return id;}


            public void setId(int id) { this.id = id;}


            public String getName() { return name;}


            public void setName(String name) { this.name = name;}


            @Override public int describeContents() { return 0; }


            @Override public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeString(this.name);
            }


            public TagsBean() {}


            protected TagsBean(Parcel in) {
                this.id = in.readInt();
                this.name = in.readString();
            }


            public static final Creator<TagsBean> CREATOR = new Creator<TagsBean>() {
                @Override public TagsBean createFromParcel(Parcel source) {
                    return new TagsBean(source);
                }


                @Override public TagsBean[] newArray(int size) {return new TagsBean[size];}
            };
        }


        @Override public int describeContents() { return 0; }


        @Override public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.status);
            dest.writeString(this.comment);
            dest.writeString(this.bookmark);
            dest.writeString(this.text);
            dest.writeParcelable(this.gif, flags);
            dest.writeParcelable(this.video, flags);
            dest.writeParcelable(this.image, flags);
            dest.writeString(this.up);
            dest.writeString(this.share_url);
            dest.writeInt(this.down);
            dest.writeInt(this.forward);
            dest.writeParcelable(this.u, flags);
            dest.writeString(this.passtime);
            dest.writeString(this.type);
            dest.writeString(this.id);
            dest.writeList(this.top_comments);
            dest.writeList(this.tags);
        }


        public ListBean() {}


        protected ListBean(Parcel in) {
            this.status = in.readInt();
            this.comment = in.readString();
            this.bookmark = in.readString();
            this.text = in.readString();
            this.gif = in.readParcelable(GifBean.class.getClassLoader());
            this.video = in.readParcelable(VideoBean.class.getClassLoader());
            this.image = in.readParcelable(ImageBean.class.getClassLoader());
            this.up = in.readString();
            this.share_url = in.readString();
            this.down = in.readInt();
            this.forward = in.readInt();
            this.u = in.readParcelable(UBean.class.getClassLoader());
            this.passtime = in.readString();
            this.type = in.readString();
            this.id = in.readString();
            this.top_comments = new ArrayList<TopCommentsBean>();
            in.readList(this.top_comments, TopCommentsBean.class.getClassLoader());
            this.tags = new ArrayList<TagsBean>();
            in.readList(this.tags, TagsBean.class.getClassLoader());
        }


        public static final Parcelable.Creator<ListBean> CREATOR
            = new Parcelable.Creator<ListBean>() {
            @Override public ListBean createFromParcel(Parcel source) {return new ListBean(source);}


            @Override public ListBean[] newArray(int size) {return new ListBean[size];}
        };
    }
}
