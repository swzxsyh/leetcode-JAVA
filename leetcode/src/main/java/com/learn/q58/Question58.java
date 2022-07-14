package com.learn.q58;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question58 {


    public static void main(String[] args) {
        final String s1 = "Hello World";
        final String s2 = "   fly me   to   the moon  ";
        final String s3 = "luffy is still joyboy";
        final String s4 = "   fly me   to   the moon  ";

        System.out.println(lengthOfLastWord(s1));
        System.out.println(lengthOfLastWord(s2));
        System.out.println(lengthOfLastWord(s3));
        System.out.println(lengthOfLastWord(s4));
    }

    public static int lengthOfLastWord(String s) {
        String trim = s.trim();
        int i = trim.lastIndexOf(' ') + 1;
        return trim.substring(i).length();
    }

    public static int answer(String s) {
        String[] strs = s.split(" ");
        return strs[strs.length - 1].length();
    }
}
