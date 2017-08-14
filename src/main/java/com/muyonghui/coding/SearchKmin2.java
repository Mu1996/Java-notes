package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/11.
 */

import java.util.Arrays;
import java.util.Scanner;

public class SearchKmin2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int level = 1;
        int[] price = new int[count];
        for (int i = 0; i < count; i++) {
            price[i] = sc.nextInt();
        }
        Arrays.sort(price);
        for (int i = 1; i < count; i++) {
            if (price[i-1] < price[i]){
                level++;
            }
            if (level==3){
                System.out.println(price[i]);
                break;
            }
        }
        if (level<3){
            System.out.println(-1);
        }
    }
}
