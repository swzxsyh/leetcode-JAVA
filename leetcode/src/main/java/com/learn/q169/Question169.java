package com.learn.q169;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class Question169 {

    public static void main(String[] args) {

        int[] arrayOne = {3, 2, 3};
        System.out.println(majorityElement(arrayOne));
        int[] arrayTwo = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arrayTwo));
        int[] arrayThree = {6, 5, 5};
        System.out.println(majorityElement(arrayThree));
        int[] arrayFour = {8, 8, 7, 7, 7};
        System.out.println(majorityElement(arrayFour));
    }

    /**
     * 执行用时：
     * 2039 ms
     * , 在所有 Java 提交中击败了
     * 6.78%
     * 的用户
     * 内存消耗：
     * 44.7 MB
     * , 在所有 Java 提交中击败了
     * 77.33%
     * 的用户
     * 通过测试用例：
     * 43 / 43
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int multiCount = nums.length % 2 == 1 ? nums.length / 2 + 1 : nums.length / 2;

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            for (int i1 = 0; i1 < nums.length; i1++) {
                if (num == nums[i1]) {
                    temp++;
                }
            }
            if (temp >= multiCount) {
                temp = num;
                break;
            }
            temp = 0;
        }
        return temp;
    }

    /**
     * 执行用时：
     * 16 ms
     * , 在所有 Java 提交中击败了
     * 8.90%
     * 的用户
     * 内存消耗：
     * 47 MB
     * , 在所有 Java 提交中击败了
     * 5.00%
     * 的用户
     * 通过测试用例：
     * 43 / 43
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);


        for (int num : nums) {
            Integer value = hashMap.get(num);
            if (Objects.isNull(value)) {
                hashMap.put(num, 1);
            }
            hashMap.put(num, hashMap.get(num) + 1);
        }
        Integer key = null;
        Integer value = hashMap.values().stream().max(Integer::compare).get();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue().equals(value)) {
                key = entry.getKey();
                break;
            }
        }
        return key;
    }

    public static int answer(int[] nums) {
//摩尔投票法,先假设第一个数过半数并设cnt=1；遍历后面的数如果相同则cnt+1，不同则减一，当cnt为0时则更换新的数字为候选数（成立前提：有出现次数大于n/2的数存在）
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }
}
