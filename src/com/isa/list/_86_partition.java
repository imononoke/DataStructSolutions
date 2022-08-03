package com.isa.list;

/**
 * https://leetcode.cn/problems/partition-list/
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class _86_partition {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1);
        ListNode leftTail = leftHead;
        ListNode rightHead = new ListNode(-1);
        ListNode rightTail = rightHead;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = head; // 左list tail 指向下一个
            } else {
                rightTail.next = head;
                rightTail = head; // 右list tail 指向下一个
            }
            head = head.next;
        }
        // joint
        leftTail.next = rightHead.next;
        rightTail.next = null;

        return leftHead.next;
    }
}
