package com.muyonghui.lockDemo;/*
 * Created by muyonghui on 2017/8/5.
 */

public class Customer implements Runnable {

    private Person person;

    public Customer(Person person){
        this.person = person;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++){
            try {
                person.out();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
