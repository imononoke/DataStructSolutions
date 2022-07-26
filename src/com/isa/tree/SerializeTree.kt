package com.isa.tree

class SerializeTree {

    fun main() {
        val root = TreeNode(3)
        root.left = TreeNode(4)
        root.left.left = TreeNode(1)
        root.left.right = TreeNode(2)
        root.right = TreeNode(5)

        val subRoot = TreeNode(4)
        root.left = TreeNode(1)
        root.right = TreeNode(2)
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null || subRoot == null) {
            return false
        }

        return serrilizeTree(root).contains(serrilizeTree(subRoot))
    }

    companion object {
        const val TAIL_NULL = "#!"
        const val TAIL_NODE = "!"
    }

    fun serrilizeTree(root: TreeNode): String {
        val stringBuilder = StringBuilder()
        serrilizeTree(root, stringBuilder)
        System.out.println(stringBuilder.toString())
        return stringBuilder.toString()
    }

    fun serrilizeTree(node: TreeNode, stringBuilder: StringBuilder) {
        if (node.left == null) stringBuilder.append(TAIL_NULL)
        else serrilizeTree(node.left, stringBuilder)

        if (node.right == null) stringBuilder.append(TAIL_NULL)
        else serrilizeTree(node.right, stringBuilder)

        stringBuilder.append(node.`val`).append(TAIL_NODE)
    }
}