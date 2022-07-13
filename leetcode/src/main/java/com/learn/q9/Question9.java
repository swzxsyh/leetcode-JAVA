package com.learn.q9;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question9 {

    public static void main(String[] args) {
        final int x = 121;
        System.out.println(isPalindrome(x));
        final int y = 1234567899;
        System.out.println(isPalindrome(y));
        System.out.println(answer(x));
        System.out.println(answer(y));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return Boolean.FALSE;
        }
        String num = String.valueOf(x);
        StringBuilder sb = new StringBuilder(num);
        return sb.reverse().toString().equals(num);
    }

    private static boolean answer(int x) {
        if (x < 0) {
            return false;
        }
        int rem = 0, y = 0;
        int quo = x;
        while (quo != 0) {
            rem = quo % 10;
            y = y * 10 + rem;
            quo = quo / 10;
        }
        return y == x;
    }

}
