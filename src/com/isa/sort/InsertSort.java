package com.isa.sort;

public class InsertSort extends Sort {

    private final int[] array = new int[] {3, 121, 411, 332, 193, 23, 53, 132, 34, 2, 52, 223, 21, 12};

    @Override
    public void sort() {
        // ie, 5, 1
        for (int begin = 1; begin < array.length; begin++) {
            int curr = begin;
            int v = array[curr]; // v = arr[1] = 1
            // 优化：交换 改成 挪动
            while (curr > 0 && array[curr] < array[curr - 1]) {
                array[curr] = array[curr - 1]; // arr[1] = arr[0] = 5 --> 5, 5
                curr--; // curr = 0
            }
            array[curr] = v; // arr[0] = 1
        }
    }
}
