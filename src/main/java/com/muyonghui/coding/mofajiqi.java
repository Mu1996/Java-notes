package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/9/9.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mofajiqi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        x = sc.nextInt();
        List res = new ArrayList<Integer>();
        while (x!=0){
            if (x % 2 == 0){
                res.add(2);
                x = (x-2)/2;
            }else{
                res.add(1);
                x = (x-1)/2;
            }
        }

        for (int i = res.size()-1; i >= 0; i--) {
            System.out.print(res.get(i));
        }


    }
}
