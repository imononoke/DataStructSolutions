package com.isa.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class _46_permute {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 4, 7};
        permute(nums);
    }

    private static List<List<Integer>> res = new ArrayList<>();
    private static boolean[] selected;
    private static int[] lineNums;

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        if (nums.length == 0) return res;

        selected = new boolean[nums.length];
        lineNums = new int[nums.length];
        dfs(nums, 0);
        return res;
    }

    private static void dfs(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> subList = new ArrayList<>();
            for (int num : lineNums) {
                subList.add(num);
            }
            res.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
//            if (!selected[index]) {
//                subList.add(nums[index]);
//            }
            if (selected[i]) continue;

            // 第 index 层放的数是 nums[i]
            lineNums[index] = nums[i]; // lineNums[i] is wrong!
            selected[i] = true;
            dfs(nums, index + 1);

            // 从后一层回到上一层了，reset status
            selected[i] = false;
        }
    }

    private void dfs2(int[] nums, int idx) {
        if (idx == nums.length) {
            List<Integer> subList = new ArrayList<>();
            for (int num: lineNums) {
                subList.add(num);
            }
            res.add(subList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // if has been selected, continue
            if (!selected[i]) {
                lineNums[idx] = nums[i];
                selected[i] = true;
                dfs(nums, idx + 1);
                // reset
                selected[i] = false;
            } else continue;
        }
    }
}
