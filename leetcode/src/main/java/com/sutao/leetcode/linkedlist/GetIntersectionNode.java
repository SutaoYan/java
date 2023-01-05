package com.sutao.leetcode.linkedlist;

//https://labuladong.github.io/algo/2/19/18/
//https://leetcode.cn/problems/intersection-of-two-linked-lists/
//O(m+n) m 为listA 的长度，n为listB的长度
public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) p1 = headB;
            else p1 = p1.next;

            if (p2 == null) p2 = headA;
            else p2 = p2.next;

        }
        return p1;

    }

}
