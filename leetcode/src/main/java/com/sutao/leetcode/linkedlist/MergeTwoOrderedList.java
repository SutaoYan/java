package com.sutao.leetcode.linkedlist;

//https://leetcode.cn/problems/merge-two-sorted-lists/
//https://labuladong.github.io/algo/2/19/18/

public class MergeTwoOrderedList {

    public static void main(String[] args) {
        ListNode l1 = ListNode.init(new int[]{1, 2, 4});
        ListNode l2 = ListNode.init(new int[]{1, 3, 4});
        System.out.println(merge(l1, l2));
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                head.next = p2;
                p2 = p2.next;
            } else {
                head.next = p1;
                p1 = p1.next;
            }
            head = head.next;
        }

        if (p1 != null) head.next = p1;
        if (p2 != null) head.next = p2;

        return dummy.next;
    }
}
