package com.isa.dp;

/**
 * https://leetcode.cn/problems/edit-distance/
 *
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class _72_minDistance {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int rows = chars1.length, cols = chars2.length;
        // dp[i][j]: s1(i,j) -> s2(i,j) 最少操作数
        int[][] dp = new int[rows + 1][cols + 1];

        dp[0][0] = 0; // "" -> ""

        // the 0 col, start from 1
        for (int row = 1; row <= rows; row++) {
            dp[row][0] = row;
        }

        // the 0 row
        for (int col = 1; col <=  cols; col++) {
            dp[0][col] = col;
        }

        // others
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int left = dp[i][j - 1] + 1;
                int top = dp[i - 1][j] + 1;
                int leftTop = dp[i - 1][j - 1]
                        + ((chars1[i - 1] != chars2[j - 1]) ? 1 : 0);
                dp[i][j] = Math.min(Math.min(left, top), leftTop);
            }
        }

        return dp[rows][cols];
    }
}
