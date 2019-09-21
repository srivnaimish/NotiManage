package com.notification.core.view.fragment.newNotifications;

import androidx.lifecycle.ViewModelProviders;

import dagger.Module;
import dagger.Provides;
import com.notification.core.model.ViewModelFactory;
import com.notification.core.model.dagger.inject.PerFragment;

/**
 * Created by naimish on 10/12/2018
 */
@Module
public class NewNotificationsModule {
    @PerFragment
    @Provides
    NewNotificationsViewModel getModel(NewNotificationsFragment fragment, ViewModelFactory viewModelFactory) {
        return ViewModelProviders.of(fragment, viewModelFactory).get(NewNotificationsViewModel.class);
    }
}
