package com.Sort;

import org.springframework.util.CollectionUtils;

import java.util.Collections;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */
public class Sort {


    public static void main(String[] args) {
        int[] arrs = {1, 6, 2, 7, 7, 3, 4, 1, 9};
        quickSort(arrs, 0, arrs.length - 1);
        //                insertSort(arrs);
        //        chooseSort(arrs);
        System.out.println(CollectionUtils.arrayToList(arrs));
    }


    public static void quickSort(int[] arrs, int l, int r) {
        if (l < r) {
            int m = quickSubSort(arrs, l, r);
            quickSort(arrs, l, m - 1);
            quickSort(arrs, m + 1, r);
        }

    }


    private static int quickSubSort(int[] arrs, int l, int r) {

        int key = arrs[l];

        while (l < r) {
            while (l < r && key <= arrs[r]) {
                r--;
            }
            arrs[l] = arrs[r];
            while (l < r && key >= arrs[l]) {
                l++;
            }
            arrs[r] = arrs[l];
        }
        arrs[l] = key;
        return l;
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void chooseSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int key = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[key] > arr[j]) {
                    key = j;
                }
            }
            if (i != key) {
                int temp = arr[key];
                arr[key] = arr[i];
                arr[i] = temp;
            }
        }
    }


}
