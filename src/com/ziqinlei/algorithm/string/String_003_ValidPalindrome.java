package com.ziqinlei.algorithm.string;

/**
 * Valid Palindrome - Leetcode 125
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * Input: "race a car"
 * Output: false
 *
 * @author Leiziqin
 * @since 2019/4/7
 */
public class String_003_ValidPalindrome {
    /**
     * 判断字符串是否为回文串
     *
     * @param s 目标字符串
     * @return 是否为回文串
     */
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (!Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
            } else if (!Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
            } else {
                if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi))) {
                    return false;
                }
                lo++;
                hi--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
