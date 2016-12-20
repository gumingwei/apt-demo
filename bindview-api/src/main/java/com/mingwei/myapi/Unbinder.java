package com.mingwei.myapi;

import android.support.annotation.UiThread;

/**
 * Created by mingwei on 12/20/16.
 */
public interface Unbinder {

    @UiThread
    void unbind();

    Unbinder EMPTY = new Unbinder() {
        @Override
        public void unbind() {

        }
    };
}
