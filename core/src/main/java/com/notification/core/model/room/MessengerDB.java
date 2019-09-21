package com.notification.core.model.room;

/**
 * Created by naimish on 07/12/2018
 */
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.notification.core.model.room.dao.NotificationDao;
import com.notification.core.model.room.entity.NotificationEntity;

@Database(entities = {NotificationEntity.class}, version = 1)
public abstract class MessengerDB extends RoomDatabase {
    private static final String TAG = "MessengerDB";

    public abstract NotificationDao getNotificationDao();

}
