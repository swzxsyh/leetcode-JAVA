package com.learn.q35;

import java.util.Objects;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        final int target = 0;
        int result = searchInsert(nums, target);

        System.out.println("result: " + result);
    }

    public static int searchInsert(int[] nums, int target) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                ret = i == 0 ? 0 : i - 1;
                break;
            }
            if (nums[i] == target) {
                ret = i;
                break;
            }
            if (nums[i] < target && (i + 1 < nums.length) && nums[i + 1] > target) {
                ret = i + 1;
                break;
            }
            if (i == nums.length - 1 && target > nums[i]) {
                ret = i + 1;
                break;
            }
        }
        return ret;
    }

    private int answer(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // 分别处理如下三种情况
            // 目标值在数组所有元素之前
            // 目标值等于数组中某一个元素
            // 目标值插入数组中的位置
            // 一旦发现大于或者等于target的num[i]，那么i就是我们要的结果
            if (nums[i] >= target) {
                return i;
            }
        }
        // 目标值在数组所有元素之后的情况
        // 如果target是最大的，或者 nums为空，则返回nums的长度
        return nums.length;
    }
}
