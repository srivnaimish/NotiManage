package com.notification.core.view.fragment.allNotifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import javax.inject.Inject;

import com.notification.core.model.pojo.NotificationRow;
import com.notification.core.model.room.dao.NotificationDao;

/**
 * Created by naimish on 10/12/2018
 */
public class AllNotificationsViewModel extends ViewModel {

    NotificationDao notificationDao;

    @Inject
    AllNotificationsViewModel(NotificationDao dao) {
        this.notificationDao = dao;
    }

    private PagedList.Config pagedListConfig =
            new PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(20)
                    .build();

    public LiveData<PagedList<NotificationRow>> getAppsWithNotifications() {
        if (notificationDao == null) {
            return null;
        }
        DataSource.Factory<Integer, NotificationRow> dataSourceFactory = notificationDao.getAppsWithNotification();
        return new LivePagedListBuilder<>(dataSourceFactory, pagedListConfig)
                .build();
    }
}
