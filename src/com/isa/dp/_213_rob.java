package com.isa.dp;

// 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
// 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

public class _213_rob {
    public static void main(String[] args) {
        int[] nums = new int[] {1};
        int res = rob(nums);
        System.out.println(res);
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int length = nums.length;
        dp[0] = 0;

        // 因为首尾相邻，如果 nums 是奇数，则不能先拿第1号，要从第2号开始；如果是偶数，则可以。
        // start from index 0
        dp[1] = nums[0];
        for (int i = 1; i < length - 1; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        int max = length <= 1 ? dp[length] : dp[length - 1];

        // start from index 1
//        dp[0] = 0; // reset
        dp[1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        return Math.max(max, dp[length]);
    }
}
