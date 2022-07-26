package com.isa.dp;

public class _0811_waysToChange {
    public static void main(String[] args) {
        int ret = waysToChange(10);
        System.out.println(ret);
    }

    public static int waysToChange(int n) {
        if (n == 0) return 0;

        int[] faces = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1; // 能被一个硬币表示的情况为 1 // i - face == 0

//        for (int i = 1; i <= n; i++) {
//            for (int face: faces) {
//                if (i < face)
//                    continue;
////                System.out.println("dp[" + i + "] += dp[" + (i - face) + "]");
//                dp[i] = dp[i] + dp[i - face]; // 有重复计算
//                System.out.println(dp[i]);
//            }
//        }

        for (int face: faces) {
            for (int i = face; i <= n; i++) {
                System.out.println("dp[" + i + "] += dp[" + (i - face) + "]");
                dp[i] = dp[i] + dp[i - face];
                System.out.println(dp[i]);
            }
        }
        return dp[n];
    }
}
