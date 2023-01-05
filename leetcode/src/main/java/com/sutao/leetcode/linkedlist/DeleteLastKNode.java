package com.sutao.leetcode.linkedlist;

//https://labuladong.github.io/algo/2/19/18/
//https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
//O(N)
public class DeleteLastKNode {
    public static void main(String[] args) {
        ListNode head = ListNode.init(new int[]{1});

        System.out.println(deleteLastKNode(head, 1));

        head = ListNode.init(new int[]{1, 2, 3, 4, 5});
        System.out.println(deleteLastKNode(head, 2));

        head = ListNode.init(new int[]{1, 2});
        System.out.println(deleteLastKNode(head, 2));
    }

    private static ListNode deleteLastKNode(ListNode head, int k) {
        if (null == head) return null;
        ListNode p1 = head, p2 = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        int count = 0;
        while (p2 != null) {
            if (++count > k) {
                if (p1 == null) p1 = head;
                pre = p1;
                p1 = p1.next;
            }

            p2 = p2.next;
        }
        pre.next = p1.next;
        p1.next = null;
        return p1 == head ? pre.next : head;
    }
}
