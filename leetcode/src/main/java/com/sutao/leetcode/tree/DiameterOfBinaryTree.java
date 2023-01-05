package com.sutao.leetcode.tree;

import java.util.Arrays;

//https://leetcode.cn/problems/diameter-of-binary-tree/
//https://labuladong.github.io/algo/2/21/36/
//O(N)
public class DiameterOfBinaryTree {
    private static int res;

    private static int maxDepth(TreeNode root) {
        if (null == root) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        res = Math.max(res, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(Arrays.asList(1, 2, 3, 4, 5, null, null), 0);
        System.out.println(maxDepth(root));
        res = 0;
        TreeNode root2 = TreeNode.initTree(Arrays.asList(1, 2, null), 0);
        maxDepth(root2);
        System.out.println(res);
    }
}
