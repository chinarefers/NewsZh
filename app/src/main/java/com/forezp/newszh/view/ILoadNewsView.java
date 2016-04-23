package com.forezp.newszh.view;

import com.forezp.newszh.model.bean.News;

import java.util.ArrayList;

/**
 * Created by b508a on 2016/4/12.
 */
public interface  ILoadNewsView extends  IView{

    public void  onLoadSucess(ArrayList<News> list);
    public void onLoadFail(String msg);
}
