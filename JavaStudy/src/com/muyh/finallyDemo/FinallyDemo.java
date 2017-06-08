package com.muyh.finallyDemo;/*
 * Created by muyonghui on 2017/6/8.
 */

public class FinallyDemo {

    public static int test1() {
        int i=1;
        try{
            System.out.println("trying");
            i=i/0;
            return i;
        }catch (Exception e){
            System.out.println("catch");
            return 2;
        }finally {
            System.out.println("finally");
        }
    }

    // test2输出：1
    /*
    * 实际上，Java虚拟机会把finally语句块作为subroutine
    * 直接插入到 try 语句块或者 catch 语句块的控制转移语句之前。
    * 但是，还有另外一个不可忽视的因素，
    * 那就是在执行 subroutine（也就是 finally 语句块）之前，
    * try 或者 catch 语句块会保留其返回值到本地变量表（Local Variable Table）中。
    * 待 subroutine 执行完毕之后，再恢复保留的返回值到操作数栈中，
    * 然后通过 return 或者 throw 语句将其返回给该方法的调用者（invoker）。
    * */
    public static int test2() {
        int i=1;
        try{
            return i;
        }finally {
            i++;
        }
    }
    // test3输出：5
    public static int test3() {
        int i = 1;
        try {
            i = 4;
        } finally {
            i++;
            return i;
        }
    }
    // test4输出：5
    public static int test4() {
        int i = 1;
        try {
            i = 4;
        } finally {
            i++;
        }

        return i;
    }

    /* test5输出：
    * try block
    * return statement
    * finally block
    * after return
    * */
    public static String test5_1() {
        try {
            System.out.println("try block");
            return test5_2();
        } finally {
            System.out.println("finally block");
        }
    }
    public static String test5_2() {
        System.out.println("return statement");
        return "after return";
    }


    public static void main(String[] args) {
        System.out.println(test3());
    }
}

