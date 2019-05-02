package com.ziqinlei.algorithm.sort;

/**
 * 冒泡排序
 *
 * @author Leiziqin
 * @since 2019/5/2
 */
public class Sort_001_Bubble {
    /**
     * 普通法
     *
     * @param a 待排序的数组
     */
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    /**
     * 改良法
     *
     * @param a 待排序数组
     */
    public static void sort2(int[] a) {
        int n = a.length;
        boolean changed;
        for (int i = 0; i < n - 1; i++) {
            changed = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    changed = true;
                }
            }
            if (!changed) {
                return;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
