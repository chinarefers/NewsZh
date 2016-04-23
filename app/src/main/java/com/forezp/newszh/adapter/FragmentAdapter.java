package com.forezp.newszh.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.forezp.newszh.fragment.ContentFragment;

public class FragmentAdapter extends FragmentStatePagerAdapter {
	
	public final static int TAB_COUNT = 1;
	
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int id) {
		switch (id) {
		case 0:
			ContentFragment nf = new ContentFragment();
			return nf;
		case 1:
			ContentFragment nf1 = new ContentFragment();
			return nf1;
		case 2:
			ContentFragment nf2 = new ContentFragment();
			return nf2;
		
			default:
				break;
		}
		return null;
	}

	@Override
	public int getCount() {
		return TAB_COUNT;
	}
	
}
