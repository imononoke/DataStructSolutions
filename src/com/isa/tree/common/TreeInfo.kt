package com.isa.tree.common

interface TreeInfo<E> {
    var size: Int

    fun root(): Node<E>?
    fun left(): Node<E>?
    fun right(): Node<E>?

    fun size(): Int =
        size

    fun isEmpty(): Boolean =
        size == 0

    fun clear()

    fun height(node: Node<E>?): Int

    fun add(element: E)
    fun remove(element: E)
    fun isContains(element: E): Boolean
    fun print(node: Node<E>)
}