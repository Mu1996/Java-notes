package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/11.
 */


import java.util.Scanner;
public class YNYNYN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        long ans = 1;
        boolean[] visited = new boolean[len + 1];
        for (int i = 2; i <= len; i++) {
            if (visited[i])
                continue;
            for (int j = 2 * i; j <= len; j += i)
                visited[j] = true;
            int count = 0;
            long k = i;   //int会溢出
            while (k <= len) {
                k *= i;
                count++;
            }
            ans = ans * (count + 1) % 1000000007;
        }
        System.out.println(ans);
    }

}