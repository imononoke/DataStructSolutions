package com.isa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _113_pathSum {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return list;

        LinkedList<Integer> subList = new LinkedList<>();
        getPathList(subList, root, targetSum);
        return list;
    }

    private void getPathList(LinkedList<Integer> subList, TreeNode root, int targetSum) {
        //  所有节点值相加等于目标和 targetSum
        subList.offer(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            list.add(new LinkedList(subList)); // 叶子结点时，所剩sum == 该node val -- path finished
            return;
        }

        // left and right sub tree
        int remain = targetSum - root.val;
        if (root.left != null) {
            getPathList(subList, root.left, remain);
            subList.removeLast();
        }
        if (root.right != null) {
            getPathList(subList, root.right, remain);
            subList.removeLast();
        }
    }
}
