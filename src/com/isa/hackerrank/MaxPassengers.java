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
        MaxPassengers maxPassengers = new MaxPassengers();
        int[][] grid = new int[][] { {1, 0}, {0, 1}};
        maxPassengers.collectMax(2, 2, grid);
    }

    static int max = 0;
    static int cols[];
    // 从左上到右下

    // correct answer!

    public int collectMax(int n, int m, int grid[][]) {
        int ans=0;
        int dp[][][]=new int[6][6][6];
        initializeDp(dp,-1); // dp 初始值都为-1
        if (grid[n - 1][m - 1] == -1 || grid[0][0] == -1) //如果最后一格或者第一格就是-1,不能走，game over！
            ans = -1 * Integer.MAX_VALUE; //不能走，给个负无穷 作为flag

        //第一格为1，或者最后一格为1，必走，所以值先加上，并且这两格子清0
        if (grid[0][0] == 1)
            ans++;
        grid[0][0] = 0;

        if (grid[n - 1][m - 1] == 1)
            ans++;

        grid[n - 1][m - 1] = 0;

        ans += solve(n, m, grid, dp, 0, 0, 0);
        return Math.max(ans, 0);
    }

    // 1round row1:0  col:1  row2:1 col2:0
    public int cost(int grid[][], int row1, int col1,int row2, int col2) {
        if (row1 == row2 && col1 == col2) {
            if (grid[row1][col1] == 1)
                return 1;
            return 0;
        }
        int ans = 0;

        if (grid[row1][col1] == 1)
            ans++;

        if (grid[row2][col2] == 1)
            ans++;

        return ans;
    }


    /*
     *
     * {0,0,1,1}
     * {0,0,0,0}
     * {0,0,0,0}
     * {1,1,1,0}
     *
     */

    // 1round  n, m, grid, dp, 0, 0, 0    2r 011
    public int solve(int n, int m, int grid[][],int dp[][][], int row1,int col1, int row2) {
        int col2 = (row1 + col1) - (row2);   //mj貌似提过这公式，矩阵左下角 {(0，0),(0，0)}  {(0，1),(1，0)}  {(0，2),(1，1)}  {(0，3),(1，2)}

        if (row1 == n - 1 && col1 == m - 1 &&row2 == n - 1 && col2 == m - 1) // row1 col1 row2 col2 全部进入最后一格，不会带乘客 return 0 结束
            return 0;

        if (row1 >= n || col1 >= m ||row2 >= n || col2 >= m) // 超边界了 结束
            return -1 * Integer.MAX_VALUE;

        if (dp[row1][col1][row2] != -1)  //dp这三个值不为初始值-1 说明dp已经计算过了，直接返回
            return dp[row1][col1][row2];

        int ch1 = -1 * Integer.MAX_VALUE, ch2 = -1 * Integer.MAX_VALUE;
        int ch3 = -1 * Integer.MAX_VALUE, ch4 = -1 * Integer.MAX_VALUE;

        if (col1 + 1< m && row2 + 1 < n && grid[row1][col1 + 1] != -1 && grid[row2 + 1][col2] != -1)  //右+下  如果（0，1）和（1，0）都不为-1，则说明（0，0）可以往下走。
        {
            System.out.printf("ch1-> row1-[col1+1]: %d,%d   [row2+1]-col2: %d,%d\n", row1, col1 + 1,  row2 + 1 , col2);
            if(row1==3&&col1+1==3&&row2+1==3&&col2==3) {
                System.out.printf("\n");
            }
            // 路1往右 路2往下
            ch1 = cost(grid, row1, col1 + 1, row2 + 1, col2) + solve(n, m, grid, dp, row1, col1 + 1, row2 + 1);
        }

        if (col1 + 1< m && col2 + 1 < n && grid[row1][col1 + 1] != -1 && grid[row2][col2 + 1] != -1) //
        {
            System.out.printf("ch2-> row1-[col1+1]: %d,%d   row2-[col2+1]: %d,%d\n", row1, col1 + 1,  row2 , col2 + 1);
            if(row1==3&&col1+1==3&&row2==3&&col2+1==3) {
                System.out.printf("\n");
            }
            // 路1往右 路2往右
            ch2 = cost(grid, row1, col1 + 1, row2, col2 + 1) +solve(n, m, grid, dp, row1, col1 + 1, row2);
        }

        if (row1 + 1< m && col2 + 1 < n && grid[row1 + 1][col1] != -1 && grid[row2][col2 + 1] != -1)  // 正上
        {  System.out.printf("ch3-> [row1+1]-col1: %d,%d   row2-[col2+1]: %d,%d\n", row1+1, col1,  row2, col2+ 1);
            if(row1+1==3&&col1==3&&row2==3&&col2+1==3) {
                System.out.printf("\n");
            }
            // 路1往下 路2往右
            ch3 = cost(grid, row1 + 1, col1, row2, col2 + 1) +solve(n, m, grid, dp, row1 + 1, col1, row2);
        }

        if (row1 + 1< m && row2 + 1 < n && grid[row1 + 1][col1] != -1 && grid[row2 + 1][col2] != -1) // 左下
        {
            System.out.printf("ch4-> [row1+1]-col1: %d,%d   [row2+1]-col2: %d,%d\n", row1+1, col1,  row2 + 1 , col2);
            if(row1+1==3&&col1==3&&row2+1==3&&col2==3) {
                System.out.printf("\n");
            }
            // 路1往下 路2往下
            ch4 = cost(grid, row1 + 1, col1, row2 + 1, col2) +solve(n, m, grid, dp, row1 + 1, col1, row2 + 1);
        }
        return dp[row1][col1][row2] = Math.max(ch1, Math.max(ch2, Math.max(ch3, ch4)));
    }

    public void initializeDp(int dp[][][],int item) {
        for (int i=0;i<5;i++) {
            for(int j=0;j<5;j++)
                for(int k=0;k<5;k++)
                    dp[i][j][k]=item;
        }
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
