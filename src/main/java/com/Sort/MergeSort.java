package com.Sort;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;

/**
 * @author: huangbin
 * @description: 归并排序
 * @date: Created in 2019/3/24
 * @modified By:
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {11, 5, 23, 8, 2, 7, 4, 9, 13, 12};

        System.out.println(CollectionUtils.arrayToList(merge(array)));

    }

    public static int[] merge(int[] arr) {
        if (arr.length < 2) {return arr;}
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return mergeSub(merge(left), merge(right));
    }

    public static int[] mergeSub(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        for (int i = 0, l = 0, r = 0; i < arr.length; i++) {
            if (r >= right.length) {
                arr[i] = left[l];
                l++;
            } else if (l >= left.length) {
                arr[i] = right[r];
                r++;
            } else if (left[l] > right[r]) {
                arr[i] = right[r];
                r++;
            } else {
                arr[i] = left[l];
                l++;

            }
        }
        return arr;

    }
}
