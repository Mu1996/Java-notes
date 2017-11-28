package com.muyonghui.proxy.cglib;

/**
 * 目标对象
 */
public class UserDao{
    public void save() {
        System.out.println("执行方法Save");
    }
}
