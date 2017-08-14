package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/12.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetArea {

    static class Point{
        char color;
        int x;
        int y;
        int z;
    }

    // 计算两点之间的距离
    public static double distance(Point A, Point B){
        return Math.sqrt((A.x-B.x)*(A.x-B.x) + (A.y-B.y)*(A.y-B.y) + (A.z-B.z)*(A.z-B.z));
    }

    // 判断三个点颜色是否满足条件
    public static boolean colorIsMathed(Point A, Point B, Point C) {
        if (A.color == B.color && B.color == C.color) { // 三个点的颜色相同
            return true;
        }else if (A.color!=B.color && A.color!=C.color && B.color!=C.color) { // 三个点的颜色都不相同
            return true;
        }else {
            return false;
        }
    }

    // 判断三个点是否能构成三角形
    public static boolean isSan(Point A, Point B, Point C) {
        double a = distance(A, B);
        double b = distance(A, C);
        double c = distance(B, C);
        if (a<(b+c) && b<(a+c) && c<(a+b)
                && a>Math.abs(b-c) && b>Math.abs(a-c) && c>Math.abs(a-b)){
            return true;
        }
        return false;
    }

    // 计算三角形面积
    public static double getArea(Point A, Point B, Point C) {
        double a = distance(A, B);
        double b = distance(A, C);
        double c = distance(B, C);
        double p = (a + b + c) / 2;
        return  Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        List<Point> list = new ArrayList<Point>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // 将输入的点添加到 List 中
        for(int i = 0; i < n; i++){
            Point p = new Point();
            String[] arr = sc.nextLine().split(" ");
            p.color = arr[0].charAt(0);
            p.x = Integer.parseInt(arr[1]);
            p.y = Integer.parseInt(arr[2]);
            p.z = Integer.parseInt(arr[3]);
            list.add(p);
        }

        double maxArea = 0;
        double area = 0;
        // 遍历所有可能的三个点
        for(int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++){
                    Point A = list.get(i);
                    Point B = list.get(j);
                    Point C = list.get(k);

                    if (isSan(A,B,C) && colorIsMathed(A,B,C)) {
                        area = getArea(A, B, C);
                    }
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        System.out.format("%.5f", maxArea);

    }

}
