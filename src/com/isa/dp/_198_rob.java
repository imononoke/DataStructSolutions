package com.isa.dp;

public class _198_rob {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 6, 9};
        int res = rob(nums);
        System.out.println(res);
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0; // 没有拿任何一号
        dp[1] = nums[0]; // 第一号

        // dp[i]: 第i号能得到的 max value
        for (int i = 1; i < nums.length; i++) {
            // dp[i + 1] = dp[i] // 不能拿相邻的号
            // or dp[i + 1] = dp[i - 1] + nums[i] // 相隔一个号 -> 第i - 1号的值 + 当前号的值
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }
}
