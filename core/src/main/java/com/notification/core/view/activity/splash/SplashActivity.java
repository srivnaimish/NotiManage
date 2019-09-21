package com.notification.core.view.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import com.notification.core.model.NotificationType;
import com.notification.core.utils.SharedPrefUtil;
import com.notification.core.utils.IntentFactory;
import com.notification.core.utils.Utilities;
import com.notification.core.view.activity.WebActivity;
import com.notification.core.view.activity.base.BaseActivityView;

public class SplashActivity extends BaseActivityView<SplashContract.Presenter> implements SplashContract.View {


    @Inject
    SharedPrefUtil sharedPrefUtil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (handleNotification(getIntent().getExtras())) {
            finish();
            return;
        }

        if (sharedPrefUtil.hasSeenOnBoarding()) {
            startActivity(IntentFactory.getLandingActivity(SplashActivity.this));
            finish();
            return;
        }
        startActivity(IntentFactory.getOnboardingActivity(SplashActivity.this));
        finish();
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    private boolean handleNotification(@Nullable Bundle bundle) {
        if (bundle == null) {
            return false;
        }

        final String type = bundle.getString("type");

        if (type == null) {
            return false;
        }

        Intent intent = null;

        switch (type) {
            case NotificationType.WEB_OPEN: {
                final String url = bundle.getString("url");
                if (url == null) {
                    return false;
                }

                intent = new Intent(this, WebActivity.class);
                intent.putExtra("url", url);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                break;
            }
            case NotificationType.APP_OPEN: {
                final String url = bundle.getString("url");
                if (url == null) {
                    return false;
                }
                intent = Utilities.getAppLaunchIntent(this, url);
                break;
            }
            default:

        }
        if (intent == null) {
            return false;
        }
        startActivity(intent);
        finish();
        return true;
    }
}