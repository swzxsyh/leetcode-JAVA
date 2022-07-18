package com.learn.q509;

/**
 * 斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定n ，请计算 F(n) 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question509 {

    /**
     * 求这fib(x) 中x位置在数列中的值
     * 1,1,2,3,5,8,13,21,34
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(8));
    }

    /**
     * 执行用时：8 ms, 在所有 Java 提交中击败了22.55%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了39.27%的用户
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        //TODO
        return n < 2 ? n : fib(n - 2) + fib(n - 1);
    }


    public static int answer(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1, c;
        while (n-- > 1) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
