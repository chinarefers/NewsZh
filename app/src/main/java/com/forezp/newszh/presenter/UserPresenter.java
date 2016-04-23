package com.forezp.newszh.presenter;

import android.support.annotation.Nullable;

import com.forezp.newszh.model.UserModel;
import com.forezp.newszh.model.bean.UserDetail;
import com.forezp.newszh.model.handler.UserHandler;
import com.forezp.newszh.view.IUserInfoView;

/**
 * Created by b508a on 2016/4/13.
 */
public class UserPresenter {

    private static final String TAG="UserPresenter";

    private UserModel mUser;
    private IUserInfoView mView;

    /**
     * 创建用户模型的主导器
     *
     * @param view 如果不需要进行界面展示则View传入null
     */
    public UserPresenter(@Nullable IUserInfoView view) {
        mUser = UserModel.getInstance();
        mView = view;
    }


    public void loadUserInfo(String url){

        mUser.getUserInfo(url, new UserHandler() {
            @Override
            public void onLoadSucess(UserDetail userDetail) {
                if (mView != null) {
                    mView.onUserInfoSuccess(userDetail);
                }
            }

            @Override
            public void onLoadFail(String msg) {
                mView.onUserInfoFail(msg);
            }

            @Override
            public void onlinkError(String msg) {
                mView.onUserInfoFail(msg);
            }
        });




    }
}
