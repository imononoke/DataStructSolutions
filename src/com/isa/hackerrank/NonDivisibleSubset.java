package com.isa.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class NonDivisibleSubset {
    /*
     * Complete the 'nonDivisibleSubset' function below.
     * Given a set of distinct integers, print the size of a maximal subset of S'
     * where the sum of any 2 numbers in S'' is not evenly divisible by k.
     *
     * 给定数组，子数组中任意两个数之和都不能被 k 整除，求满足条件的子数组集的最大长度
     *
     * The function is expected to return an INTEGER.
     * int S[n]: an array of integers
     * int k: the divisor
     *
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     *
     * Returns
     * int: the length of the longest subset of S meeting the criteria
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        if (s == null) return 0;
        int maxLen = 0;

        for (int i = 0; i < s.size(); i++) {
            // todo: combine sub array
            List<Integer> subList = new ArrayList<>();

            int sum = 0;
            int subLen = 0;
            for (int j = 0; j < subList.size(); j++) {

            }

            // 不能整除则记录
            if (sum % k != 0) subLen = subList.size();

            maxLen = Math.max(maxLen, subLen);
        }
        return maxLen;
    }
}
