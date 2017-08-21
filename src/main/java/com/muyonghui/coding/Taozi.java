package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/21.
 */

import java.lang.reflect.Array;
import java.util.*;
public class Taozi {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int pick(int[] peaches) {
        int max = 0;
        int[] temp = Arrays.copyOf(peaches,peaches.length);
        Arrays.sort(temp);

        for (int i = 0; i < peaches.length; i++){
            int count = 0;
            int x = i;

            for (int j = 0; j < peaches.length; j++){


                if (peaches[j] == temp[i]){
                    count++;
                }
                if (x == peaches.length-1)
                    break;

                if (count > 0 && peaches[j] == temp[x+1]){
                    count++;
                    x++;
                }

            }
            if (count > max)
                max = count;
        }
        return max;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(pick(peaches));
    }
}
