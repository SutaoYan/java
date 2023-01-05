package com.sutao.leetcode.tree;

import java.util.Arrays;

//https://leetcode.cn/problems/maximum-depth-of-binary-tree/submissions/
//https://labuladong.github.io/algo/2/21/36/
//O(N)
public class MaxDepth {

    int depth = 0;
    int res = 0;

    public void traverse(TreeNode root) {
        if (null == root) return;

        depth++;
        if (null == root.left && null == root.right) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }


    public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(Arrays.asList(3, 9, 20, null, null, 15, 7), 0);
        MaxDepth maxDepth = new MaxDepth();
        maxDepth.traverse(root);
        System.out.println(maxDepth.res);

        MaxDepth maxDepth1 = new MaxDepth();

        System.out.println(maxDepth1.maxDepth(root));
    }
}
