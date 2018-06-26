package com.rishabh.gituserlist.ui.adapter;

/**
 * Created on 16/04/18.
 */

public class BaseListItem {

    private long id;

    public BaseListItem(long id) {
        this.id = id;
        if (id == 0) {
            throw new IllegalArgumentException();
        }
    }

    public long getId() {
        return id;
    }
}
