package com.isa.list;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class _160_getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {
            currA = (currA.next == null) ? headB : currA.next; // list A 扫描完之后，拼接 List B 继续
            currB = (currB.next == null) ? headA : currB.next; // list B 扫描完之后，拼接 List A 继续
        }
        // after scan, currA and currB will point to the same node
        return currA; // return currB is the same
    }
}
