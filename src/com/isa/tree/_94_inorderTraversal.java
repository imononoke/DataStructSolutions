package com.isa.tree;

import java.util.ArrayList;
import java.util.List;

public class _94_inorderTraversal {
    public static void main(String[] args) {

    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;

        list.add(root.val);
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        return list;
    }
}
