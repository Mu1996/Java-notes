package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/9/9.
 */

import java.util.Scanner;

public class chongpaishulie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n>0){
            n--;
            int x = sc.nextInt();
            int[] a = new int[x];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            int four = 0;
            int two = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 4 == 0){
                    four++;
                }
                if (a[i] % 4 != 0 && a[i] % 2 == 0){
                    two++;
                }
            }

            if ((a.length-two)/2 > four){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }

        }
    }
}
