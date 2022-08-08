package com.isa.tree;

/**
 * https://leetcode.cn/problems/subtree-of-another-tree/
 *
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
 * 如果存在，返回 true ；否则，返回 false 。

 */
public class _572_isSubtree {

    private final String TAIL_NULL = "#!";
    private final String TAIL_NODE = "!";

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        return postSerialize(root).contains(postSerialize(subRoot));
    }

    // serialize the tree
    public String postSerialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        postSerialize(root, stringBuilder);
        return stringBuilder.toString();
    }

    public void postSerialize(TreeNode node, StringBuilder stringBuilder) {
        if (node.left == null) {
            stringBuilder.append(TAIL_NULL);
        } else {
            postSerialize(node.left, stringBuilder);
        }

        if (node.right == null) {
            stringBuilder.append(TAIL_NULL);
        } else {
            postSerialize(node.right, stringBuilder);
        }

        stringBuilder.append(node.val).append(TAIL_NODE);
    }
}
