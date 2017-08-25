package com.muyonghui.synchronizedDemo;

import java.util.Date;

public class TimeChange implements Runnable {

    private Time time;

    public TimeChange(Time timer){
        time = timer;
    }

    public void run() {

        while (true){
            double sleepTime = Math.random()*2;
            try {
//                time.setFlag(new Date());
                System.out.println("change" + sleepTime);
                Thread.sleep((long) (sleepTime*1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
