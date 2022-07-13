package com.learn.q13;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question13 {

    public static void main(String[] args) {
        final String s1 = "III";
        final String s2 = "IV";
        final String s3 = "IX";
        final String s4 = "LVIII";
        final String s5 = "MCMXCIV";
        System.out.println(romanToInt(s1));
        System.out.println(romanToInt(s2));
        System.out.println(romanToInt(s3));
        System.out.println(romanToInt(s4));
        System.out.println(romanToInt(s5));
        System.out.println("============");
        System.out.println(answer(s1));
        System.out.println(answer(s2));
        System.out.println(answer(s3));
        System.out.println(answer(s4));
        System.out.println(answer(s5));
    }

    public static int romanToInt(String s) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(13);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int total = 0;
        for (String key : map.keySet()) {
            int length = s.length();
            s = s.replaceAll(key, "");
            int newLength = s.length();
            int count = count(length, newLength, key, map.get(key));
            total += count;
        }

        return total;

    }

    private static int count(int length, int currentLength, String key, int value) {
        int countIX = (length - currentLength) / key.length();
        return countIX;
    }


    public static int answer(String s) {
        int num = 0;
        int flag = 0;
        int flag2 = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    flag = 1;
                    break;
                case 'V':
                    flag = 5;
                    break;
                case 'X':
                    flag = 10;
                    break;
                case 'L':
                    flag = 50;
                    break;
                case 'C':
                    flag = 100;
                    break;
                case 'D':
                    flag = 500;
                    break;
                case 'M':
                    flag = 1000;
            }
            if (i + 1 < s.length() && (flag2 - flag > 0) && ((flag2 - flag) % 4 == 0 || (flag2 - flag) % 9 == 0)) {
                num -= flag;
            } else {
                num += flag;
                flag2 = flag;
            }
        }
        return num;

    }
}
