package com.isa.tree;

/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 */
public class _108_sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBst(nums, 0, nums.length - 1);
    }

    private TreeNode arrayToBst(int[] nums, int begin, int end) {
        if (begin > end) return null;

        // find the mid node
        int mid = (end + begin) >> 1; // === / 2
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = arrayToBst(nums, begin, mid - 1); // end 是 mid - 1，因为 mid 是 root
        treeNode.right = arrayToBst(nums, mid + 1, end);
        return treeNode;
    }
}
