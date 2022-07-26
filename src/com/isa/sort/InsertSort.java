package com.isa.sort;

public class InsertSort extends Sort {

    private final int[] array = new int[] {3, 121, 411, 332, 193, 23, 53, 132, 34, 2, 52, 223, 21, 12};

    @Override
    public void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int curr = begin;
            int v = array[curr];
            // 优化：交换 改成 挪动
            while (curr > 0 && array[curr] < array[curr - 1]) {
                array[curr] = array[curr - 1];
                curr--;
            }
            array[curr] = v;
        }
    }
}
