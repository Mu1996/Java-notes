package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/7.
 */

import java.util.Scanner;

public class ABC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = new int[4];
        for (int i = 0; i < 4; i++) {
            input[i] = sc.nextInt();
        }

        float a,b,b2,c;

        a= (float) ((input[0]+input[2])/2.0);
        b= (float) ((input[1]+input[3])/2.0);
        b2= (float) ((input[2]-input[0])/2.0);
        c= (float) ((input[3]-input[1])/2.0);
        if (a-(input[0]+input[2])/2 ==0 && b == b2 && b - (input[2]-input[0])/2 == 0 && c - (input[3]-input[1])/2 == 0){
            System.out.print((int)a+" "+(int)b+" "+(int)c);
        }else{
            System.out.println("No");
        }

    }
}
