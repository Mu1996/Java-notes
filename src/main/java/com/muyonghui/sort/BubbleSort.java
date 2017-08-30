package com.muyonghui.sort;

public class BubbleSort{

    public static void main(String[] args){
        int a[] = {1, 23, 45, 6, 0, 99, 100, 89, 34, 56};

        System.out.println("排序前：");
        for (int i = 0; i < a.length; ++ i)
            System.out.print(a[i] + " ");

        bubbleSort(a);

        System.out.println();
        System.out.println("排序后：");
        for (int i = 0; i < a.length; ++ i)
            System.out.print(a[i] + " ");
    }

    public static void bubbleSort(int a[]){
        int temp  = 0;

        for (int i = 0; i < a.length - 1; ++ i){
            for (int j = i; j < a.length; ++ j){

                if (a[i] > a[j]){
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    // 改进版
    public static void bubbleSort2(int[] arr) {
        boolean flag = true;
        while(flag){
            int temp;//定义一个临时变量
            for(int i=0;i<arr.length-1;i++){//冒泡趟数，n-1趟
                for(int j=0;j<arr.length-i-1;j++){
                    if(arr[j+1]<arr[j]){
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        flag = true;
                    }
                }
                if(!flag){
                    break;//若果没有发生交换，则退出循环
                }
            }
        }
    }
}
