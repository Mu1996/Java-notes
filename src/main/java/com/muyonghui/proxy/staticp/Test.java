package com.muyonghui.proxy.staticp;

public class Test {

    public static void main(String[] args) {
        UserDao target = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }
}
