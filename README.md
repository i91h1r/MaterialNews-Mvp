## MaterialNews 
Material Design 风格 结合使用Retrofit  RxJava  Jsoup Mvp 模式的一款资讯类 学习app，包含4 个模块 轻松一刻，今日头条，每日图文，美图欣赏。整体代码很简单，很容易学到大概Retrofit  RxJava  Jsoup Mvp 的一些基本使用

----------

<br>[![TypeScript](https://badges.frapsoft.com/typescript/version/typescript-v18.svg?v=101)](https://github.com/hyr0318/MaterialNews-Mvp)  [![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.png?v=103)](https://github.com/hyr0318/MaterialNews-Mvp)  
##截图
![](https://github.com/hyr0318/MaterialNews-Mvp/blob/master/image/gif.gif)![](https://github.com/hyr0318/MaterialNews-Mvp/blob/master/image/FhgiUrqPH2o-wtdkq7ybybIqTenz.png)![](https://github.com/hyr0318/MaterialNews-Mvp/blob/master/image/Fu-RMSBK8gwPQlPEV5W6R0fdtMif.png)![](https://github.com/hyr0318/MaterialNews-Mvp/blob/master/image/llLkq3ioq-Sq2QbGSl02F0GezPye.png)![](https://github.com/hyr0318/MaterialNews-Mvp/blob/master/image/lshfORwRDboOU57DHLSVPxwsehOO.png)
##模块简介：
#####百思不得姐：
* 数据来源于百思不得其姐app抓取api，其中包含视频播放，段子，图片。，视频播放使用[JCViewPlayer](https://github.com/lipangit/JieCaoVideoPlayer "JieCaoVideoPlayer") 。
* api 分析 ：
	* 获取分类列表api ：http://s.budejie.com/public/list-appbar/budejie-android-6.5.11/
	`  {
           	"name": "精华",
            "submenus": [
                {
                    "url": "http://s.budejie.com/topic/list/jingxuan/1/",
                    "god_topic_type": "nan",
                    "type": "topic",
                    "entrytype": "self.koushu.android.feed.16081610415837",
                    "name": "推荐"
                },
                {
                    "url": "http://s.budejie.com/topic/list/jingxuan/41/",
                    "god_topic_type": "nan",
                    "type": "topic",
                    "entrytype": "self.koushu.android.feed.16081610415837",
                    "name": "视频"
                },`
其中url中后面的例如/1/  /41/ 就是分类需要的类型参数

	* 获取分类下的列表数据 ：http://s.budejie.com/topic/list/jingxuan/1/budejie-android-6.5.11/0-20.json
	
		其中0 - 20  20代表美亚加载20条数据，0 是刷新最新，下一页是用过去时间的时间戳作为参数获取下一页数据 例如：20621073 - 20
	* 获取评论 ：http://api.budejie.com/api/api_open.php?a=dataList&c=comment&data_id=20565881

		data_id ： 每条数据的id ，用这个id区获取这条数据的所有评论

	

#####今日头条
* 数据来源于今日头条网站抓取的api接口，由于是网站上抓取下来的，信息可能会出现重复，视频详情部分同样使用webview跳转内部视频详情地址播放

#####每日图文
* 数据来源于[http://www.tuweng.com/](http://www.tuweng.com/ "图翁") 使用Jsoup 抓取解析网站内容，用RecycleView 瀑布流展示，图文详情内容数据同样使用Jsoup 抓取图文详情页面解析出来。

#####美图欣赏
* 数据来源百度图片网站抓取api接口，包含 二次元，丝袜美女，性感美女，美腿美女，唯美摄影，宠物，高清动漫，宠物 子分类

##版本
* v1.0 基础功能：包括每日图文，头条视频，美图欣赏，轻松一刻.欢迎页非正常手段抓取 one 一个 app接口，如有侵权，请告知，立即删除。
<pre>
	materialNewsApi.getHomeOneId()
            .flatMap(new Func1<HomeOneIdResult, Observable<HomeOneResult>>() {
                @Override public Observable<HomeOneResult> call(HomeOneIdResult homeOneIdResult) {
                    return materialNewsApi.getHomeOneData(homeOneIdResult.getData().get(0));
                }
            })
            .subscribeOn(Schedulers.immediate())
            .subscribe(new BaseObserver<HomeOneResult>() {
                @Override protected void onSucceed(HomeOneResult result) {

                    multiLoadedListener.onSuccess(0 ,result);

                }
            });</pre>
	使用flatmap 第一次请求获取文章id，第二次请求使用获取到的id获取文章详情。

##说明
* 数据均来源于网络部分，抓取网站api接口，和通过jsoup解析网站内容。
* 使用了一些github开源项目，非常感谢。

## 开源项目
* StatusBarUtil :[https://github.com/laobie/StatusBarUtil](https://github.com/laobie/StatusBarUtil)

* JieCaoVideoPlayer:[https://github.com/lipangit/JieCaoVideoPlayer](https://github.com/lipangit/JieCaoVideoPlayer "JieCaoVideoPlayer")

* retrofit: [https://github.com/square/retrofit](https://github.com/square/retrofit "retrofit")
* jsoup: [https://github.com/jhy/jsoup](https://github.com/jhy/jsoup "jsoup")
* BGARefreshLayout-Android：[https://github.com/bingoogolapple/BGARefreshLayout-Android](https://github.com/bingoogolapple/BGARefreshLayout-Android)

----------


####Development by
<br>Developer / Author: hyr0318
#####QQ:2045446584
#####Email:2045446584@qq.com
#####Github:[https://github.com/hyr0318/](https://github.com/hyr0318/)
----------
    Copyright 2016 HuangYiRui

	Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
