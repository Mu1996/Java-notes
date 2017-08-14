package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/12.
 */

import java.util.Scanner;
import java.lang.Math;
public class MinRoad{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n = input.nextInt();
        int point[] = new int[n];
        for(int i=0;i<n;i++){
            point[i] = input.nextInt();
        }
        int sum =0;
        for(int i=0;i<n-1;i++){
//求不删除任何点的距离
            sum += Math.abs(point[i+1]-point[i]);
        }
        int distance =0;
        for(int i =1;i<n-1;i++){
            //求删除某点缩短的距离取最大值
            int del = Math.abs(point[i+1]-point[i])+Math.abs(point[i]-point[i-1])-Math.abs(point[i+1]-point[i-1]);
            if(del>distance){
                distance =del;
            }
        }
        System.out.println(sum-distance);
    }
}
