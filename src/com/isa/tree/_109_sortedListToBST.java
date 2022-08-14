package com.isa.tree;

/**
 * https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/
 *
 */
public class _109_sortedListToBST {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildBST(head, null);
    }

    private TreeNode buildBST(ListNode left, ListNode right) {
        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildBST(left, mid);
        root.right = buildBST(mid.next, right);
        return root;
    }

    private ListNode getMid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) { // fast != null is wrong
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
