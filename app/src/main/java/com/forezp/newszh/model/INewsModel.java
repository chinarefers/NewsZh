package com.forezp.newszh.model;

import com.forezp.newszh.model.handler.NewsLoadHandler;

/**
 * Created by b508a on 2016/4/12.
 */
public interface INewsModel {

    public void loadNews(String time, int type,NewsLoadHandler handler);
    
}
