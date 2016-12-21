package com.mingwei.myprocess.model;

import com.mingwe.myanno.OnClick;

import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.VariableElement;

/**
 * Created by mingwei on 12/21/16.
 */
public class OnClickMethod {

    private Name mMethodName;

    public int[] ids;

    public OnClickMethod(Element element) {
        if (element.getKind() != ElementKind.METHOD) {
            throw new IllegalArgumentException(String.format("Only method can be annotated width @%s",
                    OnClick.class.getSimpleName()));
        }
        ExecutableElement methodElement = (ExecutableElement) element;
        mMethodName = methodElement.getSimpleName();
        ids = methodElement.getAnnotation(OnClick.class).value();
        if (ids == null) {
            throw new IllegalArgumentException(String.format("Must set valid ids for @%s", OnClick.class.getSimpleName()));
        } else {
            for (int id : ids) {
                if (id < 0) {
                    throw new IllegalArgumentException(String.format("Must set valid ids for @%s", OnClick.class.getSimpleName()));
                }
            }
        }

        List<? extends VariableElement> parameters = methodElement.getParameters();
        if (parameters.size() > 0) {
            throw new IllegalArgumentException(String.format("The method annotated with @%s must have no parameters", OnClick.class.getSimpleName()));
        }

    }

    public Name getMethodName() {
        return mMethodName;
    }
}
