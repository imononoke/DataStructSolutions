package com.isa.dp;

public class _1143_longestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int ret = longestCommonSubsequence(text1, text2);
    }
    /**
     *
     * @param text1
     * @param text2
     * @return
     *      i  a  c
     *   j  0  0  0
     *   a  0  1  1
     *   b  0  1
     */

    public static int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int len1 = text1.length();
        int len2 = text2.length();
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        int max = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        // dp[i][j] - 第[i][j]位置，text1和text2 最长公共子序列的长度

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (char1[i - 1] == char2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }

    /**
     * dp 用一维数组实现
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int len1 = text1.length();
        int len2 = text2.length();
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        int[] dp = new int[len2 + 1];

        for (int i = 1; i <= len1; i++) {
            int curr = 0;
            for (int j  = 1; j <= len2; j++) {
                int leftTop = curr;
                curr = dp[j];
                if (char1[i - 1] == char2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[len2];
    }
}
