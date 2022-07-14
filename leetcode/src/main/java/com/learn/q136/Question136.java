package com.learn.q136;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question136 {

    public static void main(String[] args) {
        int[] source = new int[]{2, 2, 1};
        int[] source2 = new int[]{4, 1, 2, 1, 2};

        System.out.println(singleNumber(source));
        System.out.println(singleNumber(source2));
    }

    /**
     * 执行用时：
     * 10 ms
     * , 在所有 Java 提交中击败了
     * 16.62%
     * 的用户
     * 内存消耗：
     * 41.8 MB
     * , 在所有 Java 提交中击败了
     * 13.62%
     * 的用户
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                set.remove(num);
                continue;
            }
            set.add(num);
        }
        return set.iterator().next();
    }

    public static int answer(int[] nums){
        int result = 0;;
        for(int x : nums){
            result ^= x;
        }
        return result;
    }
}
