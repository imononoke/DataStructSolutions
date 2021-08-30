package com.isa.tree.bst

import com.isa.tree.common.Node
import com.isa.tree.common.TreeInfo
import kotlin.math.max

class BSTree<E>(
    val comparator: Comparator<E>? = null
) : TreeInfo<E> {

    var root: Node<E>? = null
    var left: Node<E>? = null
    var right: Node<E>? = null

    override var size: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun height(node: Node<E>?): Int {
        if (node == null)
            return 0

        return max(height(node.left), height(node.right)) + 1
    }

    override fun add(element: E) {
        elementNotNullCheck(element)

        // add the first node
        if (root == null) {
            root = Node(element, null)
            size++
            return
        }

        // not first
        var parent = root
        var node = root
        var ret = 0

        while (node != null) {
            parent = node
            when (compare(element, node.element).also { ret = it }) {
                0 -> {
                    // equals, replace node's element
                    node.element = element
                    return
                }
                -1 -> node = node.left
                1 -> node = node.right
            }
        }

        // add to parent
        val newNode = Node(element, parent)
        if (ret < 0) parent?.left = newNode
        else parent?.right = newNode
        size++
    }

    override fun remove(element: E) {
        elementNotNullCheck(element)
    }

    override fun print(node: Node<E>) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        root = null
        size = 0
    }

    override fun isContains(element: E): Boolean =
        getNode(element) != null

    override fun root(): Node<E>? =
        root

    override fun left(): Node<E>? =
        left

    override fun right(): Node<E>? =
        right

    fun getNode(element: E): Node<E>? {
        var node = root
        while (node != null) {
            when (compare(element, node.element)) {
                0 -> return node
                -1 -> node = node.left
                1 -> node = node.right
            }
        }
        return null
    }

    /**
     * 0 -> equal
     * -1 -> element1 less than element2
     * 1 -> element1 more than element2
     */
    fun compare(e1: E, e2: E): Int {
        if (comparator != null)
            return comparator.compare(e1, e2)
        return (e1 as Comparator<E>).compare(e1, e2)
    }

    private fun elementNotNullCheck(element: E) {
        if (element == null)
            return
    }
}
