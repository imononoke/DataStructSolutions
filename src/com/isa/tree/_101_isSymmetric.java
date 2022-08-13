package com.isa.tree;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class _101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;

        return dfs(root.left,  root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        else if (left.val != right.val) return false;

        //再递归的比较 左节点的左子树 和 右节点的右子树 以及 左节点的右子树 和 右节点的左子树
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
