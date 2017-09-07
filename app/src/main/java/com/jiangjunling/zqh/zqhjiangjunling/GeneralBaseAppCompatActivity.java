package com.jiangjunling.zqh.zqhjiangjunling;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jiangjunling.zqh.zqhjiangjunling.mode.ViewSetingInterface;

/**
 * Created by zqh on 2017/9/7.
 */
public class GeneralBaseAppCompatActivity extends AppCompatActivity {

    private AppToolUtil mAppToolUtil;

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        mAppToolUtil = new AppToolUtil(this);
//        super.onCreate(savedInstanceState);
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mAppToolUtil = new AppToolUtil(this);
        super.onCreate(savedInstanceState);
    }

    /**
     * 初始化toolabr
     */
    public void initSuperToolabr() {
        Toolbar toolbar = getViewSetingInterface().getJlToolbar();
        if (toolbar == null) return;
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
        toolbar.setSubtitleTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
        getViewSetingInterface().getTopBarGroup().setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                R.color.colorPrimaryDark));
        toolbar.setNavigationIcon(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nav_return));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backOnNormal();
            }
        });
    }

    public ViewSetingInterface getViewSetingInterface(){
        return mAppToolUtil.getViewSetingInterface();
    }


    public void backOnNormal() {
        finish();
    }

    public void backOnEditMode() {

    }
}
