package com.isa.tree;

public class MorrisTree {

    public void inorder(TreeNode root) {
        TreeNode node = root;

        // 循环走两遍，第一次向左走，第二次向右走
        while (node != null) {
            if (node.left != null) {
                TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) { // 前驱node 的 right != node 结点自己
                    pred = pred.right; // 一直找到最右边，即 node 的前驱结点
                }

                if (pred.right == null) {
                    pred.right = node; // 前驱结点的 right 指向 node
                    node = node.left; // node 指向下一个（向左走）
                } else { // pred 的 right == node自己了
                    // find the node
                    pred.right = null; // 把 node 前驱结点的右指针移除，和 node 断开
                    System.out.print(node.val + ", ");
                    node = node.right; // node 指向下一个（向右边走）
                }
            } else { // node.left == null 找到最左边了，把当前结点 val 打印出来
                System.out.print(node.val + ", ");
                node = node.right;
            }
        }
    }
}
