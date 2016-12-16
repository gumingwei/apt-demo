package com.mingwei.myapi;

import com.mingwei.myapi.finder.Finder;

/**
 * Created by mingwei on 12/16/16.
 * CSDN:    http://blog.csdn.net/u013045971
 * Github:  https://github.com/gumingwei
 */
public interface Injector<T> {
    /**
     * @param host   目标
     * @param source 来源
     * @param finder
     */
    void inject(T host, Object source, Finder finder);
}
