package com.learn.q884;

import java.util.*;

/**
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * <p>
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * <p>
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/uncommon-words-from-two-sentences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question884 {

    public static void main(String[] args) {
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));

        String s3 = "apple apple", s4 = "banana";
        System.out.println(Arrays.toString(uncommonFromSentences(s3, s4)));

        String s5 = "s z z z s", s6 = "s z ejt";
        System.out.println(Arrays.toString(uncommonFromSentences(s5, s6)));
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了98.28%的用户
     * 内存消耗：40 MB, 在所有 Java 提交中击败了66.54%的用户
     * <p>
     * 字符串拼接会比两个数组扔进循环方法更慢
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");

        Map<String, Integer> hashMap = new HashMap<>(str1.length + str2.length);

        delDuplicate(hashMap, str1);
        delDuplicate(hashMap, str2);

        Set<String> hashSet = new HashSet<>();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                hashSet.add(entry.getKey());
            }
        }

        return hashSet.toArray(new String[0]);
    }

    private static void delDuplicate(Map<String, Integer> hashMap, String[] str) {
        for (String s : str) {
            Integer count = hashMap.get(s);
            count = Objects.isNull(count) ? 1 : count + 1;
            hashMap.put(s, count);
        }
    }
}
