package com.mingwe.myanno;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by mingwei on 12/20/16.
 */
@Target(METHOD)
@Retention(CLASS)
public @interface OnClick {
    int[] value();
}