package com.forezp.newszh.model;

import com.forezp.newszh.Constants;
import com.forezp.newszh.model.bean.News;
import com.forezp.newszh.model.handler.NewsLoadHandler;
import com.google.gson.Gson;
import com.trilink.androidlib.utils.LG;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Call;

/**
 * Created by b508a on 2016/4/12.
 */
public class NewsModel implements INewsModel{
    private static String GET_ANSWER_CONTENT_URL = "http://api.kanzhihu.com/getpostanswers/";
    private static String YESTERDAY = "/yesterday";
    private static String RECENT = "/recent";
    private static String ARCHIVE = "/archive";
    protected  static final String TAG="NewsModel";
    private static NewsModel instance = null;
    private NewsModel(){}
    public static NewsModel getInstance() {
        if (instance == null) {
            instance = new NewsModel();
        }
        return instance;
    }

    @Override
    public void loadNews(String time, int type, final NewsLoadHandler handler) {

        String url =getContentURL(time,type);
        OkHttpUtils.post()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        LG.e(TAG, e.getMessage());
                        String msg = e.getMessage();
                        handler.onLoadFail(msg);
                    }
                    @Override
                    public void onResponse(String s) {
                        try {
                           JSONObject json = new JSONObject(s);
                            String error=json.getString("error");

                            if(error.equals("")){
                                JSONArray array=json.getJSONArray("answers");
                                ArrayList<News> list=new ArrayList<News>();
                                for (int i=0;i<array.length();i++){
                                    JSONObject jsonObject=array.getJSONObject(i);
                                    News news=new Gson().fromJson(jsonObject.toString(),News.class);
                                    list.add(news);

                                }
                                handler.onLoadSucess(list);
                            } else {
                                String msg = "server error";
                                handler.onLoadFail(msg);

                            }
                        } catch (Exception e) {
                            String msg = e.getMessage();
                            handler.onLoadFail(msg);
                        }
                    }
                });

    }

    private String getContentURL(String time, int type) {
        switch (type) {
            case Constants.YESTERDAY_ANSWERS:
                return GET_ANSWER_CONTENT_URL + time + YESTERDAY;

            case Constants.RECENT_ANSWERS:
               // Logger.d(GET_ANSWER_CONTENT_URL + time + RECENT);
                return GET_ANSWER_CONTENT_URL + time + RECENT;

            case Constants.ARCHIVE_ANSWERS:
               // LG.d(Config.GET_ANSWER_CONTENT_URL + time + ARCHIVE);
                return GET_ANSWER_CONTENT_URL + time +ARCHIVE;

            default:
                return GET_ANSWER_CONTENT_URL + time + YESTERDAY;
        }

    }
}
