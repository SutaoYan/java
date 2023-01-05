package com.sutao.leetcode.tree;

import java.util.Arrays;

//https://leetcode.cn/problems/invert-binary-tree/
//https://labuladong.github.io/algo/2/21/37/

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (null == root) return null;
        traversal(root);
        return root;
    }

    public static void traversal(TreeNode node) {
        if (null == node) return;
        traversal(node.left);
        traversal(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (null == root) return null;
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(Arrays.asList(4, 2, 7, 1, 3, 6, 9), 0);
        System.out.println(BFS.toArray(root));
        invertTree(root);
        System.out.println(BFS.toArray(root));
        invertTree2(root);
        System.out.println(BFS.toArray(root));
    }
}
