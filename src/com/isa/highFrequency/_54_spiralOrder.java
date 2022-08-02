package com.isa.highFrequency;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 */
public class _54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null) return ret;

        // right 最大值是每一行 length - 1
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            // left top -> right top
            for (int i = left; i <= right; i++) { // 可以 == right, 因为right 最大是 length - 1
                ret.add(matrix[top][i]);
            }
            top++; // increase after each loop, so the next loop could just start with value, instead of inc 1

            // top right -> bottom right
            for (int i = top; i <= bottom; i++) { // i = top + 1 -- not recommended
                // `right` is col!
                ret.add(matrix[i][right]); // ret.add(matrix[bottom][i]);
            }
            right--;

            if (top > bottom || left > right) // 行号单数、列双数的时候，需要判断有没有重叠
                break;

            // bottom right -> bottom left
            for (int i = right; i >= left; i--) {
                ret.add(matrix[bottom][i]);
            }
            bottom--;

            // bottom left -> top left
            for (int i = bottom; i >= top; i--) {
                ret.add(matrix[i][left]);
            }
            left++;

            // increase each index after loop
            // left++;
            // right--;
            // top++;
            // bottom--;
        }
        return ret;
    }
}
