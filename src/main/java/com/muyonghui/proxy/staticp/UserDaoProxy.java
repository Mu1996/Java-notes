package com.muyonghui.proxy.staticp;

/**
 * 代理对象,静态代理
 */
public class UserDaoProxy implements IUserDao {

    //接收保存目标对象
    private IUserDao target;

    public UserDaoProxy(IUserDao target){
        this.target=target;
    }

    @Override
    public void save() {
        System.out.println("开始执行事务");
        target.save();
        System.out.println("开始提交事务");
    }
}
