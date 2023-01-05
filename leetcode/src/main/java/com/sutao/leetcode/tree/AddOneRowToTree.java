package com.sutao.leetcode.tree;

import java.util.Arrays;

//https://leetcode.cn/problems/add-one-row-to-tree/
public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (1 == depth) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        traverse(root, val, depth, 1);
        return root;
    }

    public void traverse(TreeNode root, int val, int depth, int level) {
        if (null == root) return;

        if (level == depth - 1) {
            addChildren(root, val);
            return;
        }

        traverse(root.left, val, depth, level + 1);
        traverse(root.right, val, depth, level + 1);
    }

    public void addChildren(TreeNode root, int val) {
        TreeNode left = new TreeNode(val);
        TreeNode right = new TreeNode(val);
        left.left = root.left;
        right.right = root.right;
        root.left = left;
        root.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(Arrays.asList(4,2,6,3,1,5,null), 0);
        root = new AddOneRowToTree().addOneRow(root, 1, 2);
        System.out.println(BFS.bfsSearch(root));
    }
}
