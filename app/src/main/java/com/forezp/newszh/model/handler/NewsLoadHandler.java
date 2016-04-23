package com.forezp.newszh.model.handler;

import com.forezp.newszh.model.bean.News;

import java.util.ArrayList;

/**
 * Created by b508a on 2016/4/12.
 */
public interface NewsLoadHandler extends  NetworkHandler{
    public void  onLoadSucess(ArrayList<News> list);
    public void onLoadFail(String msg);

}
