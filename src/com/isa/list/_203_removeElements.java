package com.isa.list;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点。
 */
public class _203_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode newHead = dummy;

        while (newHead.next != null) {
            if (newHead.next.val != val) {
                newHead = newHead.next;
            } else {
                // find the val
                newHead.next = newHead.next.next;
            }
            // if (newHead.next.val == val) {
            //     newHead.next = newHead.next.next;
            // } else {
            //     newHead = newHead.next;
            // }
        }
        return dummy.next;
    }

}
