package com.forezp.newszh.view;

import com.forezp.newszh.model.bean.UserDetail;

/**
 * Created by b508a on 2016/4/13.
 */
public interface IUserInfoView extends IView{

    void  onUserInfoSuccess(UserDetail userDetail);
    void  onUserInfoFail(String msg);
}
