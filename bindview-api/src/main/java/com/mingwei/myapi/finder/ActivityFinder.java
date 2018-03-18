package com.mingwei.myapi.finder;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by mingwei on 12/16/16.
 * CSDN:    http://blog.csdn.net/u013045971
 * Github:  https://github.com/gumingwei
 */
public class ActivityFinder implements Finder {
    @Override
    public Context getContext(Object source) {
        return (Activity) source;
    }

    @Override
    public View findView(Object source, int id) {
        return ((Activity) source).findViewById(id);
    }
}
