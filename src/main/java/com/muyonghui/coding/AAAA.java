package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/12.
 */

import java.util.Scanner;

public class AAAA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] cd = str.toCharArray();
        char ch = cd[0];
        int count = 1;
        for (int i = 1; i < cd.length; i++) {
            if(cd[i]==ch){
                count++;
            }else{
                System.out.print(count+""+cd[i-1]);
                count = 1;
                ch = cd[i];
            }
            if (i == cd.length-1){
                System.out.print(count+""+cd[i-1]);
            }
        }
    }
}
