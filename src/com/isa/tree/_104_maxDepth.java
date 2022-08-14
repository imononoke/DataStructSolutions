package com.isa.tree;

import java.awt.geom.QuadCurve2D;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class _104_maxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
