package com.ziqinlei.algorithm.sort;

/**
 * 堆排序
 *
 * @author Leiziqin
 * @since 2019/5/3
 */
public class Sort_008_HeapSort {
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            heapInsert(a, i);
        }
        while (n > 1) {
            swap(a, 0, --n);
            heapify(a, 0, n);
        }
    }

    private static void heapInsert(int[] a, int i) {
        while (a[i] > a[(i - 1) / 2]) {
            swap(a, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private static void heapify(int[] a, int index, int n) {
        int left = index * 2 + 1;
        while (left < n) {
            int max = left + 1 < n && a[left + 1] > a[left] ? left + 1 : left;
            max = a[max] > a[index] ? max : index;
            if (max == index) {
                break;
            }
            swap(a, max, index);
            index = max;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
