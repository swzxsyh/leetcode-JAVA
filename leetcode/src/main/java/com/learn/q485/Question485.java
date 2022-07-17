package com.learn.q485;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 */
public class Question485 {

    public static void main(String[] args) {
        final int[] array1 = new int[]{1, 1, 0, 1, 1, 1};
        final int[] array2 = new int[]{1, 0, 1, 1, 0, 1};

        System.out.println(findMaxConsecutiveOnes(array1));
        System.out.println(findMaxConsecutiveOnes(array2));
    }


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了87.30%的用户
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int num : nums) {
            if (num != 1) {
                count = 0;
                continue;
            }
            count++;
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
