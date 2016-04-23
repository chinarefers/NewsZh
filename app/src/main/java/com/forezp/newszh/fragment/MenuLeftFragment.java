package com.forezp.newszh.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.forezp.newszh.Constants;
import com.forezp.newszh.R;
import com.forezp.newszh.activity.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MenuLeftFragment extends Fragment {

    @Bind(R.id.one)
    ImageView one;
    @Bind(R.id.rl_today_headlines)
    RelativeLayout rlTodayHeadlines;
    @Bind(R.id.two)
    ImageView two;
    @Bind(R.id.recent_headlines)
    RelativeLayout recentHeadlines;
    @Bind(R.id.three)
    ImageView three;
    @Bind(R.id.history_headlines)
    RelativeLayout historyHeadlines;
    @Bind(R.id.four)
    ImageView four;
    @Bind(R.id.rl_theam)
    RelativeLayout rlTheam;
    @Bind(R.id.five)
    ImageView five;
    @Bind(R.id.rl_setting)
    RelativeLayout rlSetting;
    private MainActivity ma;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_menu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ma=(MainActivity)activity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.rl_today_headlines, R.id.recent_headlines, R.id.history_headlines, R.id.rl_theam, R.id.rl_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_today_headlines:
                ma.closeLeftMenu(Constants.YESTERDAY_ANSWERS);
                break;
            case R.id.recent_headlines:
                ma.closeLeftMenu(Constants.RECENT_ANSWERS);
                break;
            case R.id.history_headlines:
                ma.closeLeftMenu(Constants.ARCHIVE_ANSWERS);
                break;
            case R.id.rl_theam:
                break;
            case R.id.rl_setting:
                break;
        }
    }
}
