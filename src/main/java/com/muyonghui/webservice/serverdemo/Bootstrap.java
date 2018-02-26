package com.muyonghui.webservice.serverdemo;

import javax.xml.ws.Endpoint;

public class Bootstrap {

    public static void main(String[] args) {

        Endpoint.publish("http://localhost:8080/hello",new SayHelloImpl());

        System.out.println("publish success");
    }
}
