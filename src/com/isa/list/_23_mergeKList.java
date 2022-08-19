package com.isa.list;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _23_mergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, Comparator.comparingInt(node -> node.val)
        );

        // 将 k 个链表的头结点加入最小堆
        for (ListNode listHead : lists) {
            if (listHead != null)
                pq.offer(listHead); // offer will throw NullPointerException
        }

        while (!pq.isEmpty()) {
            ListNode subHead = pq.poll();
            head.next = subHead;
            if (subHead.next != null) { // 加入当前 node 的后一个 node
                pq.add(subHead.next);
            }
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null) return null;
        ListNode list = new ListNode(Integer.MIN_VALUE); // need to be min value!

        int num = lists.length;
        for (int i = 0; i < num; i++) {
            list = mergeTwoList(list, lists[i]);
        }
        return list.next;
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
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
}
