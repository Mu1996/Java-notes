package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/7.
 */

import java.util.Scanner;

public class RevFanZhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int result = rev(rev(x)+rev(y));
        System.out.println(result);
    }
    public static int rev(int x){
        int i = 0;
        while (x!=0){
            i = x%10+ 10*i;
            x/=10;
        }
        return i;
    }
}
