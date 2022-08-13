package com.isa.tree;

/**
 * https://leetcode.cn/problems/path-sum/
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 */
public class _112_hasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        //  所有节点值相加等于目标和 targetSum
        if (root.left == null && root.right == null) // root.val == targetSum is wrong
            return root.val == targetSum; // 叶子结点时，所剩sum == 该node val

        // solution 2
//        if (root.left == null && root.right == null && root.val == targetSum) // root.val == targetSum is wrong
//            // return root.val == targetSum; // 叶子结点时，所剩sum == 该node val
//            return true;

        // left and right sub tree
        int remain = targetSum - root.val;
        return hasPathSum(root.left, remain) || hasPathSum(root.right, remain);
    }
}
