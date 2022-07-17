package com.learn.q27;

import java.util.Arrays;

/**
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question27 {

    public static void main(String[] args) {
        int[] array1 = new int[]{3, 2, 2, 3};
        int val1 = 3;
        System.out.println(removeElement(array1, val1));

        int[] array2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        System.out.println(removeElement(array2, val2));
    }

    public static int removeElement(int[] nums, int val) {
        //TODO
        return 0;
    }
}
