package com.sutao.leetcode.tree;

//https://leetcode.cn/problems/maximum-binary-tree/
//https://labuladong.github.io/algo/2/21/38/
//O(n2)
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int lo, int hi) {
        if (lo < 0 || hi > nums.length - 1 || lo > hi) return null;

        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }

        TreeNode node = new TreeNode(nums[index]);
        node.left = construct(nums, lo, index - 1);
        node.right = construct(nums, index + 1, hi);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(BFS.bfsSearch(root));
    }
}
