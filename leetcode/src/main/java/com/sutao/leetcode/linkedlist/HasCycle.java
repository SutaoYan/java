package com.sutao.leetcode.linkedlist;

//https://labuladong.github.io/algo/2/19/18/

public class HasCycle {

    public static void main(String[] args) {
        ListNode head = ListNode.init(new int[]{1, 2, 3});
        System.out.println(hasCycle(head));
        ListNode p = head.next.next;
        p.next = head;
        System.out.println(hasCycle(head));
    }

    private static boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;

        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
            if (p1 == p2) return true;
        }
        return false;
    }
}
