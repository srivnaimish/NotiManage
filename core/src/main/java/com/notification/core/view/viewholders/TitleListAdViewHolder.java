package com.notification.core.view.viewholders;

import android.content.Context;
import androidx.annotation.NonNull;

import android.view.View;

import com.notification.core.utils.Constants;

/**
 * Created by anuragdalia on 26/08/18.
 */

public class TitleListAdViewHolder extends BannerAdViewHolder {

    Context context;

    public TitleListAdViewHolder(Context context, @NonNull View itemView) {
        super(context, itemView);
        this.context = context;
    }

    @Override
    protected String getAdUnitId() {
        return Constants.BANNER_TITLE_LIST;
    }
}
