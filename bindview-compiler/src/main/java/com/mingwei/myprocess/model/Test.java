package com.mingwei.myprocess.model;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;


import javax.lang.model.element.Modifier;

/**
 * Created by mingwei on 12/15/16.
 * CSDN:    http://blog.csdn.net/u013045971
 * Github:  https://github.com/gumingwei
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.print("hello");
        MethodSpec methodmain = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "arge")
                .addStatement("$T.out.print($S)", System.class, "hello javapoet")
                .build();

        TypeSpec typeMain = TypeSpec.classBuilder("Main")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(methodmain)
                .build();

        JavaFile javaFile = JavaFile.builder("com.mingwei.model", typeMain).build();

        javaFile.writeTo(System.out);
    }
}
