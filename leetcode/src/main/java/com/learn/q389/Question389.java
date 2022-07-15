package com.learn.q389;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 */
public class Question389 {

    public static void main(String[] args) {
        final String s = "abcd", t = "abcde";
        final String s1 = "", t1 = "y";
        final String s2 = "a", t2 = "aa";
        System.out.println(findTheDifference(s, t));
        System.out.println(findTheDifference(s1, t1));
        System.out.println(findTheDifference(s2, t2));
    }

    /**
     * 执行用时：33 ms, 在所有 Java 提交中击败了5.53%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了5.04%的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        for (char c : s.toCharArray()) {
            t = t.replaceFirst(c + "", "");
        }
        return t.charAt(0);
    }


    /**
     * java:将所给的字符串转换为字符数组，求字符数组的int和，作差，再转回char，返回
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.74%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了5.04%的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static char answer(String s, String t) {

        char[] target = t.toCharArray();
        int count = 0;
        for (char aChar : target) {
            count += aChar;
        }

        char[] source = s.toCharArray();
        for (char c : source) {
            count -= c;
        }

        return (char) count;
    }
}
