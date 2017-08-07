package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/7.
 */

import java.util.Scanner;

public class QiuJi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 2; i <= n; i++){
            if (i%2 != 0){
                sum+=i;
            }else{
                int x = i;
                x/=2;
                while (x%2 == 0){
                    x/=2;
                }
                sum+=x;
            }
        }
        System.out.println(sum+1);
    }
}
