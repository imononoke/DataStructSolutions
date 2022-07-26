package com.isa.tree;

public class SerializeTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(0);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        String res = postSerialize(treeNode);
        System.out.print(res);
    }

    /**
     * 使用后序遍历进行序列化
     * 空结点 '#!';
     * 其它元素后 + '!'
     * @param root
     */

    private static final String TAIL_NULL = "#!";
    private static final String TAIL_NODE = "!";

    public static String postSerialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        postSerialize(root, stringBuilder);
        return stringBuilder.toString();
    }

    public static void postSerialize(TreeNode node, StringBuilder stringBuilder) {
        if (node.left == null)
            stringBuilder.append(TAIL_NULL);
        else
            postSerialize(node.left, stringBuilder);

        if (node.right == null)
            stringBuilder.append(TAIL_NULL);
        else
            postSerialize(node.right, stringBuilder);

        stringBuilder.append(node.val).append(TAIL_NODE);
    }
}
