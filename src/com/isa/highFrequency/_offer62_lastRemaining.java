package com.isa.highFrequency;

/**
 * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 0,1,···,n-1 这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 */
public class _offer62_lastRemaining {

    public int lastRemaining(int n, int m) {
        if (n == 1) return 0;

        return (lastRemaining(n - 1, m) - m) % n;
    }
}
