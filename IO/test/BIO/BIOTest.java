package BIO;/*
 * Created by muyonghui on 2017/8/1.
 */

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class BIOTest {
    //测试主方法
    public static void main(String[] args) throws InterruptedException {
        //运行服务器
        new Thread(new Runnable() {

            public void run() {
                try {
                    BIOServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        final char operators[] = {'+','-','*','/'};


        new Thread(new Runnable() {
            public void run() {
                while(true){
                    Scanner sc = new Scanner(System.in);
                    System.out.print("请输入要发送的消息：");
                    String input = sc.nextLine();
                    BIOClient.send(input);
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
