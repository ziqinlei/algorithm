package com.ziqinlei.algorithm.sort;

/**
 * 三项切分的快速排序
 *
 * @author Leiziqin
 * @since 2019/5/3
 */
public class Sort_007_Quick3way {
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        int v = a[lo];
        while (i <= gt) {
            if (a[i] < v) {
                swap(a, lt++, i++);
            } else if (a[i] > v) {
                swap(a, gt--, i);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
