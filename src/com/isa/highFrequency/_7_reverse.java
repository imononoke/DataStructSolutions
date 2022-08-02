package com.isa.highFrequency;

/**
 * https://leetcode.cn/problems/reverse-integer/
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 */
public class _7_reverse {
    public static void main(String[] args) {
        int ret = reverse(123);
    }

    public static int reverse(int x) {
        // 注意溢出情况，按位计算，余数
        int ret = 0;

        while (x != 0) {
            int reminder = x % 10; // 余数

            // overflow判断： 大于最大值 || 小于最小值, return 0
            if (ret > Integer.MAX_VALUE / 10
                    || ret == Integer.MAX_VALUE / 10 && reminder > 7)
                return 0;
            if (ret < Integer.MIN_VALUE / 10
                    || ret == Integer.MIN_VALUE / 10 && reminder < -8)
                return 0;

            ret = ret * 10 + reminder;
            x = x / 10; // 计算完后再缩小规模
        }
        return ret;
    }

    public static int reverse2(int x) {
        int ret = 0;
        while (x != 0) {
            int remainer = x % 10;

            // overflow
            // bigger than the max
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && remainer > 7))
                return 0;
            // smaller than the min
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && remainer < -8))
                return 0;

            ret = ret * 10 + remainer;
            x /= 10;
        }
        return ret;
    }
}
