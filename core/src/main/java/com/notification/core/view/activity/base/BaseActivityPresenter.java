package com.notification.core.view.activity.base;

import androidx.annotation.CallSuper;

/**
 * Created by anuragdalia on 08/04/18.
 */

public abstract class BaseActivityPresenter<M extends BaseActivityContract.View> implements BaseActivityContract.Presenter {
    public M view;

    public BaseActivityPresenter(M view) {
        this.view = view;
    }

    @Override
    public void init() {

    }

    @Override
    @CallSuper
    public void kill() {

    }

    public boolean isSubscribed() {
        return view.activityIsResumed();
    }

}
