package com.sutao.leetcode.tree;

import java.util.List;

public class TreeNode {

    public Integer val;
    public TreeNode left = null;
    public TreeNode right = null;
    public List<TreeNode> children;

    public TreeNode(Integer val) {
        this.val = val;
    }

//    先序遍历（递归）：35 20 15 16 29 28 30 40 50 45 55
//    中序遍历（递归）：15 16 20 28 29 30 35 40 45 50 55
//    后序遍历（递归）：16 15 28 30 29 20 45 55 50 40 35
//    先序遍历（非递归）：35 20 15 16 29 28 30 40 50 45 55
//    中序遍历（非递归）：15 16 20 28 29 30 35 40 45 50 55
//    后序遍历（非递归）：16 15 28 30 29 20 45 55 50 40 35
//    广度优先遍历：35 20 40 15 29 50 16 28 30 45 55

    public static TreeNode initTree() {
        TreeNode root = new TreeNode(35);
        root.left = new TreeNode(20);

        root.left.left = new TreeNode(15);
        root.left.left.right = new TreeNode(16);
        root.left.right = new TreeNode(29);
        root.left.right.left = new TreeNode(28);
        root.left.right.right = new TreeNode(30);

        root.right = new TreeNode(40);
        root.right.right = new TreeNode(50);
        root.right.right.left = new TreeNode(45);
        root.right.right.right = new TreeNode(55);
        return root;
    }

    public static TreeNode initTree(List<Integer> treeArray, int i) {
        if (i >= treeArray.size()) return null;
        Integer val = treeArray.get(i);
        if (null == val) return null;
        TreeNode root = new TreeNode(val);
        root.left = initTree(treeArray, 2 * i + 1);
        root.right = initTree(treeArray, 2 * i + 2);
        return root;
    }

    public String toString() {
        return com.sutao.leetcode.tree.BFS.bfsSearch(this);
    }
}
