package com.isa.tree;

import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 *
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * Morris
 */
public class _103_zigzagLevelOrder {

    public static void main(String[] args) {
        _103_zigzagLevelOrder levelOrder = new _103_zigzagLevelOrder();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        levelOrder.zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isFromLeft = true; // start from left, and then right next time

        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (isFromLeft) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(new ArrayList<>(levelList));
            isFromLeft = !isFromLeft;
        }

        return list;
    }

    public List<List<Integer>> morrisOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        List<Integer> subList = null;
        while (root != null) {
//            List<Integer> subList = new ArrayList<>();

            if (root.left != null) {
                // find the precursor node of root
                TreeNode p = root.left;
                while (p.right != null && p.right != root) {
                    p = p.right;
                }

                // p is precursor
                if (p.right == null) {
                    p.right = root;
                    root = root.left;
                } else { // p.right == root
                    p.right = null;
//                    subList.add(root.val);
                    root = root.right;
                }
            } else { // root.left is null
//                subList.add(root.val);
                root = root.right;
            }
        }

        return list;
    }
}
