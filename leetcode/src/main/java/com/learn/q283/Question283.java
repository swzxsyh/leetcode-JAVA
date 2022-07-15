package com.learn.q283;

import java.util.*;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Question283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{0};
        int[] nums3 = new int[]{0, 1, 0};
        int[] nums4 = new int[]{0, 0, 1};

        answer(nums);
        answer(nums2);
        answer(nums3);
        answer(nums4);
    }

    public static void moveZeroes(int[] nums) {
        //TODO
        System.out.println(Arrays.toString(nums));
    }


    private static void answer(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

}
