package com.isa.array;

// https://leetcode.cn/problems/merge-sorted-array/

public class _88_merge {

    // 从尾部开始存放 number，因为从头部会覆盖掉原有的树
    // 题目是要合并 nums2 到 nums1 中, 非递减顺序, 所以 nums1 是保存numbers 的 array
    // 如果nums2 没有 item 了，则返回 num1

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int curr = nums1.length - 1; // current index 从最末一个位置开始放

        while (index2 >= 0) {
             if (index1 >= 0 && nums2[index2] < nums1[index1]) { // nums2 元素小于 num1
                 nums1[curr--] = nums1[index1--]; // 大的 value 在尾部
             } else {
                 // index1 < 0 || nums2 元素 > num1
                 nums1[curr--] = nums2[index2--];
             }
        }
    }
}
