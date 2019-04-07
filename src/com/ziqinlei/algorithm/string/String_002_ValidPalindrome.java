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
public class String_002_ValidPalindrome {
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
        int left = 0;
        int right = s.length() - 1;
        char cLeft;
        char cRight;
        while (left < right) {
            cLeft = s.charAt(left);
            cRight = s.charAt(right);
            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
            } else if (!Character.isLetterOrDigit(cRight)) {
                right--;
            } else {
                if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                    return false;
                }
                left++;
                right--;
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
