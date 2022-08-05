package com.isa.hackerrank;

/**
 * Problem Statement -: A taxi can take multiple passengers to the railway station at the same time.
 * On the way back to the starting point,the taxi driver may pick up additional passengers for his next trip to the airport.
 * A map of passenger location has been created,represented as a square matrix.
 *
 * A value greater than or equal to zero represents a path.
 * A value equal to 1 represents a passenger.
 * A value equal to -1 represents an obstruction.
 */
public class MaxPassengers {

    public static void main(String[] args) {
        int[][] grid = new int[][] { {1, 0}, {0, 1}};
        collectMax(2, 2, grid);
    }

    static int max = 0;
    static int cols[];
    // 从左上到右下，

    public static int collectMax(int n, int m, int grid[][]) {

        // 从left top 到 right bottom，再从 right bottom 到 left top 走一遍
        // save the path and passengers
//        int[][][] dp = new int[][][] {};

        cols = new int[grid[0].length];
        driveToBottom(grid, 0);

        return max;
    }

    private static void driveToBottom(int grid[][], int row) {
        if (row == cols.length) {
            // be the last row, should go back to left top, clear the passengers
            driveToLeftTop(grid, row);
        }

        for (int col = 0; col < cols.length; col++) {
            if (isPassenger(grid, row, col)) {
                driveToBottom(grid, row + 1);
            }
        }
    }

    private static void driveToLeftTop(int grid[][], int row) {
        if (row == 0) {
            // at the left top row, finish
            return;
        }

        for (int col = cols.length - 1; col >= 0; col--) {
            if (isPassenger(grid, row - 1, col)) {
                driveToBottom(grid, row - 1);
            }
        }
    }

    private static boolean isPassenger(int[][] grid, int row, int col) {
        // if the value >= 0
        if (grid[row][col] < 0) return false;
        else if (grid[row][col] == 1) max++;

        return true;
    }
}
