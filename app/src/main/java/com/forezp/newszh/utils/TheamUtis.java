package com.forezp.newszh.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.forezp.newszh.BaseApplication;
import com.forezp.newszh.Constants;
import com.forezp.newszh.R;


/**
 * Created by b508a on 2016/4/12.
 */
public class TheamUtis {


    private static int defalutThemeColor = R.color.colorPrimary;
    private static Context context = BaseApplication.getContext();
    public static void setThemeColor( int color){
      //  prism.setColour(color);
        SharedPreferences.Editor editor = context.getSharedPreferences(Constants.SP_NAME,context.MODE_PRIVATE).edit();
        editor.putInt(Constants.SP_THEAM_COLOR,color);
        editor.commit();
    }

    public static int getThemeColor(){
        SharedPreferences pref = context.getSharedPreferences(Constants.SP_THEAM_COLOR,context.MODE_PRIVATE);
        return pref.getInt(Constants.SP_THEAM_COLOR,defalutThemeColor);
    }


}
