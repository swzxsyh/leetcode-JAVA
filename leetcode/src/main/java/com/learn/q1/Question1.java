package com.learn.q1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author swzxsyh
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class Question1 {

    public static void main(String[] args) {
        final int[] nums = new int[]{3, 2, 4};
        final int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println("result: " + Arrays.toString(result));
        System.out.println("result answer: " + Arrays.toString(twoSumAnswer(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < nums.length; k++) {
                if (i != k && nums[i] + nums[k] == target) {
                    result[0] = i;
                    result[1] = k;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * array 不能直接根据数值获取下标，无法直接根据余数get
     * 官方答案
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumAnswer(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }

}
