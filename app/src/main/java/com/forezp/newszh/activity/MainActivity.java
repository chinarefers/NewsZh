package com.forezp.newszh.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.forezp.newszh.Constants;
import com.forezp.newszh.R;
import com.forezp.newszh.adapter.FragmentAdapter;
import com.forezp.newszh.fragment.ContentFragment;
import com.forezp.newszh.utils.TheamUtis;
import com.forezp.newszh.widget.CustomViewPager;
import com.nineoldandroids.view.ViewHelper;
import com.trilink.androidlib.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.rl_title)
    RelativeLayout rlTitle;
    @Bind(R.id.frame_content)
    FrameLayout frameContent;
    private DrawerLayout mDrawerLayout;
    @Bind(R.id.viewpager)
    CustomViewPager viewpager;
    public FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /**
         * drawableLayout
         */
        initView();
        initEvents();
        updateTitle(getResources().getString(R.string.today_headlines));

    }

    /**
     * @param title
     */
    private void updateTitle(String title) {
        if(!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }
        rlTitle.setBackgroundResource(TheamUtis.getThemeColor());
    }

    public void OpenLeftMenu(View view) {
        mDrawerLayout.openDrawer(Gravity.LEFT);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                Gravity.LEFT);
    }


    private void initEvents() {
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerStateChanged(int newState) {
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = mDrawerLayout.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;

                if (drawerView.getTag().equals("LEFT")) {
//
                   // float leftScale = 1 - 0.3f * scale;

                  //  ViewHelper.setScaleX(mMenu, leftScale);
                  //  ViewHelper.setScaleY(mMenu, leftScale);
                  //  ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                  //  ViewHelper.setTranslationX(mContent,
                  //          mMenu.getMeasuredWidth() * (1 - scale));
                  //  ViewHelper.setPivotX(mContent, 0);
                //    ViewHelper.setPivotY(mContent,
                      //      mContent.getMeasuredHeight() / 2);
                   // mContent.invalidate();
                    //ViewHelper.setScaleX(mContent, rightScale);
                   // ViewHelper.setScaleY(mContent, rightScale);
                } else {
                    ViewHelper.setTranslationX(mContent,
                            -mMenu.getMeasuredWidth() * slideOffset);
                    ViewHelper.setPivotX(mContent, mContent.getMeasuredWidth());
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                }

            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                mDrawerLayout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }
        });
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                Gravity.RIGHT);
        replaceFragment(R.id.frame_content, new ContentFragment());
        //adapter = new FragmentAdapter(getSupportFragmentManager());
        //  viewpager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void closeLeftMenu(int type) {
        mDrawerLayout.closeDrawer(Gravity.LEFT);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                Gravity.LEFT);
        ContentFragment contentFragment=ContentFragment.getInstance(type);
        replaceFragment(R.id.frame_content,contentFragment);

        updateTitle(getTitle(type));

    }

    public void replaceFragment(int id, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.commit();

    }
    private String  getTitle(int type) {
        switch (type) {
            case Constants.YESTERDAY_ANSWERS:
                return getResources().getString(R.string.today_headlines);

            case Constants.RECENT_ANSWERS:
                return getResources().getString(R.string.recent_headlines);

            case Constants.ARCHIVE_ANSWERS:
                return getResources().getString(R.string.history_headlines);

        }
        return getResources().getString(R.string.today_headlines);
    }
}
