package com.Sort;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;

/**
 * @author: huangbin
 * @description: 计数排序
 * @date: Created in 2019/4/7
 * @modified By:
 */
public class CountSort {
    public static void main(String[] args) {

        int[] array = {11, 5, 23, 8, 2, 7, 4, 9, 13, 12};

        sort(array);

        System.out.println(CollectionUtils.arrayToList(array));
    }

    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int basis = 0, max = 0, min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int[] arrNew = new int[max - min + 1];
        Arrays.fill(arrNew, 0);
        basis = min;
        for (int i = 0; i < arr.length; i++) {
            arrNew[arr[i] - basis]++;
        }
        int index = 0, i = 0;
        while (index < arr.length) {
            if (arrNew[i] != 0) {
                arr[index] = i + basis;
                arrNew[i]--;
                index++;
            } else {
                i++;
            }
        }
        return arr;
    }
}
