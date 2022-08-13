package com.isa.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-paths/
 *
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 */
public class _257_binaryTreePaths {

    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return list;

        dfs("", root);
        return list;
    }

    private void dfs(String path, TreeNode node) {
        if (node == null){
            return ;
        }

        StringBuilder sub = new StringBuilder(path);
        sub.append(node.val);

        if (node.left == null && node.right == null) {
            list.add(new String(sub));
        } else {
            sub.append("->");
            dfs(sub.toString(), node.left);
            dfs(sub.toString(), node.right);
        }
    }
}
