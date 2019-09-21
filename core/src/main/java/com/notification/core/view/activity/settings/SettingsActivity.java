package com.notification.core.view.activity.settings;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import javax.inject.Inject;

import com.notification.core.R;
import com.notification.core.model.room.dao.NotificationDao;
import com.notification.core.utils.Constants;
import com.notification.core.view.activity.base.BaseActivity;

public class SettingsActivity extends BaseActivity {

    @Inject
    NotificationDao notificationDao;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        getFragmentManager().beginTransaction().replace(R.id.fragmentView, new MainPreferenceFragment()).commit();

        loadBannerAd();
    }

    @Override
    protected String getBannerId() {
        return Constants.BANNER_SETTINGS;
    }

    public void deleteAllNotifications() {
        AsyncTask.execute(() -> notificationDao.deleteNotifications());
    }
}
