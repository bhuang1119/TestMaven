package com.Sort;

import org.springframework.util.CollectionUtils;

/**
 * @author: huangbin
 * @description:
 * @date: Created in 2019/3/24
 * @modified By:
 */
public class SelectionSort {
    public static void main(String[] args) {

        int[] array = {11, 5, 23, 8, 2, 7, 4, 9, 13, 12};

        sort(array);

        System.out.println(CollectionUtils.arrayToList(array));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {min = j;}
            }
            if(min!=i){
                int temp = arr[min];
                arr[min] =arr[i];
                arr[i] = temp;
            }
        }
    }
}
