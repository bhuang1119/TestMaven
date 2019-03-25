package com.Sort;

import org.springframework.util.CollectionUtils;

/**
 * @author: huangbin
 * @description:
 * @date: Created in 2019/3/24
 * @modified By:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {11, 5, 23, 8, 2, 7, 4, 9, 13, 12};

        sort(0, array.length - 1, array);

        System.out.println(CollectionUtils.arrayToList(array));
    }

    public static void sort(int l, int r, int[] arr) {
        if (l < r) {
            int mid = sortSub(l, r, arr);
            sort(l, mid - 1, arr);
            sort(mid + 1, r, arr);
        }
    }

    public static int sortSub(int l, int r, int[] arr) {

        int key = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= key) {r--;}
            arr[l] = arr[r];
            while (l < r && arr[l] <= key) {l++;}
            arr[r] = arr[l];
        }
        arr[l] = key;
        return l;
    }


}
