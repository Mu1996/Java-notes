package com.muyonghui.temp;/*
 * Created by muyonghui on 2017/9/3.
 */

import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<List<String>> fatherList = new LinkedList<List<String>>();
        List<String > childList = new LinkedList<String>();
        childList.add("before add child list");
        fatherList.add(childList);
        childList.add("afer add child list");
        System.out.println(childList);
        System.out.println(fatherList);
    }
}
