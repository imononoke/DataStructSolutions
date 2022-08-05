package com.isa.dp;

/**
 * https://leetcode.cn/problems/unique-paths/
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class _62_uniquePaths {

    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示走到（i，j）位置的路径数
        int[][] dp = new int[m][n];

        // 沿着第0行 or 第0列，到右下角，都各只有一种走法
        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }
        for (int col = 0; col < n; col++) {
            dp[0][col] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 走到每个位置（i，j）的走法 = 走到左边pos 和上面pos 走法之和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
