package com.forezp.newszh.model;

import com.forezp.newszh.model.handler.UserHandler;

public interface IUserModel {
    
    void getUserInfo(String url,UserHandler userHandler);

}
