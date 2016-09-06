/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.hyr0318.baselibrary.view;

/**
 * @Description:
 * @author: hyr
 * @time: 2016/9/2 16:06
 * @Email: 2045446584@qq.com
 */
public interface BaseView {

    /**
     * 显示正在加载
     */
    void showLoading(String msg);

    /**
     * 隐藏加载进度
     */
    void hideLoading();

    /**
     * 显示错误信息
     */
    void showError(String msg);

    /**
     * 显示异常信息
     */
    void showException(String msg);

    /**
     * 显示网络错误
     */
    void showNetError();

}
