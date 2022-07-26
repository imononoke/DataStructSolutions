package com.isa.dp;

public class _11_maxArea {

    // 给定一个长度为 n 的整数数组 height 。
    // 有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])
    // n == height.length
    // 2 <= n <= 10^5

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        maxArea(height);
    }

    public static int maxArea(int[] height) {
        int len = height.length; // tips: len >= 2
        // area = (j - i) * Math.min(height[j], height[i])
        int max = 0;

//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                dp[i][j] = Math
//                int area = (j - i) * Math.min(height[i], height[j]);
//                max = Math.max(max, area);
//            }
//        }

        int i = 0;
        int j = len - 1;

        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, area);

            if (height[i] < height[j]) {
                i++;
            } else j--;
        }
        return max;
    }
}
