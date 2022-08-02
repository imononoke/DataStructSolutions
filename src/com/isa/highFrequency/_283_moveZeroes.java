package com.isa.highFrequency;

/**
 * https://leetcode.cn/problems/move-zeroes/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在不复制数组的情况下原地对数组进行操作. -- be attention to "原地"
  */
public class _283_moveZeroes {
    public static void main(String[] args) {
        int[] numbs = new int[] {0, 1, 0, 3, 5};
        moveZeroes(numbs);
    }

    // considering to use two pointers
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1)
            return;

        // scan the array from index 0 一个一个查找0
        for (int start = 0, pos = 0; start <= nums.length - 1; start++) {
            if (nums[start] == 0) { // nums[start++] == 0 is wrong
                continue;
            }
            System.out.println("pos: " + pos + ", start: " + start);
            // 找到非 0 元素, i.e, [0 0 0 1 3] start = 3,
            // switch [0] <-> [3] 需要记录第一个 0 的 index
            if (pos != start) { // 两个位置不相等 才需要交换！
                nums[pos] = nums[start]; // [pos] 赋值后，向后移动 [1 0 0 1 3]
                nums[start] = 0;
            }
            pos++;
            System.out.println("--- pos: " + pos + ", start: " + start);
        }
    }
}
