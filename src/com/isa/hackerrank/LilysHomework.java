package com.isa.hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/lilys-homework/problem?isFullScreen=true
 *
 * Consider an array of  distinct integers, .
 * George can swap any two elements of the array any number of times. An array is beautiful if the sum of  among  is minimal.
 *
 * Given the array , determine and return the minimum number of swaps that should be performed in order to make the array beautiful.
 *
 * Example
 * One minimal array is . To get there, George performed the following swaps:
 * Swap      Result
 *           [7, 15, 12, 3]
 *     3 7   [3, 15, 12, 7]
 *     7 15  [3, 7, 12, 15]
 */
public class LilysHomework {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     *
     */

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(1);
        int ret = lilysHomework(arr);
    }

    private static int count = 0;
    private static int countBigger = 0;

//    static class Point implements Comparable<Point> {
//
//        public int x, y;
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public int compareTo(Point other) {
//            return this.x - other.x;
//        }
//    }

    // 排序，最少交换次数
//    public static int lilysHomework(List<Integer> arr) {
//        // Write your code here
//        if (arr == null) return 0;
//        int[] array = new int[arr.size()];
//
//        for (int i = 0; i < arr.size(); i++) {
//            array[i] = arr.get(i);
//        }
//
//    }

    private static void sortArr1(int[] array) {
        for (int begin = 1; begin < array.length; begin++) {
            int curr = begin;
            int v = array[curr]; // v = arr[1] = 1
            // optimize
            while (curr > 0 && array[curr] < array[curr - 1]) {
                array[curr] = array[curr - 1]; // arr[1] = arr[0] = 5 --> 5, 5
                curr--; // curr = 0
            }
            array[curr] = v; // arr[0] = 1
        }
    }

    private static void sortArr2(int[] array) {
        for (int begin = 1; begin < array.length; begin++) {
            int curr = begin;
            int v = array[curr]; // v = arr[1] = 1
            // optimize
            while (curr > 0 && array[curr] > array[curr - 1]) {
                array[curr] = array[curr - 1]; // arr[1] = arr[0] = 5 --> 5, 5
                curr--; // curr = 0
            }
            array[curr] = v; // arr[0] = 1
        }
    }

    private static int getDestIdx(List<Integer> arr, int value) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == value) return i;
        }
        return -1;
    }

//    private static void swap(List<Integer> arr, int srcIdx, int destIdx) {
//        int tmp = arr.get(srcIdx);
//        arr.set(srcIdx, arr.get(destIdx));
//        arr.set(destIdx, tmp);
//    }

    public static int lilysHomework(List<Integer> arr) {
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> sortedArr = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        int swap1 = 0, swap2 = 0;

        for (int i = 0; i < arr.size(); i++) {
            Integer v = arr.get(i);
//            m.put(v, i);
            sortedArr.add(v);
            arr1.add(v);
        }

        Collections.sort(sortedArr);
        for (int i =0; i<sortedArr.size(); i++) {
            if (arr.get(i) != sortedArr.get(i)) {
                swap1++;

                int arrV = arr.get(i);
                int sortV = sortedArr.get(i);
                int originIndexBySortV = m.get(sortV);
                m.put(arrV, originIndexBySortV);
                swap(arr, i, originIndexBySortV);
            }
        }

        Collections.reverse(arr1);
        for (int i =0 ; i< arr1.size(); i++) {
            Integer v = arr1.get(i);
            m.put(v, i);
        }

        for (int i =0; i<sortedArr.size(); i++) {
            if (!arr1.get(i).equals(sortedArr.get(i))) {
                swap2++;

                int arrV = arr1.get(i);
                int sortV = sortedArr.get(i);
                int originIndexBySortV = m.get(sortV);
                m.put(arrV, originIndexBySortV);
                swap(arr1, i, originIndexBySortV);
            }
        }

        return Math.min(swap1, swap2);
    }
    public static void swap(List<Integer> arr, int index1, int index2) {
        int temp = arr.get(index2);
        arr.set(index2, arr.get(index1));
        arr.set(index1, temp);
    }
}
