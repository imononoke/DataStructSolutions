package com.isa.list;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 * 两个非空的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 */
public class _2_addTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(8);
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(-1);
        ListNode list = head;
        int inc = 0; // 进位 1 or 0
        int sum = 0; // 两个list item val 之和

//        while (l1 != null || l2 != null) {
//            ret = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
//            carry = ret / 10;
//
//            list.next = new ListNode(ret % 10);
//            l1 = (l1 != null) ? l1.next : null;
//            l2 = (l2 != null) ? l2.next : null;
//            list = list.next;
//        }
//        if (carry > 0) {
//            list.next = new ListNode(carry);
//        }

        while (l1 != null || l2 != null) { // not &&
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + inc;
            inc = sum / 10;
            list.next = new ListNode(sum % 10); // should be .next! item value 是 10 的余数

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            list = list.next;
        }
        // if there is still an inc item
        if (inc > 0) {
            list.next = new ListNode(inc);
        }
        return head.next;
    }
}
