package com.isa.highFrequency;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 *
 * 给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
public class _11_maxArea {

    public int maxArea(int[] height) {
        if (height == null) return 0;

        int max = 0;
        int area = 0;
        int left = 0, right = height.length - 1;
        // area = height(min one) * (i2 - i1)
        // 使用双指针，向中间靠近
        while (left < right) {
            // h 是较小的 height，较小的一端要向中间移动，大的不动
            area = Math.min(height[left], height[right]) * (right - left);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
            max = Math.max(max, area);
        }

        return max;
    }
}
