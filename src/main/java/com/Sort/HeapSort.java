package com.Sort;

import org.springframework.util.CollectionUtils;

/**
 * @author: huangbin
 * @description:
 * @date: Created in 2019/3/24
 * @modified By:
 */
public class HeapSort {
    private static int length;

    public static void main(String[] args) {
        int[] array = {11, 5, 23, 8, 2, 7, 4, 9, 13, 12};
        sort(array);
        System.out.println(CollectionUtils.arrayToList(array));

    }

    public static void sort(int[] arr) {
        length = arr.length;
        buildMaxHeap(arr);
        while (length > 0) {
            swap(arr, 0, length - 1);
            length--;
            adjustHeap(arr, 0);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        for (int i = (length - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i);
        }
    }

    public static void adjustHeap(int[] arr, int i) {
        int maxIndex = i;
        if (i * 2 + 1 < length && arr[maxIndex] < arr[i * 2 + 1]) {
            maxIndex = i * 2 + 1;
        }
        if (i * 2 + 2 < length && arr[i * 2 + 2] > arr[maxIndex]) {
            maxIndex = i * 2 + 2;
        }
        if (i != maxIndex) {
            swap(arr, maxIndex, i);
            adjustHeap(arr, maxIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
