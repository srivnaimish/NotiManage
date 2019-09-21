package com.notification.core.utils;

import android.os.Build;

import com.notification.core.BuildConfig;

/**
 * Created by naimish on 07/12/2018
 */
public interface Constants {

    /*Shared Preferences*/
    String SEEN_ONBOARDING = "seen_oboarding";
    String AUTO_START = "auto_start";
    String BATTERY_OPTIMIZATION = "battery_optimization";
    String INSTALLED_APPS_PACKAGES = "installed_apps_packages";

    /*Notification ids*/
    int MAIN_NOTIFICATION_ID = 9514;

    int AD_REPEAT_POSITION = 4;
    int AD_ROW = 1;

    long ONE_SECOND_MILLIS = 1000;

    long ONE_MINUTE_MILLIS = 60 * 1000;

    long ONE_HOUR_MILLIS = 60 * 60 * 1000;

    long ONE_DAY_MILLS = 24 * 60 * 60 * 1000L;

    long HALF_DAY_MILLS = 12 * 60 * 60 * 1000L;

    long ONE_YEAR_DAYS = 365L;

    long ONE_WEEK_DAYS = 7L;

    long ONE_WEEK_MILLS = ONE_WEEK_DAYS * ONE_DAY_MILLS;

    long ONE_YEAR_MILLS = ONE_YEAR_DAYS * ONE_DAY_MILLS;

    String blackList[] = {"com.android.vending"};
    String PACKAGE_NAME = "package_name";
    String NOTIFICATION_TITLE = "title";
    String NOTIFICATION_TAG = "tag";

    String DEFAULT_CHAT_VALUE = "com.snapchat.android;com.google.android.talk;com.google.android.apps.fireball;com.Slack;com.yahoo.mobile.client.android.im;com.viber.voip;com.whatsapp;com.facebook.mlite;com.facebook.orca;org.telegram.messenger;jp.naver.line.android;com.linecorp.linelite;com.kakao.talk;com.tencent.mm,com.instagram.android";

    String LAST_SESSION = "last_session";

    String ADMOB_ACCOUNT = "ca-app-pub-5640675684147577~6885347449";
    String DEBUG_BANNER = "ca-app-pub-3940256099942544/6300978111";
    String DEBUG_INTERSTITIAL = "ca-app-pub-3940256099942544/1033173712";
    String ADMOB_REWARDS = "ca-app-pub-3463246254277621/4734917514";
    String ADMOB_NATIVE = "ca-app-pub-3940256099942544/2247696110";

    String INTERSTITIAL_APP_OPEN = BuildConfig.DEBUG ? DEBUG_INTERSTITIAL : "ca-app-pub-5640675684147577/6418443589";
    String BANNER_HOME = BuildConfig.DEBUG ? DEBUG_BANNER : "ca-app-pub-5640675684147577/7320461715";
    String BANNER_TITLE = BuildConfig.DEBUG ? DEBUG_BANNER : "ca-app-pub-5640675684147577/6853557858";
    String BANNER_TEXT = BuildConfig.DEBUG ? DEBUG_BANNER : "ca-app-pub-5640675684147577/8270457592";
    String BANNER_SETTINGS = BuildConfig.DEBUG ? DEBUG_BANNER : "ca-app-pub-5640675684147577/1054436269";

    String BANNER_APP_LIST = BuildConfig.DEBUG ? DEBUG_BANNER : "ca-app-pub-7899176240468148/3485112382";
    String BANNER_TITLE_LIST = BuildConfig.DEBUG ? DEBUG_BANNER : "ca-app-pub-7899176240468148/1535759989";


    String SHOW_NOTIFICATION = "show_notification";
    String SERVICE_REQUEST_ACTION = "service_request";

    int RECEIVED_MESSAGE_TYPE = 0;
    int SENT_MESSAGE_TYPE = 1;

    String APP_URL = "https://play.google.com/store/apps/details?id=messenger.notificationsaver.messenger.notification.messengernotification";
}
