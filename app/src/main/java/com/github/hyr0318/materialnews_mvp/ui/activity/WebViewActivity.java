package com.github.hyr0318.materialnews_mvp.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.github.hyr0318.baselibrary.base.activity.BaseActivity;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.net.NetUtils;
import com.github.hyr0318.materialnews_mvp.R;

/**
 * Description:
 * 作者：hyr on 2016/8/30 13:30
 * 邮箱：2045446584@qq.com
 */
public class WebViewActivity extends BaseActivity {

    private WebView webView;
    private String source_url;
    private ProgressBar progressBar;
    private Toolbar toolbar;
    private String title;
    private String newUrl = null;


    @Override protected int getContentViewLayoutID() {
        return R.layout.activity_webview_layout;
    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override protected void getViewById() {
        webView = (WebView) findViewById(R.id.webview);

        progressBar = (ProgressBar) findViewById(R.id.pbProgress);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }


    @Override protected View getLoadingView() {
        return null;
    }


    @Override protected void initViewsAndEvents() {

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle(title);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    if (progressBar.getVisibility() == View.GONE) {
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    progressBar.setProgress(newProgress);

                }
            }
        });
        webView.setDownloadListener((s, s1, s2, s3, l) -> {
            Uri uri = Uri.parse(newUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                newUrl = url;
                return false;
            }

        });

        webView.loadUrl(source_url);

    }


    @Override protected void getIntentExtras(Bundle extras) {
        source_url = extras.getString("source_url");

        title = extras.getString("title");
    }


    @Override protected void onNetworkConnected(NetUtils.NetType type) {

    }


    @Override protected void onNetworkDisConnected() {

    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }

}
