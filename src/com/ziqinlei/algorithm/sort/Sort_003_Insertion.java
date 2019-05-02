package com.ziqinlei.algorithm.sort;

/**
 * 插入排序
 *
 * @author Leiziqin
 * @since 2019/5/2
 */
public class Sort_003_Insertion {
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j] > a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
