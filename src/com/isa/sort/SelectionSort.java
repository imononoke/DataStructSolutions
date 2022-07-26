package com.isa.sort;

public class SelectionSort extends Sort {

    public static void main(String[] args) {
//        Integer[] array = new Integer[] {2, 3};

    }

    // 从序列中找出最大的元素，和最后一个元素交换
    @Override
    void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIdx = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] >= array[maxIdx]) { // 稳定
                    maxIdx = begin;
                }
            }
            // 比较完，end 是最后一个元素的 index，交换最大元素和最后一个元素
            swap(maxIdx, end);
        }
    }
}
