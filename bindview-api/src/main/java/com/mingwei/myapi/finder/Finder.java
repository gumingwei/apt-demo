package com.mingwei.myapi.finder;

import android.content.Context;
import android.view.View;

/**
 * Created by mingwei on 12/16/16.
 * CSDN:
 */
public interface Finder {

    Context getContext(Object source);

    /**
     * 根据id找控件
     *
     * @param source
     * @param id
     * @return
     */
    View findView(Object source, int id);
}
