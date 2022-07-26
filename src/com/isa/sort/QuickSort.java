package com.isa.sort;

public class QuickSort {

    private static final int[] array = new int[] {3, 121, 411, 332, 193, 23, 53, 132, 34, 2, 52, 223, 21, 12};

    public static void main(String[] args) {
        quickSort();
    }

    public static void quickSort() {
        sort(0, array.length - 1); // sort(0, array.length - 1); getPilotIndex 里 end 不用--; 为什么不对？

        for (int j : array) {
            System.out.print(j + ", ");
        }
    }

    // sort range: [begin, end)
    private static void sort(int begin, int end) {
        if (end - begin < 1) return;

        int pilotIndex = getPilotIndex(begin, end);
        // sort sub array
        sort(begin, pilotIndex);
        sort(pilotIndex + 1, end);
    }

    private static int getPilotIndex(int begin, int end) {
        // back the begin value
        int p = array[begin];
//        end--; // end point to the last item (length - 1)

        while (begin < end) {
            // 先从 end 开始比较
            while (begin < end) {
                if (p < array[end]) { // end 比 p 大，则 end--
                    end--;
                } else {
                    array[begin++] = array[end];
                    break;
                }
            }

            // 比较左边
            while (begin < end) {
                if (p > array[begin]) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        // 轴点 value 换回备份值
        array[begin] = p;
        return begin;
    }
}
