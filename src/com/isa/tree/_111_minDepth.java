package com.isa.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 *
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class _111_minDepth {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return 1;

        int depth = Integer.MAX_VALUE;
        if (root.left != null) {
            depth = Math.min(minDepth(root.left), depth);
        }
        if (root.right != null) {
            depth = Math.min(minDepth(root.right), depth);
        }
        return depth + 1;
    }

    public int minDepthLevelOrder(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1; // root is not null, so the min is 1

        // 层序遍历 每一层node
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return depth; // 叶子结点，则当前 depth 最小，return即可

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++; // one level traversal finished
        }
        return depth;
    }
}
