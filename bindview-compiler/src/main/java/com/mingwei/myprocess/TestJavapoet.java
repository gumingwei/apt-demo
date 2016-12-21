package com.mingwei.myprocess;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

import javax.lang.model.element.Modifier;

/**
 * Created by mingwei on 12/21/16.
 */
public class TestJavapoet {
    public static void main(String[] arge) {
        MethodSpec methodmain = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "arge")
                .addStatement("$T.out.print($S)", System.class, "hello javapoet")
                .build();
        TypeSpec typeMain = TypeSpec.classBuilder("MainPP")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(methodmain)
                .build();

        JavaFile javaFile = JavaFile.builder("com.mingwei.japdemo", typeMain).build();

        try {
            javaFile.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
