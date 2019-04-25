package com.Sort;

import org.springframework.util.CollectionUtils;

/**
 * @author: huangbin
 * @description: 冒泡排序
 * @date: Created in 2019/3/24
 * @modified By:
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] array = {11, 5, 23, 8, 2, 7, 4, 9, 13, 12};

        sort(array);

        System.out.println(CollectionUtils.arrayToList(array));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
}
