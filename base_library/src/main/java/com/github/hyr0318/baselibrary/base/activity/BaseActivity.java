
package com.github.hyr0318.baselibrary.base.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.github.hyr0318.baselibrary.R;
import com.github.hyr0318.baselibrary.view.BaseView;
import com.jaeger.library.StatusBarUtil;

/**
 * @author hyr.
 * @time 2016/8/27 9:55.
 * @des :
 * @email :2045446584@qq.com
 */
public abstract class BaseActivity extends BaseAppCompatActivity implements BaseView {

    protected Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void setContentView(int layoutResID) {

        super.setContentView(layoutResID);
        mToolbar = (Toolbar) findViewById(R.id.common_toolbar);
        if (null != mToolbar) {
            setSupportActionBar(mToolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setElevation(0);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mToolbar.setElevation(0); //解决与tablayout 一起使用出现阴影情况
            }

            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

        }
        setStatuBar();
    }


    public Toolbar getToolbar() {
        return mToolbar;
    }


    public void showBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void showDrawerButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


    private void setStatuBar() {

        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public void showError(String msg) {
        triggerShowError(true, msg, null);
    }


    @Override
    public void showException(String msg) {
        triggerShowError(true, msg, null);
    }


    @Override
    public void showNetError() {
        triggerNetworkError(true, null);
    }


    @Override
    public void showLoading(String msg) {
        triggerShowLoading(true, null);
    }


    @Override
    public void hideLoading() {
        triggerShowLoading(false, null);
    }

}
