package com.isa.list;

import java.util.List;

public class _21_mergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode(-1);
        ListNode list = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list.next = list1;
                list1 = list1.next;
            } else {
                list.next = list2;
                list2 = list2.next;
            }
            list = list.next; // move to next
        }

        list.next = (list1 != null) ? list1 : list2; // add the remains
        return head.next;
    }


    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode(-1);
        ListNode node = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        // not finished
        node.next = (list1 != null) ? list1 : list2;
        return head.next;
    }
}
