package com.isa.dp;

/**
 * https://leetcode.cn/problems/minimum-path-sum/
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class _64_minPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int rows = grid.length;
        int cols = grid[0].length;

//        int[][] dp = new int[rows][cols];
//        dp[0][0] = grid[0][0];

        // reuse grid space, instead of creating new space
        // row 0
        for (int col = 1; col < cols; col++) {
            grid[0][col] = grid[0][col - 1] + grid[0][col];
        }

        for (int row = 1; row < rows; row++) {
            grid[row][0] = grid[row - 1][0] + grid[row][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[rows - 1][cols - 1];
    }
}
