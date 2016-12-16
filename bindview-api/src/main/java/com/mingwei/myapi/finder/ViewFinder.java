package com.mingwei.myapi.finder;

import android.content.Context;
import android.view.View;

/**
 * Created by mingwei on 12/16/16.
 * CSDN:http://blog.csdn.net/u013045971
 * Github:https://github.com/gumingwei
 */
public class ViewFinder implements Finder {

    @Override
    public Context getContext(Object source) {
        return ((View) source).getContext();
    }

    @Override
    public View findView(Object source, int id) {
        return ((View) source).findViewById(id);
    }
}