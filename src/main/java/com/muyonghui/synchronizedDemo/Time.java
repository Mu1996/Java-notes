package com.muyonghui.synchronizedDemo;

import java.util.Date;

public class Time implements Runnable{
    private Date flag = new Date();
    private TimeRun[] runs;


    public Time(TimeRun[] timeRuns){
        runs = timeRuns;
    }

    public void run() {

        while (true){
            double sleepTime = Math.random()*10;
            try {
                flag = new Date();
                System.out.println("change" + sleepTime);
                if (sleepTime > 5){
                    for (int i = 0; i<runs.length; i++){
                        runs[i].unPark();
                    }
                }else{
                    for (int i = 0; i<runs.length; i++){
                        runs[i].park();
                    }
                }

                Thread.sleep((long) (sleepTime*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        TimeRun[] timeRuns = new TimeRun[5];
        for (int i = 0; i < timeRuns.length; i++){
            timeRuns[i] = new TimeRun();
            timeRuns[i].start();
        }
        new Thread(new Time(timeRuns)).start();

    }
}
