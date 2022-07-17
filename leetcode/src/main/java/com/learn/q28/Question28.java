package com.learn.q28;

/**
 * 实现strStr()函数。
 * <p>
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 * <p>
 * 说明：
 * <p>
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question28 {

    public static void main(String[] args) {

        String haystack = "hello", needle = "ll";
        String haystack1 = "aaaaa", needle1 = "bba";
        String haystack2 = "a", needle2 = "a";
        String haystack3 = "abc", needle3 = "c";


        System.out.println(strStr(haystack, needle));
        System.out.println(strStr(haystack1, needle1));
        System.out.println(strStr(haystack2, needle2));
        System.out.println(strStr(haystack3, needle3));

        System.out.println();

        System.out.println(answer(haystack, needle));
        System.out.println(answer(haystack1, needle1));
        System.out.println(answer(haystack2, needle2));
        System.out.println(answer(haystack3, needle3));
    }


    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了39.30%的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了5.05%的用户
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        int needleLength = needle.length();
        char[] chars = haystack.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i + needleLength <= chars.length) {
                int current = i + needleLength;
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < current; j++) {
                    sb.append(chars[j]);
                }
                if (sb.toString().equals(needle)) {
                    return i;
                }
            }

        }
        return -1;
    }

    /**
     * KMP
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int answer(String haystack, String needle) {
        int[] next = getNext(needle);
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();

        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (hay[i] == nee[j]) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * 获得next数组
     */
    public static int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        char[] chars = needle.toCharArray();
        int j = 0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }
            if (chars[i] == chars[j]) {
                next[i] = ++j;
            }
        }
        return next;
    }
}
