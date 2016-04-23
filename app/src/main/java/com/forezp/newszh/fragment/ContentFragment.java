package com.forezp.newszh.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.forezp.newszh.R;
import com.forezp.newszh.activity.AnswerActivity;
import com.forezp.newszh.adapter.NewsAdapter;
import com.forezp.newszh.model.bean.News;
import com.forezp.newszh.presenter.NewsPresenter;
import com.forezp.newszh.view.ILoadNewsView;
import com.trilink.androidlib.svpdialog.SVProgressHUD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by b508a on 2016/4/12.
 */
public class ContentFragment extends Fragment implements ILoadNewsView {

    @Bind(R.id.lv_content)
    ListView lvContent;


    @Bind(R.id.swipe_refreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private View parentView;
    private NewsPresenter presenter;

    public int mtype = 0;
    private String dateTime;
    private NewsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        parentView = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.bind(this, parentView);

        adapter = new NewsAdapter(getActivity());

        lvContent.setAdapter(adapter);
        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                News data=(News)adapter.getList().get(position);
                Intent intent = new Intent(getActivity(), AnswerActivity.class);
                intent.putExtra("answerUrl", data.getAnswerUrl());
                intent.putExtra("questionUrl", data.getQuestionUrl());
                intent.putExtra("userUrl", data.getUserUrl());
                intent.putExtra("title", data.getTitle());
                intent.putExtra("vote", data.getVote());
                getActivity().startActivity(intent);
            }
        });
        return parentView;
    }


    public ContentFragment() {
        dateTime = getTodayTime();
    }


    public static ContentFragment getInstance(int type) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public static ContentFragment getInstance(int type, String time) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        bundle.putString("datetime", time);
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private String getTodayTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date curDate = new Date(System.currentTimeMillis());
        return formatter.format(curDate);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            mtype = getArguments().getInt("type", 0);
            dateTime = getArguments().getString("datetime", getTodayTime());
        }

        presenter = new NewsPresenter(this);
        presenter.loadNewsData(dateTime, mtype);
        SVProgressHUD.showWithStatus(getActivity(),"loading");
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(adapter.getList()!=null) {
                    adapter.getList().clear();
                    adapter.notifyDataSetChanged();
                }

                presenter.loadNewsData(dateTime, mtype);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onLoadSucess(ArrayList<News> list) {
        if(SVProgressHUD.isShowing(getActivity())) {
            SVProgressHUD.dismiss(getActivity());
        }

        if (list.size() > 0) {
            adapter.setList(list);
            adapter.notifyDataSetChanged();

        }

        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onLoadFail(String msg) {
        if(SVProgressHUD.isShowing(getActivity())) {
            SVProgressHUD.dismiss(getActivity());
        }
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }

        presenter.loadNewsData((Integer.parseInt(dateTime) - 1) + "", mtype);
//        adapter.loadDatas((Integer.parseInt(dateTime) - 1) + "", type);

    }


}
