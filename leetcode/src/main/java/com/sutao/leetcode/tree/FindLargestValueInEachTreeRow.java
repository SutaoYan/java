package com.sutao.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.cn/problems/find-largest-value-in-each-tree-row/

public class FindLargestValueInEachTreeRow {

    public static List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            while (len > 0) {
                TreeNode node = queue.poll();
                len--;
                max = Math.max(max, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(max);
        }

        return res;
    }

    public static List<Integer> largestValuesDFS(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root) return res;
        traversal(root, 0, res);
        return res;
    }

    public static void traversal(TreeNode node, int level, List<Integer> res) {
        if (null == node) return;
        if(level + 1 > res.size()) {
            res.add(node.val);
        }else {
            res.set(level, Math.max(res.get(level), node.val));
        }
        traversal(node.left, level + 1, res);
        traversal(node.right, level + 1, res);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(Arrays.asList(1, 3, 2, 5, 3, null, 9), 0);
        System.out.println(largestValues(root));
        System.out.println(largestValuesDFS(root));
    }

}
