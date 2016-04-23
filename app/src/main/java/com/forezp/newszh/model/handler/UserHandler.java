package com.forezp.newszh.model.handler;

import com.forezp.newszh.model.bean.UserDetail;

/**
 * Created by b508a on 2016/4/13.
 */
public interface UserHandler extends NetworkHandler{
    public void  onLoadSucess( UserDetail userDetail);
    public void onLoadFail(String msg);
}
