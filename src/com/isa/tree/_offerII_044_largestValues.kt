package com.isa.tree

import java.util.LinkedList
import java.util.Queue

fun largestValues(root: TreeNode?): List<Int> {
    val list: MutableList<Int> = mutableListOf()

    if (root == null) return list
    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)

    while (!queue.isEmpty()) {
        var max = Int.MIN_VALUE
        val levelSize = queue.size

        for (i in 0 until levelSize) {
            val node = queue.poll()
            if (node.`val` > max) max = node.`val`

            node.left?.let {
                queue.offer(it)
            }

            node.right?.let {
                queue.offer(it)
            }
        }
        list.add(max)
    }
    return list
}