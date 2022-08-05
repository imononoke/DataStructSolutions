package com.isa.dp;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class _121_maxProfit {
    public static void main(String[] args) {
        int[] prices = new int[] {1, 4, 2};
        int ret = maxProfit(prices);
    }

    public int maxProfit2(int[] prices) {
        if (prices == null) return 0;

        // diff array
        int[] diff = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }

        return getProfit(diff);
    }

    private int getProfit(int[] diff) {
        int max = 0;
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > 0) {
                max += diff[i];
            }
//            max = Math.max(max, diff[i]);
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int[] diff = new int[prices.length]; // calc the diff of each price of the next day
        for (int i = 0; i < prices.length - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
            System.out.println("diff[" + i + "]: " + diff[i]);
        }

        int idx = 0;

        // dp[i] 表示以 diff[i]结尾的最大连续子序列之和
//        int[] dp = new int[diff.length];
//        dp[0] = diff[0];
//        int max = dp[0];
//
//        for (int i = 1; i < diff.length; i++) {
//            idx = i;
//            if (dp[i - 1] > 0) {
//                dp[i] = dp[i - 1] + diff[i];
//            } else
//                dp[i] = diff[i];
//            max = Math.max(dp[i], max);
//        }

        // Optimize
        int dp = diff[0];
        int max = dp;
        for (int i = 1; i < diff.length; i++) {
            idx = i;
            if (dp > 0) {
                dp = dp + diff[i];
            } else dp = diff[i];

            max = Math.max(dp, max);
        }

        System.out.print("第" + idx + "天卖出, max: " + max);
        return max;
    }
}
