package com.notification.core.view.activity.landing;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.notification.core.view.fragment.allNotifications.AllNotificationsFragment;
import com.notification.core.view.fragment.newNotifications.NewNotificationsFragment;

/**
 * Created by naimish on 10/12/2018
 */
public class LandingPagerAdapter extends FragmentPagerAdapter {

    String[] title = {"New","All"};

    public LandingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NewNotificationsFragment.newInstance();
            default:
                return AllNotificationsFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
