package com.ziqinlei.algorithm.string;

/**
 * 字符串反转
 * Example:
 * Input: "hello world"
 * Output: "dlrow olleh"
 *
 * @author Leiziqin
 * @since 2019/4/7
 */
public class String_001_ReverseString {
    /**
     * 方式一：从尾到头拼接
     *
     * @param s 字符串
     * @return 反转后的字符串
     */
    public static String reverseString1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    /**
     * 方式二：利用StringBuilder的reverse方法
     *
     * @param s 字符串
     * @return 反转后的字符串
     */
    public static String reverseString2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "hello world";
        System.out.println(reverseString1(s));
        System.out.println(reverseString2(s));
    }
}
