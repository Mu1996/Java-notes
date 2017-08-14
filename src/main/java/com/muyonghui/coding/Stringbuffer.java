package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/11.
 */

import java.util.Scanner;
//思路：从偶串的末尾开始依次减少两个字符，把剩下的字符串分成两部分，判断是否相等，是就跳出循环得到长度，否就再进行
public class Stringbuffer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        StringBuffer sb1=new StringBuffer(s);
        StringBuffer sb2=new StringBuffer();
        StringBuffer sb3=new StringBuffer();
        for(int i=s.length()-2;i>0;i--){
            sb1.delete(i, s.length());
            sb2.append(sb1, 0, sb1.length()/2);//前一半字符
            sb3.append(sb1, sb1.length()/2, sb1.length());//后一半字符
            if((sb2.toString()).equals(sb3.toString())){
                break;
            }
            i--;//为了实现每个减2个字符，因为偶串肯定是偶数个字符
            sb2.delete(0, sb2.length());
            sb3.delete(0, sb3.length());
        }
        System.out.println(sb1.length());
        sc.close();
    }
}
