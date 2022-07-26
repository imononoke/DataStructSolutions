package com.isa.number;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）
 */
public class _50_myPow {

    // i.e., n = 9 (0x1001)

    public double myPow(double x, int n) {
        boolean isNeg = n < 0;
        // tips：-23^1 <= n <= 23^1 - 1, 指数如果是负数，需要把指数转换成 long 类型
        long pow = isNeg ? (- (long) n ) : n;

        double ret = 1.0;

        while (pow > 0) {
            if ((pow & 1) == 1) { // 任何数 & 1 能得到此数最后一位是 1 还是 0
                ret *= x;
            }

            x *= x;
            pow >>= 1; // n 减一半
        }
        return isNeg ? (1 / ret) : ret;
    }
}
