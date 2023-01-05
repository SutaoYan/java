package com.sutao.leetcode.tree;

import com.sutao.leetcode.linkedlist.ListNode;

import java.util.Arrays;

//https://leetcode.cn/problems/linked-list-in-binary-tree/?plan=programming-skills&plan_progress=s5lrat5
public class LinkedListInBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {
        return traverse(head, root);
    }

    private boolean traverse(ListNode head, TreeNode node) {
        if (null == head) return true;
        if (node == null) return false;

        if (head.val == node.val) {
            if(check(head, node)) return true;
        }
        return traverse(head, node.left) || traverse(head, node.right);
    }

    private boolean check(ListNode head, TreeNode node) {
        if (null == head) return true;
        if (node == null) return false;

        if (head.val != node.val)  return false;
        return check(head.next, node.left) || check(head.next, node.right);
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.init(new int[]{4, 2, 8});
        boolean res = new LinkedListInBinaryTree().isSubPath(listNode, TreeNode.initTree(Arrays.asList(1, 4, 4, null, 2, 2, null, null, null, 1, null, 6, 8), 0));
        System.out.println(res);
    }

}
