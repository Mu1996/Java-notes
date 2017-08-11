package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/7.
 */

import java.util.Scanner;

public class AnHei {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        long[] num = new long[input + 1];
        num[1] = 3;
        num[2] = 9;
        for (int i = 3; i <= input; i++) {
            num[i] = 2 * num[i - 1] + num[i - 2];
        }
        System.out.print(num[input]);
    }
}

