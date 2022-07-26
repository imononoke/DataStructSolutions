package com.isa.tree;

// https://leetcode-cn.com/problems/recover-binary-search-tree/
// 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树.
public class _99_recoverTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        treeNode.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(2);
        treeNode.right = null;
        recoverTree(treeNode);
    }

    // 记录当前 node 的前一个 node
    private static TreeNode prev;
    private static TreeNode first;
    private static TreeNode second;

    public static void recoverTree(TreeNode root) {
        findWrongNode(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        System.out.println(root.val);
    }

    private static void findWrongNode(TreeNode root) {
        if (root == null) return;

        findWrongNode(root.left);
        findNode(root);
        findWrongNode(root.right);
    }

    private static void findNode(TreeNode node) {
        // 有逆序对
        if (prev != null && prev.val > node.val) {
            // 第二个 wrong node，第二个逆序对中较小的node
            second = node;

            // 第一个 wrong node，第一个逆序对中较大的node
            if (first != null) return;
            first = prev;
        }
        prev = node;
    }
}
