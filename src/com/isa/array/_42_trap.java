package com.isa.array;

public class _42_trap {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;
        int lowerHeightMax = 0, water = 0;

        // 双指针 - while
        while (left < right) {
            int lowerHeight = (height[left] <= height[right]) ? height[left++] : height[right--];
            lowerHeightMax = Math.max(lowerHeight, lowerHeightMax);
            water += lowerHeightMax - lowerHeight;
        }

        return water;
    }
}
