package com.isa.array;

// https://leetcode.cn/problems/sub-sort-lcci/

public class _16_16_subSort {
    public int[] subSort(int[] array) {
        if (array == null) return new int[] {-1, -1};

        // 向右扫描，从 index 1 开始，应该是升序
        int r = 0;
        int max = array[0]; // 假设index 0 最大
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else r = i; // 比 max 小，说明是逆序，需要排序
        }

        // 向右扫描，从 index 1 开始，应该是降序
        int l = 0;
        int min = array[array.length - 1]; // // 假设最后一个元素最小
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else l = i;
        }

        return new int[] {l, r};
    }
}
