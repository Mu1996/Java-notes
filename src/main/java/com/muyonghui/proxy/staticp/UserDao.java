package com.muyonghui.proxy.staticp;

/**
 * 接口实现
 * 目标对象
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("执行方法Save");
    }
}
