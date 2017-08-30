package com.muyonghui.search;

/*
 * 从n个数中选出第k小的数
 * 从n个无序的顺序表中找出第k小的数，采用快排思想：
 * 先从n个元素中随便寻找一个数m作为分界点,m在列表中的位置为i
 * 当 i = k时，m就是我们要寻找的第k小的数；
 * 当 i > k时，我们就从1~i-1中查找；
 * 当 i < k时，就从i+1~n中查找。
 */
import java.util.Scanner;
public class QuickSearch {
    public static int partion(int A[], int low, int high) {
        int pivotkey = A[low];
        int temp;
        while (low < high) {
            while (low < high && A[high] >= pivotkey)
                high--;
            A[low] = A[high];
            while (low < high && A[low] <= pivotkey)
                low++;
            A[high] = A[low];
        }
        A[low] = pivotkey;
        return low;
    }
    public static  int quickSort(int A[],int low,int high,int k){
        if(low <= high){
            int pivotloc = partion(A,low,high);
            if(pivotloc == (k-1)){
                return A[pivotloc];
            }
            else if(pivotloc < (k-1)){
                return quickSort(A,pivotloc+1,high,k);
            }
            else{
                return quickSort(A,low,pivotloc-1,k);
            }
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int[] A = new int[] {1, 3, 5, 7, 8, 9};


//        for(int i = 0; i < n; i++){
//            A[i] = sc.nextInt();
//        }

        int mink = quickSort(A, 0, A.length - 1,3);
        System.out.println("mink:"+mink);
    }
}