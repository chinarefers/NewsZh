package com.forezp.newszh.presenter;

import android.support.annotation.Nullable;

import com.forezp.newszh.model.NewsModel;
import com.forezp.newszh.model.bean.News;
import com.forezp.newszh.model.handler.NewsLoadHandler;
import com.forezp.newszh.view.ILoadNewsView;

import java.util.ArrayList;

/**
 * Created by b508a on 2016/4/12.
 */
public class NewsPresenter {
    private static final String TAG="NewsPresenter";

    private NewsModel  mNews;
    private ILoadNewsView mView;

    /**
     * 创建用户模型的主导器
     *
     * @param view 如果不需要进行界面展示则View传入null
     */
    public NewsPresenter(@Nullable ILoadNewsView view) {
        mNews = NewsModel.getInstance();
        mView = view;
    }


    public void loadNewsData(String time,int type){
        mNews.loadNews(time, type, new NewsLoadHandler() {
            @Override
            public void onLoadSucess(ArrayList<News> list) {
                if(mView!=null){
                    mView.onLoadSucess(list);
                }
            }

            @Override
            public void onLoadFail(String msg) {
                mView.onLoadFail(msg);
            }

            @Override
            public void onlinkError(String msg) {
                mView.onLoadFail(msg);
            }
        });


    }

}
