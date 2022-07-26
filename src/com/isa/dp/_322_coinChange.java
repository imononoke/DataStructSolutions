package com.isa.dp;

public class _322_coinChange {
    public static void main(String[] args) {
        int[] faces = new int[] {1, 5, 20, 25};
        int n = 11;
        int ret = coin4(n, faces);
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null ||  coins.length == 0 || amount < 1)
            return 0;

        return coins(coins, amount);
    }

    static int coin4(int n, int[] faces) {
        if (n < 1 || faces == null || faces.length == 0) return -1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = dp[i - 1];
            for (int face: faces) {
                if (i >= face)
                    min = Math.min(dp[i - face], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    static int coins5(int n, int[] faces) {
        if (n < 1 || faces == null || faces.length == 0) return -1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) { // 从1到n 每个值的凑法
            int min = Integer.MAX_VALUE;
            for (int face : faces) { // 带入各个面值，看选谁min最小
                if (i < face) continue; // 要凑的数比当前面值还小，没法凑
                int v = dp[i - face]; // 先选该面值，剩下的是dp[i - face]；
                if (v < 0 || v >= min) continue; // 如剩下的dp[i - face]凑法 < 0，没法凑，如果剩下的dp[i - face]不是最小值，也不用更新最小值
                min = v;
            }
            if (min == Integer.MAX_VALUE) { // 如果没法凑
                dp[i] = -1;
            } else {
                dp[i] = min + 1; // 已选择当前面值，所以数量先+1， 剩下面值所需要的面值，例：dp(41 - 5) = dp(36) = 凑够36需要的最少硬币数量
            }
        }
        return dp[n];
    }

    public int coins(int[] coins, int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;

        // dp[i]: 凑金额 i 所用的最少硬币个数
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int coin: coins) {
                if (i < coin) {
                    // dp[i] = -1;
                    continue;
                }
                if (dp[i - coin] < min) {
                    min = dp[i - coin] + 1; // 1: 本身这枚coin
                }
                dp[i] = min;
                System.out.println("dp[" + i + "]: " + dp[i]);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
