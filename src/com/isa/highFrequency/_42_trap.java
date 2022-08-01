package com.isa.highFrequency;

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class _42_trap {

    public int trap(int[] height) {
        if (height == null) return 0;
        int water = 0;

        // 能接水，说明当前位置高度 < 左右柱子高度，water 取决于较小的高度
        // solution1: 遍历求出每个位置的左右柱子高度的较小者, water += diff

        // solution2: 不用知道当前位置的左右柱子的最大高度， 当前柱子能放的 water = lowerMax - lower

        int lower = 0, lowerMax = 0;
        int left = 0, right = height.length - 1;

        for (int i = 0; i < height.length - 1; i++) {
            int lowerIdx = height[left] < height[right] ? left++ : right--; // 较低柱子的index
            lower = height[lowerIdx]; // height of the lower one
            lowerMax = Math.max(lowerMax, lower); // the max of lower heights
            water += lowerMax - lower;
        }

        return water;
    }
}
