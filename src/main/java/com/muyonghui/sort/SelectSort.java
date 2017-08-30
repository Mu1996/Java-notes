package com.muyonghui.sort;

public class SelectSort{
    public static void main(String [] args){

        int a[] = {1, 2, 3, 56, 45, 22, 22, 26, 89, 99, 100};

        System.out.println("排序前：");
        for (int i = 0; i < a.length; ++ i){
            System.out.print(a[i] + " ");
        }

        selectSort(a);

        System.out.println("\n");
        System.out.println("排序后：");
        for (int i = 0; i < a.length; ++ i){
            System.out.print(a[i] + " ");
        }
    }

    public static void selectSort(int a[]){

        int min = 0;
        int temp = 0;


        for (int i = 0; i < a.length - 1; ++ i){

            min = i;
            for (int j = i + 1; j < a.length; ++ j){
                if (a[min] > a[j]){
                    min = j;
                }
            }

            if (min != i){
                temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }
}

