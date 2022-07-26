package com.isa.list;

public class _23_mergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
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
