package com.isa.dp;

/**
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，
 * 请计算你最多能拿到多少价值的礼物？
 */
public class _47_maxValue {

    public int maxValue(int[][] grid) {
        if (grid == null) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        int max = 0;

        dp[0][0] = grid[0][0];

        // the 0 row
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // the 0 col
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
