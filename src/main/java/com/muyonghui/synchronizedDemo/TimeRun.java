package com.muyonghui.synchronizedDemo;

import java.util.concurrent.locks.LockSupport;

public class TimeRun extends Thread {
    private Boolean isPark = true;

    public void run() {

        while(true){
            if(isPark){
                System.out.println(Thread.currentThread().getName()+" stop");
                LockSupport.park();

            }
            System.out.println(Thread.currentThread().getName()+" running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void park(){
        isPark = true;
    }

    public void unPark(){
        isPark = false;
        LockSupport.unpark(this);
    }

}
