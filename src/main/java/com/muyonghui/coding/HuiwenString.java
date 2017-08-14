package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/11.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class HuiwenString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int[] ch = new int[26];
            int length = str.length();
            for(int i = 0; i < length; i++){
                ch[str.charAt(i) - 'a']++;
            }
            int odd = 0;
            for(int i = 0; i < 26; i++){
                if(ch[i] % 2 == 1) odd++;
            }
            System.out.println(odd == 0 ? 1 : odd);
        }
    }
}

