package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/7.
 */

import java.util.Scanner;

public class YouYaDian {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int rSquare = in.nextInt();
        int count =0;
        double r = Math.sqrt(rSquare);

        //存储值
        for(int i=0;i<r;i++){
            //优化点1
            double j = Math.sqrt(rSquare-i*i);
            if((int) j==j){
                count++;
            }
        }

        //优化点2
        System.out.print(count*4+4);

    }

}
