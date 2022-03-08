package com.example.springdemo.com.test;

import java.util.Arrays;
import java.util.Random;

public class SortNum {
    public static void main(String[] args) {
        int len = 1;
            int[] arr = new int[10];
            Random r = new Random();
            //初始化10个数的值
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextInt(10*arr.length) + 1; //得到10个100以内的整数
            }
            long start,end;
//            start = System.currentTimeMillis();
//            sortNum(arr);
//            end = System.currentTimeMillis();
//            System.out.println("工具类排序消耗时间："+(end-start));
            start = System.currentTimeMillis();
            sortBuble(arr);
            end = System.currentTimeMillis();
            System.out.println("冒泡排序消耗时间："+(end-start));
            start = System.currentTimeMillis();
            sortByble2(arr);
            end = System.currentTimeMillis();
            System.out.println("冒泡排序(改进)消耗时间："+(end-start));


    }

    public static void sortNum(int arr[]){
        Arrays.sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+"\t");
//        }
//        System.out.println("");
    }

    public  static  void sortBuble(int arr[]){
        //升序
        for (int i = 0; i < arr.length; i++) {
            if(i==4){
                break;
            }
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp =  arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println("");
        /*
        *     工具类排序消耗时间：280
        *     冒泡排序消耗时间：266338
        * */

    }
    public static void sortByble2(int arr[]){
        //冒泡改进   升序
        for (int i = 0; i < arr.length; i++) {
            if(i==4){
                break;
            }
            for (int k = i+1; k < arr.length; k++) {
                if(arr[i]>arr[k]){
                    int temp = arr[i];
                    arr[i]=arr[k];
                    arr[k]=temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println("");

    }
}
/*
*   改进：
*  2   1
*  3    3
*  4    6
*  5    1+2+3+4+5+6+7  n(n-1)/2
* 冒泡：
*
*
* */