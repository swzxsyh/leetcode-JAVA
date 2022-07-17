package com.learn.q219;

/**
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question219 {

    public static void main(String[] args) {
        final int[] array1 = new int[]{1, 2, 3, 1};
        final int k1 = 3;
        final int[] array2 = new int[]{1, 0, 1, 1};
        final int k2 = 1;
        final int[] array3 = new int[]{1, 2, 3, 1, 2, 3};
        final int k3 = 2;

        System.out.println(containsNearbyDuplicate(array1, k1));
        System.out.println(containsNearbyDuplicate(array2, k2));
        System.out.println(containsNearbyDuplicate(array3, k3));
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //TODO
        return false;
    }

}
