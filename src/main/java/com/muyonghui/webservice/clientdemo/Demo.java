package com.muyonghui.webservice.clientdemo;

public class Demo {

    public static void main(String[] args) {
        SayHelloImplService sayHelloImplService = new SayHelloImplService();
        SayHelloImpl sayHello= sayHelloImplService.getSayHelloImplPort();
        System.out.println(sayHello.sayHello("cc"));
    }
}
