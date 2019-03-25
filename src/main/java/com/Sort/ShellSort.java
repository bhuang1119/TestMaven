package com.Sort;

import org.springframework.util.CollectionUtils;

/**
 * @author: huangbin
 * @description:
 * @date: Created in 2019/3/22
 * @modified By:
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {11,5,23,8,2,7,4,9,13,12};
        sort(array);
        System.out.println(CollectionUtils.arrayToList(array));
    }

    public static void sort(int[] arrays) {
        int gap = arrays.length / 2;
        int key;
        while (gap > 0) {
            for (int i = gap; i < arrays.length; i++) {
                key = arrays[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arrays[preIndex] > key) {
                    arrays[preIndex + gap] = arrays[preIndex];
                    preIndex = preIndex - gap;
                }
                arrays[preIndex + gap] = key;
            }
            gap = gap / 2;
        }

    }
}
