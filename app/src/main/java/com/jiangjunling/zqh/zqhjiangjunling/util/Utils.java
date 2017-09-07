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
     * @param key
     * @return
     */
    public static long getlongFromSharepreference(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(PRENAME, context.MODE_PRIVATE);
        return sp.getLong(key,-1);
    }

    public static int getIntFromSharepreference(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(PRENAME, context.MODE_PRIVATE);
        return sp.getInt(key,-1);
    }

    public static String getStringFromSharepreference(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(PRENAME, context.MODE_PRIVATE);
        return sp.getString(key,null);
    }

    /**
     * 根据key保存对应字段数据
     * @param context
     * @param key
     * @param value
     */
    public static void putValueFromShareprefrence(Context context,String key,Object value){
        SharedPreferences sp = context.getSharedPreferences(PRENAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        if(value instanceof Long){
            editor.putLong(key, (Long) value);
        }else if(value instanceof String){
            editor.putString(key, (String) value);
        }else if(value instanceof Boolean){
            editor.putBoolean(key, (Boolean) value);
        }else if(value instanceof Integer){
            editor.putInt(key, (int) value);
        }
        editor.commit();
    }


}
