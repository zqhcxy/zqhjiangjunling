package com.jiangjunling.zqh.zqhjiangjunling;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.jiangjunling.zqh.zqhjiangjunling.mode.ViewSetingInterface;

/**
 * Created by zqh on 2017/9/7.
 */
public class AppToolUtil {

    private Activity mContext;
    private ViewSetingInterface viewSetingInterface;

    public AppToolUtil(Activity cnt) {
        mContext = cnt;
    }

    /**
     * 获取记录统一控制的view接口
     *
     * @return
     */
    public ViewSetingInterface getViewSetingInterface() {
        if (viewSetingInterface == null) {
            viewSetingInterface = new ViewSetingInterface() {
                @Override
                public Toolbar getJlToolbar() {
                    return (Toolbar) mContext.findViewById(R.id.toolbar);
                }

                @Override
                public ViewGroup getTopBarGroup() {
                    return (ViewGroup) mContext.findViewById(R.id.collapContainter);
                }
            };
        }
        return viewSetingInterface;
    }
}
