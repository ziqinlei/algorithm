package com.ziqinlei.algorithm.search;

/**
 * 二分查找
 * 前提:有序数组
 *
 * @author Leiziqin
 * @since 2019/4/7
 */
public class BinarySearch {
    /**
     * 二分查找
     *
     * @param a   有序数组
     * @param key 目标元素
     * @return 目标元素所在坐标
     */
    public static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < key) {
                lo = mid + 1;
            } else if (a[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 23, 24, 26, 37, 38, 49, 59, 99, 100};
        int key = 1;
        int index = binarySearch(a, key);
        System.out.println("the index of " + key + " is: " + index);
        key = 98;
        index = binarySearch(a, key);
        System.out.println("the index of " + key + " is: " + index);
    }
}
