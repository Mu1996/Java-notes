package com.muyonghui.synchronizedDemo;/*
 * Created by muyonghui on 2017/8/5.
 */

public class Person {

    private int person = 10;

    private Object syncObject = new Object();

    public Person(){

    }

    public void in (){

        synchronized (syncObject){

            while (person >= 10){

                try {
                    System.out.println("人满了");
                    syncObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread()+"进入了一个人");
            person++;
            syncObject.notifyAll();


        }

    }

    public void out (){

        synchronized (syncObject){

            while (person <= 0){

                try {
                    System.out.println(Thread.currentThread()+"走完了");
                    syncObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            person--;
            System.out.println(Thread.currentThread()+"走出了一个人，剩下还有" + person);
            syncObject.notifyAll();

        }

    }


    public static void main(String[] args) {
        Person person = new Person();

        new Thread(new Customer(person),"消费者1").start();
        new Thread(new Provider(person),"生产者1").start();
        new Thread(new Provider(person),"生产者2").start();
        new Thread(new Customer(person),"消费者2").start();
        new Thread(new Customer(person),"消费者3").start();
        new Thread(new Customer(person),"消费者4").start();

    }


}
