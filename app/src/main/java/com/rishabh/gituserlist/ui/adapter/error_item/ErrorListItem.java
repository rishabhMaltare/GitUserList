package com.rishabh.gituserlist.ui.adapter.error_item;


import com.rishabh.gituserlist.ui.adapter.BaseListItem;

/**
 * Created on 16/04/18.
 */

public class ErrorListItem extends BaseListItem {

    private String errorText;
    private RetryButtonListener retryButtonListener;

    public ErrorListItem(String errorText, RetryButtonListener retryButtonListener) {
        super(-3);
        this.errorText = errorText;
        this.retryButtonListener = retryButtonListener;
    }

    public String getErrorText() {
        return errorText;
    }

    public RetryButtonListener getRetryButtonListener() {
        return retryButtonListener;
    }

    public interface RetryButtonListener {
        void onClickRetryButton();
    }
}
