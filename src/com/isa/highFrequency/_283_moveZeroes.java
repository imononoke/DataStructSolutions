package com.isa.highFrequency;

/**
 * https://leetcode.cn/problems/move-zeroes/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在不复制数组的情况下原地对数组进行操作. -- be attention to "原地"
  */
public class _283_moveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 5};
        moveZeroes(nums);
    }

    // considering to use two pointers
    public static void moveZeroes(int[] nums) {
        int start = 0;
        int pos = start;

        // scan the array from index 0 一个一个查找0
        while (start <= nums.length - 1) {
            // 如果 left 是 0
            if (nums[start++] == 0)
                continue;

            // 找到非 0 元素, i.e, [0 0 0 1 3] start = 3, switch [0] <-> [3] 需要记录第一个 0 的 index
            nums[pos++] = nums[start]; // [pos] 赋值后，向后移动 [1 0 0 1 3], pos += 1
            nums[start++] = 0; // [1 0 0 0 3] start = 4
        }
    }
}
