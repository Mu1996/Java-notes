package com.muyonghui.LockDemo;/*
 * Created by muyonghui on 2017/8/5.
 */

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Person {

    private int person = 10;

    private Object syncObject = new Object();

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public Person(){

    }

    public void in (){

        lock.lock();
        try{
            while (person >= 10){

                try {
                    System.out.println("人满了");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread()+"进入了一个人");
            person++;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void out (){

        lock.lock();
        try{
            while (person <= 0){

                try {
                    System.out.println("走完了");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            person--;
            System.out.println(Thread.currentThread()+"走出了一个人，剩下还有" + person);
            condition.signalAll();

        }finally {
            lock.unlock();
        }




    }


    public static void main(String[] args) {
        Person person = new Person();

        new Thread(new Customer(person),"消费者1").start();
        new Thread(new Provider(person),"生产者1").start();
        new Thread(new Provider(person),"生产者2").start();
        new Thread(new Customer(person),"消费者2").start();
        new Thread(new Customer(person),"消费者3").start();

    }


}
