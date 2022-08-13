package com.isa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/binary-tree-right-side-view/
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class _199_rightSideView {

    // 右视图 not only contains right sub tree
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        return dfs(root, list);
    }

    private List<Integer> dfs(TreeNode root, List<Integer> list) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                if (i == levelSize - 1) { // the last one
                    list.add(node.val);
                }
            }
        }
        return list;
    }

    private List<Integer> dfs2(TreeNode root, int depth, List<Integer> list) {
        if (list.size() == depth) { // 当 list 长度和 depth 相等时 当前节点就是这一层的右节点 加入数组中
            list.add(root.val);
        }
        // 遍历右子树
        if (root.right != null) {
            dfs2(root.right, depth + 1, list);
        }
        // 遍历左子树
        if (root.left != null) {
            dfs2(root.left, depth + 1, list);
        }
        return list;
    }
}
