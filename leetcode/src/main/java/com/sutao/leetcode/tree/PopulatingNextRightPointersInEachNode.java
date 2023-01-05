package com.sutao.leetcode.tree;

//https://labuladong.github.io/algo/2/21/37/
//https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersInEachNode {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(null == root) return null;
        combine(root.left, root.right);
        return root;
    }

    public void combine(Node left, Node right) {
        if (null == left || null == right) return;
        left.next = right;
        combine(left.left, left.right);
        combine(left.right, right.left);
        combine(right.left, right.right);
    }
}
