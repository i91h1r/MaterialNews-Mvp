## MaterialNews 
Material Design 风格 结合使用Retrofit  RxJava  Jsoup Mvp 模式的一款资讯类 学习app，包含4 个模块 轻松一刻，今日头条，每日图文，美图欣赏。

----------

<br>[![TypeScript](https://badges.frapsoft.com/typescript/version/typescript-v18.svg?v=101)](https://github.com/hyr0318/MaterialNews-Mvp)  [![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.png?v=103)](https://github.com/hyr0318/MaterialNews-Mvp)  
##截图
![](https://github.com/hyr0318/MaterialNews-Mvp/blob/master/image/FhgiUrqPH2o-wtdkq7ybybIqTenz.png)![](https://github.com/hyr0318/MaterialNews-Mvp/blob/master/image/Fu-RMSBK8gwPQlPEV5W6R0fdtMif.png)![](https://github.com/hyr0318/MaterialNews-Mvp/blob/master/image/llLkq3ioq-Sq2QbGSl02F0GezPye.png)![](https://github.com/hyr0318/MaterialNews-Mvp/blob/master/image/lshfORwRDboOU57DHLSVPxwsehOO.png)
##模块简介：
#####轻松一刻：
* 数据来源于百思不得其姐，其中包含视频播放，段子，图片。其中详情内容使用webview，视频播放使用[JCViewPlayer](https://github.com/lipangit/JieCaoVideoPlayer "JieCaoVideoPlayer") 。图片浏览使用Glide可以加载gif图片，点击图片可以查看大图，大图支持手势伸缩

#####今日头条
* 数据来源于今日头条网站抓取的api接口，由于是网站上抓取下来的，信息可能会出现重复，视频详情部分同样使用webview跳转内部视频详情地址播放

#####每日图文
* 数据来源于[http://www.tuweng.com/](http://www.tuweng.com/ "图翁") 使用Jsoup 抓取解析网站内容，用RecycleView 瀑布流展示，图文详情内容数据同样使用Jsoup 抓取图文详情页面解析出来。

#####美图欣赏
* 数据来源百度图片网站抓取api接口，包含 二次元，丝袜美女，性感美女，美腿美女，唯美摄影，宠物，高清动漫，宠物 子分类

##说明
* 数据均来源于网络部分，抓取网站api接口，和通过jsoup解析网站内容。
* 使用了一些github开源项目，非常感谢。

## 开源项目
* StatusBarUtil :[https://github.com/hyr0318/StatusBarUtil](https://github.com/hyr0318/StatusBarUtil "StatusBarUtil") 

* JieCaoVideoPlayer:[https://github.com/lipangit/JieCaoVideoPlayer](https://github.com/lipangit/JieCaoVideoPlayer "JieCaoVideoPlayer")

* retrofit: [https://github.com/square/retrofit](https://github.com/square/retrofit "retrofit")
* jsoup: [https://github.com/jhy/jsoup](https://github.com/jhy/jsoup "jsoup")

----------


####Development by
<br>Developer / Author: hyr0318
#####QQ:2045446584
#####Email:2045446584@qqcom
#####Github:[https://github.com/hyr0318/](https://github.com/hyr0318/)
----------
    `Copyright 2016 HuangYiRui

	Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

	[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

	Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.`
