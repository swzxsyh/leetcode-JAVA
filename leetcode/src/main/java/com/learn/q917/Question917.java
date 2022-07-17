package com.learn.q917;

import java.util.Objects;

/**
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * <p>
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 */
public class Question917 {


    public static void main(String[] args) {
        String s = "ab-cd";
        System.out.println(reverseOnlyLetters(s));

        String s1 = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s1));
    }


    public static String reverseOnlyLetters(String s) {
        //横杠位置不变
        //子母位置翻转且顺序翻转

        //TODO
        return null;
    }
}
