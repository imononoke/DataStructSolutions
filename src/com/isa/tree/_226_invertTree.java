package com.isa.tree;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class _226_invertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // left -> right && right -> left
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
