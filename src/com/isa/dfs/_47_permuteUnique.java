package com.isa.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations-ii/
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class _47_permuteUnique {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 2, 3};
        permuteUnique(nums);
    }

    private static boolean[] selected;
//    private static int[] lineNums;
    private static List<Integer> lineNums;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        selected = new boolean[nums.length];
        lineNums = new ArrayList<>();

        dfs(nums, 0, res);
        return res;
    }

    private static void dfs(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> subList = new ArrayList<>();
            for (int num: lineNums) {
                subList.add(num);
            }
            res.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (selected[i]) continue;

            selected[i] = true;
            if (!lineNums.contains(nums[i])) {
                lineNums.add(nums[i]);
            }

            dfs(nums, index + 1, res);

            // reset status
            selected[i] = false;
        }
    }
}
