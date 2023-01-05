package com.sutao.leetcode.linkedlist;

public class ListNode {
    public ListNode next;
    public int val;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode init(int[] array) {
        if (null == array) return null;
        ListNode head = null, p = null;
        for (int i = 0; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            if (i == 0) {
                head = p = node;
            } else {
                p.next = node;
                p = p.next;
            }
        }

        return head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode p = next;
        while (p != null) {
            sb.append(" " + p.val);
            p = p.next;
        }

        return sb.toString();
    }
}
