package com.muyonghui.sort;

public class InsertSort {
    public static void main(String[] args){
        int a[] = {1, 23, 45, 6, 0, 99, 100, 89, 34, 56};

        System.out.println("排序前：");
        for (int i = 0; i < a.length; ++ i)
            System.out.print(a[i] + " ");

        insertSort(a);

        System.out.println();
        System.out.println("排序后：");
        for (int i = 0; i < a.length; ++ i)
            System.out.print(a[i] + " ");
    }
    public static void insertSort(int[] numbers) {
        int size = numbers.length, temp, j;
        for(int i=1; i<size; i++) {
            temp = numbers[i];
            for(j = i; j > 0 && temp < numbers[j-1]; j--)
                numbers[j] = numbers[j-1];
            numbers[j] = temp;
        }
    }
}
