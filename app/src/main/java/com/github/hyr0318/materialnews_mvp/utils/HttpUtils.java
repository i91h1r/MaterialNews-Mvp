package com.github.hyr0318.materialnews_mvp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Description:
 * 作者：hyr on 2016/9/12 12:29
 * 邮箱：2045446584@qq.com
 */
public class HttpUtils {

    /**
     * 通过图片url返回图片Bitmap
     * @param url
     * @return
     */
    public static InputStream returnBitMap(String path) {
        URL url = null;
        InputStream is =null;
        try {
            url = new URL(path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();//利用HttpURLConnection对象,我们可以从网络中获取网页数据.
            conn.setDoInput(true);
            conn.connect();
            is = conn.getInputStream(); //得到网络返回的输入流

        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }
}
