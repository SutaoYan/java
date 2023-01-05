package com.sutao.leetcode.tree;

import java.util.Arrays;

//https://leetcode.cn/problems/balanced-binary-tree/?envType=study-plan&id=programming-skills-basic

public class BalancedBinaryTree {

    public boolean isBalanced = true;

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if (!(Math.abs(leftDepth - rightDepth) < 2)) {
            isBalanced = false;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();

        balancedBinaryTree.maxDepth(TreeNode.initTree(Arrays.asList(3, 9, 20, null, null, 15, 7), 0));

        System.out.println(balancedBinaryTree.isBalanced);
        balancedBinaryTree.isBalanced = true;
        balancedBinaryTree.maxDepth(TreeNode.initTree(Arrays.asList(1, 2, 2, 3, 3, null, null, 4, 4), 0));

        System.out.println(balancedBinaryTree.isBalanced);
        balancedBinaryTree.isBalanced = true;
        balancedBinaryTree.maxDepth(TreeNode.initTree(Arrays.asList(), 0));

        System.out.println(balancedBinaryTree.isBalanced);
        balancedBinaryTree.isBalanced = true;
    }
}
