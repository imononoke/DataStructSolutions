package com.isa.tree;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class _98_isValidBST {

    private long pre = Long.MIN_VALUE; // 需要用 long，超过 int 范围了

    // 中序遍历时，判断当前节点是否大于中序遍历的前一个节点
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        // traverse the left
        // if (isValidBST(root.left)) { // 有 true 就返回了，false 的情况会检测不出
        //     return true;
        // }
        if (!isValidBST(root.left)) return false;

        if (root.val <= pre) return false; // 等于的情况也要考虑
        pre = root.val;

        return isValidBST(root.right);
    }
}
