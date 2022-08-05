package com.isa.hackerrank;

import java.util.List;

/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 */
public class DiagonalDifference {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        // get each diagonal sum
        int leftToRightSum = 0; // i == j
        for (int i = 0; i < arr.size(); i++) {
            leftToRightSum += arr.get(i).get(i);
        }

        int rightToLeftSum = 0; // (0,2) (1,1) (2,0)
        int len = arr.size() - 1;
        for (int j = 0; j < arr.size(); j++) {
            rightToLeftSum += arr.get(j).get(len - j);
        }

        return Math.abs(leftToRightSum - rightToLeftSum);
    }
}
