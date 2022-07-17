package com.learn.q344;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question344 {

    public static void main(String[] args) {
        final char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        final char[] s1 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        final char[] s2 = new char[]{'a', '.'};

        reverseString(s);
        System.out.println(s);
        reverseString(s1);
        System.out.println(s1);

        reverseString(s2);
        System.out.println(s2);

    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：47.8 MB, 在所有 Java 提交中击败了88.03%的用户
     * @param s
     */
    public static void reverseString(char[] s) {
        int current = 0;

        for (int i = s.length - 1; i >= 0; i--) {
            if (current != 0 &&  current > i) {
                break;
            }
            char last = s[i];
            char first = s[current];
            s[i] = first;
            s[current] = last;
            current++;
        }
    }
}
