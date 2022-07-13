package com.learn.q14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Question14 {


    public static void main(String[] args) {
        final String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        final String[] secStrs = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(secStrs));
        final String[] thirdStrs = new String[]{""};
        System.out.println(longestCommonPrefix(thirdStrs));
        final String[] fourthStrs = new String[]{"a"};
        System.out.println(longestCommonPrefix(fourthStrs));
        final String[] sixthStrs = new String[]{"flower", "flower", "flower", "flower"};
        System.out.println(longestCommonPrefix(sixthStrs));

        final String[] seventhStrs = new String[]{"a", "b"};
        System.out.println("seventhStrs :" + longestCommonPrefix(seventhStrs));

        final String[] eighthtrs = new String[]{"c", "acc", "ccc"};
        System.out.println("eighthtrs :" + longestCommonPrefix(eighthtrs));
    }


    public static String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        return same(strs, s.length());
    }

    private static String same(String[] strs, int sub) {
        if (sub == 0) {
            return "";
        }
        String sameWord = strs[0].substring(0, sub);
        boolean success = Arrays.stream(strs).allMatch(e -> e.startsWith(sameWord));
        return success ? sameWord : same(strs, sub - 1);
    }


    public static String answer(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
