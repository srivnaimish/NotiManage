package com.notification.core.view.adapters;

import androidx.paging.PagedListAdapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.notification.core.utils.Constants;
import com.notification.core.view.viewholders.BaseViewHolder;

public abstract class BasePageAdapter<T,W extends BaseViewHolder> extends PagedListAdapter<T, W> {
    protected BasePageAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    public int getRealPosition(int position) {
        return position - position / Constants.AD_REPEAT_POSITION;
    }
}