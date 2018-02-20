package com.muyonghui.SerializeDemo;

import java.io.Serializable;

public class Person implements Serializable{

    // 能够保证序列化的对象和反序列化以后的对象是同一个
    private static final long serialVersionUID = -2983455374594992019L;

    // 序列化并不保存静态变量的状态
    public static int phone;

    // transient修饰的属性不会被序列化
    private transient String address;

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getPhone() {
        return phone;
    }

    public static void setPhone(int phone) {
        Person.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
