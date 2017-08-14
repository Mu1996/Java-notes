package com.muyonghui.coding;/*
 * Created by muyonghui on 2017/8/12.
 */

import java.util.Scanner;

public class NN {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n;
        int d;
        int mm=0;
        int mm2=0;
        int max1=0;
        int max2=0;
        int max3=0;
        int max4=0;
        n= s.nextInt();
        d= s.nextInt();
        int[][] a1=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a1[i][j]=s.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=n-d;j++){
                for(int k=0;k<d;k++){
                    max1=max1+a1[i][j+k];//横向
                    max2=max2+a1[j+k][i];//纵向

                }
                if(max1>max2){
                    if(max1>mm){mm=max1;}
                }else if(max2>mm){
                    mm=max2;
                }

                max1=0;
                max2=0;
            }

        }
        for(int i=0;i<=n-d;i++){
            for(int j=0;j<=n-d;j++){
                for(int k=0;k<d;k++){
                    max3=max3+a1[i+k][j+k];//左上右下
                    max4=max4+a1[i+k][n-j-k-1];//右上左下

                }
                if(max3>max4){
                    if(max3>mm2){mm2=max3;}
                }else if(max4>mm2){mm2=max4;}

                max3=0;
                max4=0;
            }

        }
        if(mm>mm2){mm2=mm;}
        System.out.print(mm2);
    }




}
