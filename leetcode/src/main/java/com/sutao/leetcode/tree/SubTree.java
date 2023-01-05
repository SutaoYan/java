package com.sutao.leetcode.tree;

import java.util.Arrays;
import java.util.List;

public class SubTree {

    public static void main(String[] args) {
        List<Integer> rootTree = Arrays.asList(3, 4, 5, 1, 2, null, null, null, null, 0);
        List<Integer> subTree = Arrays.asList(4, 1, 2);
        TreeNode root = TreeNode.initTree(rootTree, 0);
        TreeNode subRoot = TreeNode.initTree(subTree, 0);

        System.out.println(isSubtree(root, subRoot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private static boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    private static boolean check(TreeNode root, TreeNode subRoot) {
        if (null == root && null == subRoot) return true;

        if (null == root || null == subRoot || !root.val.equals(subRoot.val)) return false;

        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}
