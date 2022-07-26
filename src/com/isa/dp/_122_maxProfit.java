package com.isa.dp;

// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/

public class _122_maxProfit {
    public static void main(String[] args) {
        int[] prices = new int[] {7,6,4,3,1};
        int ret = maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        int[] diff = new int[prices.length]; // calc the diff of each price of the next day
        for (int i = 0; i < prices.length - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
            System.out.println("diff[" + i + "]: " + diff[i]);
        }

        int max = Math.max(diff[0], 0);
        for (int i = 1; i < diff.length; i++) {
            if (diff[i] > 0) {
                max += diff[i];
            }
        }

        System.out.print("max: " + max);
        return max;
    }
}
