package com.isa.highFrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 * 一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 */
public class _15_threeSum {

    // 思路：计算两数之和，找到第三个数和这个sum 之和为 0
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        // sort first, so the smallest item is at the begin while the biggest is at the end.
        Arrays.sort(nums);

        // 用到首尾两个指针
        // let nums[i] as the first number of array
        for (int i = 0; i <= nums.length - 3; i++) {
            // i - remove duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue; // ie, [-1, 0, 0, 1, 3, 4]

            int left = i + 1;
            int right = nums.length - 1; // the last one

            // compare the sum of nums[left] and nums[right] with the remain value
            // int sum = nums[left] + nums[right];
            int remain = -nums[i]; // 如果sum < remain，则left 右移；sum > remain，则right 左移。

            while (left < right) {
                int sum = nums[left] + nums[right]; // 应该在while 里计算 sum
                if (sum == remain) { // 找到三数和为 0 的组合
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // skip the same left and right index
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++; // find the next
                    right--;
                } else if (sum < remain) {
                    left++;
                } else { // sum > remain
                    right--;
                }
            }
        }
        return result;
    }
}
