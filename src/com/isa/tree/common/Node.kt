package com.isa.tree.common

data class Node<E>(
    var element: E,
    var parent: Node<E>?
) {
    var left: Node<E>? = null
    var right: Node<E>? = null

    fun isLeaf(): Boolean {
        return left == null && right == null
    }

    fun hasTwoChild(): Boolean {
        return left != null && right != null
    }
}
