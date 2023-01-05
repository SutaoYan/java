package com.sutao.leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.cn/problems/merge-k-sorted-lists/
//https://labuladong.github.io/algo/2/19/18/

//时间复杂度 O(NlogK), K为链表数，N为链表的节点总数
public class MergeKLists {

    public static void main(String[] args) {
//        ListNode[] lists = new ListNode[3];
//        lists[0] = ListNode.init(new int[]{1, 4, 5});
//        lists[1] = ListNode.init(new int[]{1, 3, 4});
//        lists[2] = ListNode.init(new int[]{2, 6});
//        ListNode[] lists = new ListNode[1];
//        System.out.println(mergeKLists(lists));
//        System.out.println(mergeKLists(lists));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(5, (o1, o2) -> o2 - o1);

        priorityQueue.offer(1);

        priorityQueue.offer(3);
        priorityQueue.offer(2);

        System.out.println(priorityQueue.poll());

    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length < 1) return null;
        ListNode dummy = new ListNode(-1);

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null) priorityQueue.add(lists[i]);
        }

        ListNode p = dummy;
        ListNode tmp = null;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            tmp = node.next;
            p.next = node;
            p = node;
            p.next = null;
            if (tmp != null) {
                priorityQueue.add(tmp);
            }

        }

        return dummy.next;
    }
}
