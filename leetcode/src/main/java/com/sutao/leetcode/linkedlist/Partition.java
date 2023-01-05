package com.sutao.leetcode.linkedlist;

//https://labuladong.github.io/algo/2/19/18/
//https://leetcode.cn/problems/partition-list/

public class Partition {
    public static void main(String[] args) {
        System.out.println(partition(ListNode.init(new int[]{1, 4, 3, 2, 5, 2}), 3));
        System.out.println(partition(ListNode.init(new int[]{2, 1}), 2));
        System.out.println(partition(ListNode.init(new int[]{1, 4, 3, 0, 2, 5, 2}), 3));
    }

    private static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();

        ListNode larger = dummy2;
        ListNode smaller = dummy1;

        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                smaller.next = p;
                smaller = p;
                p = p.next;
                smaller.next = null;
            } else {
                larger.next = p;
                larger = p;
                p = p.next;
                larger.next = null;
            }

        }
        smaller.next = dummy2.next;

        return dummy1.next;
    }
}
