package com.sutao.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;

//https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
//https://labuladong.github.io/algo/2/21/37/
public class FlattenBinaryTreeToLinkedList {

    private static void flatten2(TreeNode root, boolean left, LinkedList<Integer> path) {
        if (null == root) return;
        if(!left) path.add(root.val);
        flatten2(root.left, true, path);
        flatten2(root.right, false, path);
    }

    public static TreeNode flatten(TreeNode root) {
        if (null == root) return null;

        TreeNode left = flatten(root.left);
        TreeNode right = flatten(root.right);
        TreeNode node = left;
        while (null != node && node.right != null) {
            node = node.right;
        }
        if (null != node) node.right = right;
        if (null != left) root.right = left;
        root.left = null;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(Arrays.asList(1, 2, 5, 3, 4, null, 6), 0);
        LinkedList<Integer> res = new LinkedList<>();
        flatten2(root, false, res);
        System.out.println(res);
    }

}
