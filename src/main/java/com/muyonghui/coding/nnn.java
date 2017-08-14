package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/12.
 */

import java.util.Scanner;

public class nnn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
//        int[] a = new int[n];
//        int[] b = new int[n];
//        for (int i = 0; i<n; i++){
//            a[i] = sc.nextInt();
//        }
//        for (int i = 0; i<n; i++){
//            b[i] = sc.nextInt();
//        }
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n == 1){
            System.out.println(k);

        }else if (n > 1 && k == 1){
            System.out.println(n);
        }else{
            int a = (int) Math.pow(k,n);

            System.out.println();
        }


    }
}
