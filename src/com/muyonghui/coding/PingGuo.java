package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/7.
 */

import java.util.Scanner;

public class PingGuo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            if (n%2 != 0 || n == 10 || n < 6){
                System.out.println(-1);
            } else if (n%8 == 0){
                System.out.println(n/8);
            }else{
                System.out.println(1+n/8);
            }
        }
    }

}
