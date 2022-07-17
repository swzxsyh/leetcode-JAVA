package com.learn.q217;

import java.util.HashSet;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
public class Question217 {

    public static void main(String[] args) {
        final int[] a = new int[]{1, 2, 3, 1};
        final int[] b = new int[]{1, 2, 3, 4};
        final int[] c = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate(a));
        System.out.println(containsDuplicate(b));
        System.out.println(containsDuplicate(c));

    }

    /**
     * 执行用时：14 ms, 在所有 Java 提交中击败了50.68%的用户
     * 内存消耗：53.3 MB, 在所有 Java 提交中击败了56.35%的用户
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }

        return hashSet.size() != nums.length;
    }
}
