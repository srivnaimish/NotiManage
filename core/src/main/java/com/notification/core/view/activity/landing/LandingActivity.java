package com.notification.core.view.activity.landing;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.MobileAds;

import com.notification.core.R;
import com.notification.core.utils.Constants;
import com.notification.core.utils.IntentFactory;
import com.notification.core.view.activity.base.BaseActivityView;

import java.util.Set;

/**
 * Created by naimish on 07/12/2018
 */
public class LandingActivity extends BaseActivityView<LandingContract.Presenter> implements LandingContract.View {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private LandingPagerAdapter landingPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_landing;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager = findViewById(R.id.viewpager);
        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(presenter);

        landingPagerAdapter = new LandingPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(landingPagerAdapter);

        tabLayout = findViewById(R.id.landing_tabs);
        tabLayout.setupWithViewPager(viewPager);

        MobileAds.initialize(this, Constants.ADMOB_ACCOUNT);

        loadBannerAd();
        Set<String> enabledPackages = NotificationManagerCompat.getEnabledListenerPackages(context);
        if (enabledPackages.contains(context.getPackageName())) {
            loadInterstitial();
        }
    }

    @Override
    protected String getBannerId() {
        return Constants.BANNER_HOME;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!presenter.hasNotificationAccess(LandingActivity.this)) {
            return;
        }

        if (!presenter.isBatterySaverDisabled()) {  //For doze mode disable
            return;
        }

        if (!presenter.isAutoStartEnabled()) {  //For mi,oppo,etc devices
            return;
        }
    }

    @Override
    public void requestNotificationAccess() {
        new AlertDialog.Builder(this)
                .setTitle("Access Notifications")
                .setMessage("Allow Access to Phone Notifications")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    startActivity(IntentFactory.getNotificationAccessSetting());
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                })
                .setNegativeButton(android.R.string.cancel,(dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }

    @Override
    public void requestAutoStartPermission() {
        for (Intent intent : IntentFactory.AUTO_START_INTENTS) {
            if (getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                new AlertDialog.Builder(this)
                        .setTitle("Auto Start")
                        .setMessage("Enable Auto Start to access notifications in background")
                        .setPositiveButton("Settings", (dialog, which) -> {
                            sharedPrefUtil.setAutoStartEnabled();
                            startActivity(intent);
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        })
                        .setNegativeButton(android.R.string.cancel,(dialog, which) -> {
                            sharedPrefUtil.setAutoStartEnabled();
                            dialog.dismiss();
                        })
                        .show();
                return;
            }
        }
        sharedPrefUtil.setAutoStartEnabled();
    }

    @Override
    public void requestDisableBatteryOptimization() {
        new AlertDialog.Builder(this)
                .setTitle("Battery Optimization")
                .setMessage("Turn of Battery Optimization to allow seamless notification detection")
                .setPositiveButton("Turn off", (dialog, which) -> {
                    sharedPrefUtil.setBatteryOptimizationDisabled();
                    startActivity(IntentFactory.getBatteryOptimizationIntent(LandingActivity.this));
                })
                .setNegativeButton(android.R.string.cancel,(dialog, which) -> {
                    dialog.dismiss();
                    sharedPrefUtil.setBatteryOptimizationDisabled();
                })
                .show();
    }

    @Override
    public void onDestroy() {
        presenter.updateNotification();
        presenter.saveLastSession();
        super.onDestroy();
    }

    @Override
    public void openSearchActivity() {
        startActivity(IntentFactory.getSearchActivity(this));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void openSettingsActivity() {
        startActivity(IntentFactory.getSettingsActivity(this));
    }
}
