package com.isa.list;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class _234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        ListNode middleNode = getMiddleNode(head);
        ListNode reverseListNode = reverseList(middleNode.next);

        while (reverseListNode != null) {
            if (head.val != reverseListNode.val) return false;
            head = head.next;
            reverseListNode = reverseListNode.next;
        }
        return true;
    }

    private ListNode getMiddleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        // the next of fast or the next of the next of fast is null, the slow one is the middle one
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode node) {
        ListNode newHead = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = newHead;
            newHead = node;
            node = tmp;
        }
        return newHead;
    }
}
