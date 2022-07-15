package com.learn.q434;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 */
public class Question434 {

    public static void main(String[] args) {
        final String str = "Hello, my name is John";
        System.out.println(countSegments(str));
        System.out.println(countSegments2(str));

        String str2 = "";
        System.out.println(countSegments(str2));
        System.out.println(countSegments2(str2));


        String str3 = ", , , ,        a, eaefa";
        System.out.println(countSegments(str3));
        System.out.println(countSegments2(str3));

        String str4 = "                ";
        System.out.println(countSegments(str4));
        System.out.println(countSegments2(str4));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了60.23%的用户
     *
     * @param s
     * @return
     */
    public static int countSegments(String s) {
        String trim = s.trim();
        char[] strChars = trim.toCharArray();

        int count = 0;
        for (int i = 0; i < strChars.length; i++) {
            if (strChars[i] != ' ' && i != 0 && strChars[i - 1] == ' ') {
                count++;
            }
        }
        return trim.isEmpty() ? count : count + 1;
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.1 MB, 在所有 Java 提交中击败了57.89%的用户
     * @param s
     * @return
     */
    public static int countSegments2(String s) {
        String[] str = s.split(" ");
        int count = 0;
        for (String s1 : str) {
            if (!s1.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
