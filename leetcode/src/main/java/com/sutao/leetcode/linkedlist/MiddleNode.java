package com.sutao.leetcode.linkedlist;

//https://leetcode.cn/problems/middle-of-the-linked-list/
//https://labuladong.github.io/algo/2/19/18/
//O(N)
public class MiddleNode {

    public static void main(String[] args) {
        ListNode head = ListNode.init(new int[] {1,2,3,4,5});
        System.out.println(middleNode(head));
        head = ListNode.init(new int[] {1,2,3,4,5,6});
        System.out.println(middleNode(head));
        head = ListNode.init(new int[] {1,2});
        System.out.println(middleNode(head));
        head = ListNode.init(new int[] {1});
        System.out.println(middleNode(head));
    }

    private static ListNode middleNode(ListNode head) {
        ListNode p1 = head, p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1;
    }
}
