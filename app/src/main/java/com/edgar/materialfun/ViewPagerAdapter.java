package com.edgar.materialfun;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return ((RitualFragment)fragments.get(position)).getTabTitle();
        }
        if (position == 1) {
            return ((AlarmFragment)fragments.get(position)).getTabTitle();
        }
        if (position == 2) {
            return ((BankFragment)fragments.get(position)).getTabTitle();
        }
        if (position == 3) {
            return ((MusicFragment)fragments.get(position)).getTabTitle();
        }
        return ((MyFragment)fragments.get(position)).getTabTitle();
    }
}
