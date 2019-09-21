package messenger.notificationsaver.messenger.notification.messengernotification.application;

import com.notification.core.model.dagger.ViewModelModule;
import com.notification.core.model.dagger.inject.PerApplication;
import com.notification.core.model.dagger.qualifiers.NotificationActivityBuilder;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import messenger.notificationsaver.messenger.notification.messengernotification.dagger.AppModule;

/**
 * Created by naimish on 07/12/2018
 */
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, NotificationActivityBuilder.class, ViewModelModule.class})
@PerApplication
public interface NotificationAppComponent extends AndroidInjector<NotificationApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(NotificationApplication application);

        NotificationAppComponent build();
    }
}

