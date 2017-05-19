package com.jiangjunling.zqh.zqhjiangjunling.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zqh on 2017/5/4.
 */
public class Utils {

    public static final String PRENAME="jiangjun";
    public static final String UNLOCK_KEY="lockid";


    /**
     *
     * @param context
     * @param prefName
     * @param key
     * @return
     */
    public static long getlongFromSharepreference(Context context,String prefName,String key){
        SharedPreferences sp = context.getSharedPreferences(prefName, context.MODE_PRIVATE);
        return sp.getLong(key,-1);
    }

}
