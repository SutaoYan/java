package com.sutao.leetcode.linkedlist;

//https://labuladong.github.io/algo/2/19/18/
//O(N)
public class LastKNode {

    public static void main(String[] args) {
        ListNode head = ListNode.init(new int[]{0, 1, 2, 3, 4, 5, 6});
        System.out.println(findFromEnd(head, 3));
    }

    // 返回链表的倒数第 k 个节点
    private static ListNode findFromEnd(ListNode head, int k) {
        if (null == head) return null;
        ListNode p1 = null, p2 = head;

        int count = 0;
        while (p2 != null) {
            if (++count > k) {
                if (p1 == null) p1 = head;
                p1 = p1.next;
            }
            p2 = p2.next;
        }

        return p1;
    }
}
