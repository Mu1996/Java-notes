package com.muyonghui.reflect;

public class PrivateCar {

    // private成员变量 传统的类实例调用方式，只能在本类中访问
    private String color;

    // protected方法 传统类实例调用方法，只能在子类和本包中使用
    protected void drive(){
        System.out.println("drive private car! the color is: " + color);
    }
}
