package com.forezp.newszh.domain;

import android.support.v4.app.Fragment;

import com.forezp.newszh.Constants;
import com.forezp.newszh.fragment.ContentFragment;

/**
 *
 */
public class MenuItem {
    private String title;
    private int resId;
    private int type = 1;
    private boolean selected = false;

    public MenuItem(String title, int type, int resId) {
        this.title = title;
        this.type = type;
        this.resId = resId;
    }

    public Fragment getFragmentInstance() {
        switch (type) {
            case Constants.YESTERDAY_ANSWERS:
            case Constants.ARCHIVE_ANSWERS:
            case Constants.RECENT_ANSWERS:
                return ContentFragment.getInstance(type);
        }
        return ContentFragment.getInstance(type);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
