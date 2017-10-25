package com.muyonghui.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
* 在访问private或protected成员变量和方法时，
* 必须通过setAccessible（）方法取消Java语言检查，
* 否则将抛出IllegalAccessException
* */
public class PrivateCarReflect {

    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.muyonghui.reflect.PrivateCar");
        PrivateCar pcar = (PrivateCar)clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        // 取消Java语言访问检查以访问private变量
        colorFld.setAccessible(true);
        colorFld.set(pcar, "red");

        Method driveMtd = clazz.getDeclaredMethod("drive",(Class[])null);

        // 取消Java语言访问检查以访问protected方法
        driveMtd.setAccessible(true);
        driveMtd.invoke(pcar,(Object[])null);

    }

}
