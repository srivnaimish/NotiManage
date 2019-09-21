package com.notification.core.view.fragment.newNotifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import javax.inject.Inject;

import com.notification.core.model.pojo.NotificationRow;
import com.notification.core.model.room.dao.NotificationDao;
import com.notification.core.utils.SharedPrefUtil;

/**
 * Created by naimish on 10/12/2018
 */
public class NewNotificationsViewModel extends ViewModel {

    NotificationDao notificationDao;
    SharedPrefUtil sharedPrefUtil;

    @Inject
    NewNotificationsViewModel(NotificationDao dao, SharedPrefUtil sharedPrefUtil) {
        this.notificationDao = dao;
        this.sharedPrefUtil = sharedPrefUtil;
    }

    private PagedList.Config pagedListConfig =
            new PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(20)
                    .build();

    public LiveData<PagedList<NotificationRow>> getNewNotificationApps(long time) {
        if (notificationDao == null) {
            return null;
        }


        DataSource.Factory<Integer, NotificationRow> dataSourceFactory
                = notificationDao.getNotificationsSinceLastOpen(time);
        return new LivePagedListBuilder<>(dataSourceFactory, pagedListConfig)
                .build();
    }
}
