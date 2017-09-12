package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/9/9.
 */

import java.util.Scanner;
import java.math.BigDecimal;
public class stringsuipian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        int[] x = new int[ch.length];

        char tmp = ch[0];
        int n = 1;
        for (int i = 1; i < ch.length; i++) {
            if (tmp == ch[i]) {
                n++;
            }else{
                tmp = ch[i];
                x[n]++;
                n=1;
            }
            if (i == ch.length-1){
                x[n]++;
            }
        }
        double res = 0;
        double l = 0;
        for (int i = 0; i < ch.length; i++) {
            res+=i*x[i];
            l+=x[i];
        }
        BigDecimal   b   = new BigDecimal(Double.toString(res));
        BigDecimal   c   = new BigDecimal(Double.toString(l));
        System.out.println(String.format("%.2f",b.divide(c, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
    }
}
