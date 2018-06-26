package com.rishabh.gituserlist.net;

import com.squareup.moshi.Moshi;

public class MoshiFactory {

    private static Moshi sMoshi = new Moshi.Builder().build();

    private MoshiFactory() {
    }

    public static Moshi getInstance() {
        return sMoshi;
    }
}
