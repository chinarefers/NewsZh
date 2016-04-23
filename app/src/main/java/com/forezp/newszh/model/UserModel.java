package com.forezp.newszh.model;

import com.alibaba.fastjson.JSON;
import com.forezp.newszh.model.bean.UserDetail;
import com.forezp.newszh.model.handler.UserHandler;
import com.trilink.androidlib.utils.LG;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by b508a on 2016/4/13.
 */
public class UserModel implements  IUserModel {

    protected  static final String TAG="NewsModel";
    private static UserModel instance = null;
    private UserModel(){}
    public static UserModel getInstance() {
        if (instance == null) {
            instance = new UserModel();
        }
        return instance;
    }

    @Override
    public void getUserInfo(String url,final UserHandler userHandler) {


        //String url =getContentURL(time,type);
        OkHttpUtils.post()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        LG.e(TAG, e.getMessage());
                        String msg = e.getMessage();
                        userHandler.onLoadFail(msg);
                    }
                    @Override
                    public void onResponse(String s) {
                        try {

                            UserDetail res = JSON.parseObject(s, UserDetail.class);


                            if(res.getError().equals("")){

                                userHandler.onLoadSucess(res);
                            } else {
                                String msg = "server error";
                                userHandler.onLoadFail(msg);

                            }
                        } catch (Exception e) {
                            String msg = e.getMessage();
                            userHandler.onLoadFail(msg);
                        }
                    }
                });


    }
}
