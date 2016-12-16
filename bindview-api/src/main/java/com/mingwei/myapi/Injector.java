package com.mingwei.myapi;

import com.mingwei.myapi.finder.Finder;

/**
 * Created by mingwei on 12/16/16.
 */
public interface Injector<T> {
    /**
     * @param host
     * @param source
     * @param finder
     */
    void inject(T host, Object source, Finder finder);
}
