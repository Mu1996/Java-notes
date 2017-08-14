package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/12.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();

        float n = (float) (d / x * 1.0);

        if (n > f){
            System.out.println(f+ (d-x*f)/(x+f));
        }else{
            System.out.println(d / x);
        }


    }
}
