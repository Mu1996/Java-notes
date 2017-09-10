package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/9/9.
 */

import java.util.Scanner;

public class xiangfanshu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int y = 0;
        while (temp != 0){
            y = y*10 + temp%10;
            temp/=10;
        }
        System.out.println(n+y);
    }

}
