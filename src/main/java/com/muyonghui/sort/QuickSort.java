package com.muyonghui.sort;

public class QuickSort {

    public static void main(String [] args){

        int a[] = {1, 2, 3, 56, 45, 22, 22, 26, 89, 130, 100};

        System.out.println("排序前：");
        for (int i = 0; i < a.length; ++ i){
            System.out.print(a[i] + " ");
        }

        quickSort2(a,0,a.length-1);

        System.out.println("\n");
        System.out.println("排序后：");
        for (int i = 0; i < a.length; ++ i){
            System.out.print(a[i] + " ");
        }
    }

    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
    }

    public static void quickSort2(int[] numbers, int start, int end) {
        int i,j,tmp,base;
        if (start > end)
            return;
        base = numbers[start];
        i = start;
        j = end;

        while (i != j){

            while(numbers[j]>=base && i<j){
                j--;
            }
            while(numbers[i]<=base && i<j){
                i++;
            }

            if (i < j){
                tmp = numbers[j];
                numbers[j] = numbers[i];
                numbers[i] = tmp;
            }


        }
        numbers[start] = numbers[i];
        numbers[i] = base;
        quickSort2(numbers, start, i -1);
        quickSort2(numbers, i+1, end);

    }
}
