package com.learn.q844;

import java.util.Stack;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question844 {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        String s1 = "ab##", t1 = "c#d#";
        String s2 = "a#c", t2 = "b";
        String s3 = "a##c", t3 = "#a#c";
        String s4 = "ab##", t4 = "c#d#";

        System.out.println(backspaceCompare(s, t));
        System.out.println(backspaceCompare(s1, t1));
        System.out.println(backspaceCompare(s2, t2));
        System.out.println(backspaceCompare(s3, t3));
        System.out.println(backspaceCompare(s4, t4));

    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了21.39%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了73.69%的用户
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompare(String s, String t) {
        return buildStack(s).equals(buildStack(t));
    }

    private static Stack<Character> buildStack(String t) {
        Stack<Character> stackTarget = new Stack<>();
        char[] target = t.toCharArray();

        for (int i = 0; i < target.length; i++) {
            if (target[i] != '#') {
                stackTarget.push(target[i]);
            }
            if (target[i] == '#' && i == 0) {
                continue;
            }
            if (target[i] == '#' && !stackTarget.isEmpty()) {
                stackTarget.pop();
            }
        }
        return stackTarget;
    }

    public static boolean answer(String s, String t) {
        int cur1 = s.length();
        int cur2 = t.length();
        while (true) {
            cur1 = findCur(s, cur1);
            cur2 = findCur(t, cur2);
            if (cur1 < 0 || cur2 < 0) {
                break;
            }
            // 某个比较字符不相等，返回false
            if (s.charAt(cur1) != t.charAt(cur2)) {
                return false;
            }
        }
        // 最后下标都是 -1 则字符串相等且比较元素都相当，返回true
        return cur1 == cur2;
    }

    // 从后向前，寻找消除退格符后的元素下标
    public static int findCur(String s, int cur) {
        if (cur < 0) {
            return cur;
        }
        int count = 1;
        while (0 < count) {
            cur -= 1;
            // 若退格到-1，则结束
            if (cur < 0) {
                break;
            }
            if (s.charAt(cur) == '#') {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return cur;
    }
}
