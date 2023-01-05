package com.sutao.leetcode.linkedlist;

//https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
//https://labuladong.github.io/algo/2/20/23/
public class DeleteDuplicates {

    public static void main(String[] args) {

        System.out.println(deleteDuplicates(ListNode.init(new int[]{1, 1, 2})));

        System.out.println(deleteDuplicates(ListNode.init(new int[]{1, 1, 2, 3, 3})));

        System.out.println(deleteDuplicates(ListNode.init(new int[]{1, 1})));

        System.out.println(deleteDuplicates(ListNode.init(new int[]{1, 2})));

        System.out.println(deleteDuplicates(ListNode.init(new int[]{1})));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (null == head) return head;
        ListNode fast = head.next, slow = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
