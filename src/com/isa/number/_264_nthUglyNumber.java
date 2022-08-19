package com.isa.number;

/**
 * https://leetcode.cn/problems/ugly-number-ii/
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return the nth ugly number.
 */
public class _264_nthUglyNumber {

    public int nthUglyNumber(int n) {
        // prime factors are limited to 2, 3, and 5.
        // 把丑数分为三类：2 的倍数、3 的倍数、5 的倍数。
        int head2 = 1, head3 = 1, head5 = 1; // 指向三类 list 的 header
        int p2 = 1, p3 = 1, p5 = 1; // 指向三类 list 的 pointer

        int[] nums = new int[n + 1];
        int p = 1; // pointer to nums

        while (p <= n) {
            int min = Math.min(Math.min(head2, head3), head5); // 每次从三类list 头部选个最小值
            nums[p++] = min;

            if (min == head2) {
                head2 = 2 * nums[p2++];
            }
            if (min == head3) { // not use else if
                head3 = 3 * nums[p3++];
            }
            if (min == head5) {
                head5 = 5 * nums[p5++];
            }
        }
        return nums[n];
    }
}
