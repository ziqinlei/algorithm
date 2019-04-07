package com.ziqinlei.algorithm.string;

/**
 * 迭代去除指定字符串中的关键词
 * 如：给定一个字符串 "81818166666" 关键词为 "816" 期待结果为："66"
 *
 * @author Leiziqin
 * @since 2019/4/7
 */
public class String_002_RecursionRemoveKey {
    /**
     * 迭代去除指定字符串中的关键词
     *
     * @param source 指定字符串
     * @param key    关键词
     * @return 剩余的字符串
     */
    public static String recursionRemoveKey(String source, String key) {
        StringBuilder builder = new StringBuilder(source);
        int index = builder.indexOf(key);
        while (index >= 0) {
            builder.delete(index, index + key.length());
            index = builder.indexOf(key);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String source = "81818166666";
        String key = "816";
        String rest = recursionRemoveKey(source, key);
        System.out.println("rest is:" + rest);
        source = "aabaabcc";
        key = "abc";
        rest = recursionRemoveKey(source, key);
        System.out.println("rest is:" + rest);
    }
}
