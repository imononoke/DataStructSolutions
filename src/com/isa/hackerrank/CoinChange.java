package com.isa.hackerrank;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/coin-change/problem?isFullScreen=true
 */
public class CoinChange {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {
        // Write your code here
        int len = c.size();
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=0;i<len;i++) {
            int key = c.get(i).intValue();
            for(int j= key; j<=n; j++)
                dp[j] += dp[j- key];
        }

        return dp[n];
    }
}
