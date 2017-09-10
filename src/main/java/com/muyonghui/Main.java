package com.muyonghui;/*
 * Created by muyonghui on 2017/9/10.
 */

import sun.nio.cs.ext.ISCII91;
import sun.tools.jconsole.MaximizableInternalFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        List l = new ArrayList<int[]>();
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int count = 0;
        int i=0;
        while (i<a.length) {
            if (a[i] == 0){
                count++;
            }
            i++;
            int tmp = i;
            for (int j = i; j < a.length; j++) {
                if (IsXor(a,tmp,j)){
                    count++;
                    int[] b = new int[2];
                    b[0] = tmp;
                    b[1] = j;
                    l.add(b);
                    tmp=j+1;
                }
            }
        }
        for (int j = 0; j < l.size(); j++) {

            for (int k = j+1; k < l.size(); k++) {
                int[] x = (int[]) l.get(j);
                int[] y = (int[]) l.get(k);

                if (isOverlap(x,y)){
                    count--;
                }
            }
        }
        System.out.println(count);

    }

    private static boolean isOverlap(int[] l1,int[] l2){
        int start = Math.max(l1[0],l2[0]);
        int end = Math.min(l1[1],l2[1]);
        if(start-end>=0)
            return true;
        return false;
    }
    private static boolean IsXor(int[] number, int start, int end) {
        int v = 0;
        for (int i = start;i <= end;i++) {
            v ^= number[i];
        }

        return (v == 0) ? true : false;
    }
}
