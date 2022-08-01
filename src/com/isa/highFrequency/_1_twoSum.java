package com.isa.highFrequency;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/two-sum/
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 */
public class _1_twoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 4, 6, 9};
        int[] ret = twoSum(nums, 8);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            // Integer index = map.get(target - nums[i]); // the same result
            // if (index != null) return new int[] {index, i};

            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
