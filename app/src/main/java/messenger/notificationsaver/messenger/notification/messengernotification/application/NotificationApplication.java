package messenger.notificationsaver.messenger.notification.messengernotification.application;

import android.content.Context;
import androidx.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.google.firebase.FirebaseApp;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by naimish on 07/12/2018
 */
public class NotificationApplication extends DaggerApplication {

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        FirebaseApp.initializeApp(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        NotificationAppComponent injector = DaggerNotificationAppComponent.builder()
                .application(this)
                .build();
        injector.inject(this);
        return injector;
    }

    public AndroidInjector<? extends DaggerApplication> getInjector(){
        return applicationInjector();
    }
}
