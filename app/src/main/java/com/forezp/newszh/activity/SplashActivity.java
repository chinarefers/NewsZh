package com.forezp.newszh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.forezp.newszh.R;
import com.trilink.androidlib.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;



/**
 * Created by gejiahui on 2016/3/29.
 */
public class SplashActivity extends BaseActivity {
    @Bind(R.id.shimmer_view_container)
    ShimmerFrameLayout shimmer;
    @Bind(R.id.background)
    RelativeLayout background;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
      //  background.setBackgroundColor(TheamUtis.getThemeColor());
        background.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        shimmer.startShimmerAnimation();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, 1600);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_none, R.anim.anim_none);
    }

}
