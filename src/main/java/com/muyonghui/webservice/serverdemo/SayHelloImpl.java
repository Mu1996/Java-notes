package com.muyonghui.webservice.serverdemo;

import javax.jws.WebService;

@WebService
public class SayHelloImpl implements ISayHello{

    public String sayHello(String name) {
        System.out.println("call sayHello()");
        return "Hello ,"+name+",I'am mu";
    }
}


