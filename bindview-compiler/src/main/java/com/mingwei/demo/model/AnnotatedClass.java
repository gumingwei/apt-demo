package com.mingwei.demo.model;

import com.mingwei.demo.TypeUtil;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by mingwei on 12/10/16.
 */
public class AnnotatedClass {

    /**
     * 类名
     */
    public TypeElement mClassElement;
    /**
     * 成员变量
     */
    public List<BindViewField> mFiled;
    /**
     * 元素帮助类
     */
    public Elements mElementUtils;

    public AnnotatedClass(TypeElement classElement, Elements elementUtils) {
        this.mClassElement = classElement;
        this.mElementUtils = elementUtils;
        this.mFiled = new ArrayList<>();
    }

    public String getFullClassName() {
        return mClassElement.getQualifiedName().toString();
    }

    public void addFiled(BindViewField field) {
        mFiled.add(field);
    }

    public JavaFile generateFinder() {

        /**
         * 组装方法
         */
        MethodSpec.Builder injectMethodBuilder = MethodSpec.methodBuilder("inject")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(TypeName.get(mClassElement.asType()), "host", Modifier.FINAL)
                .addParameter(TypeName.OBJECT, "source")
                .addParameter(TypeUtil.FINDER, "finder");

        for (BindViewField field : mFiled) {
            injectMethodBuilder.addStatement("host.$N=($T)finder.findView(source,$L)", field.getFieldName()
                    , ClassName.get(field.getFieldType()), field.getResId());

        }

        String packageName = getPackageName(mClassElement);
        String className = getClassName(mClassElement, packageName);
        ClassName bindClassName = ClassName.get(packageName, className);

        TypeSpec finderClass = TypeSpec.classBuilder(bindClassName.simpleName() + "$$Inject")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(TypeUtil.INJECTOR, TypeName.get(mClassElement.asType())))
                .addMethod(injectMethodBuilder.build())
                .build();

        return JavaFile.builder(packageName, finderClass).build();
    }

    public String getPackageName(TypeElement type) {
        return mElementUtils.getPackageOf(type).getQualifiedName().toString();
    }

    private static String getClassName(TypeElement type, String packageName) {
        int packageLen = packageName.length() + 1;
        return type.getQualifiedName().toString().substring(packageLen).replace('.', '$');
    }
}
