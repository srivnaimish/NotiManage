package com.notification.core.view.activity.titleWise;

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
public class TitleWiseViewModel extends ViewModel {

    private NotificationDao notificationDao;

    @Inject
    TitleWiseViewModel(NotificationDao dao) {
        this.notificationDao = dao;
    }

    private PagedList.Config pagedListConfig =
            new PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(20)
                    .build();

    public LiveData<PagedList<NotificationRow>> getAppWiseNotifications(String appPackage) {
        if (notificationDao == null) {
            return null;
        }
        DataSource.Factory<Integer, NotificationRow> dataSourceFactory = notificationDao.getTitleWiseNotifications(appPackage);
        return new LivePagedListBuilder<>(dataSourceFactory, pagedListConfig)
                .build();
    }
}
