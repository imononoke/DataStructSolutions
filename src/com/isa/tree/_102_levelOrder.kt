package com.isa.tree

import java.util.LinkedList
import java.util.Queue

fun levelOrder(
    root: TreeNode?
): List<List<Int>> {
    val list = mutableListOf<MutableList<Int>>()

    if (root == null) return list

    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)

    while (!queue.isEmpty()) {
        val subList = mutableListOf<Int>()
        val levelSize = queue.size

        for (i in 0 until levelSize) {
            val node = queue.poll()
            subList.add(node.`val`)

            node.left?.let {
                queue.offer(it)
            }
            node.right?.let {
                queue.offer(it)
            }
        }
        list.add(subList)
    }

    return list
}
