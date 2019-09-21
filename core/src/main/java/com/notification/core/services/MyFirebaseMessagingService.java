package com.notification.core.services;

import android.content.Context;

import androidx.core.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by naimish on 18/12/2018
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final int REQUEST_CODE = 10;
    private static final int NOTIFICATION_ID = 1;
    private static final String TAG = "GCMMessagingService";
    private static final String FCM_TOKEN = "fcmToken";

    public static String getToken(Context context) {
        return context.getSharedPreferences("_", MODE_PRIVATE).getString(FCM_TOKEN, null);
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.e(TAG, "newToken " + s);
        getSharedPreferences("_", MODE_PRIVATE).edit().putString(FCM_TOKEN, s).apply();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }
}