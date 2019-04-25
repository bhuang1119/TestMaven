package com.Sort;

import org.springframework.util.CollectionUtils;

/**
 * @author: huangbin
 * @description: 插入排序
 * @date: Created in 2019/3/24
 * @modified By:
 */
public class InsertionSort {
    public static void main(String[] args) {

        int[] array = {11, 5, 23, 8, 2, 7, 4, 9, 13, 12};

        sort(array);

        System.out.println(CollectionUtils.arrayToList(array));
    }

    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int index = i-1;
            while(index>=0&&key<arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1]=key;
        }
    }
}
