package com.sutao.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesii {
    public List<com.sutao.leetcode.tree.TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    private List<com.sutao.leetcode.tree.TreeNode> buildTree(int min, int max) {
        List<com.sutao.leetcode.tree.TreeNode> res = new ArrayList<>();
        if (min > max) {
            res.add(null);
            return res;
        }

        for (int i = min; i <= max; i++) {
            List<TreeNode> lefts = buildTree(min, i - 1);
            List<TreeNode> rights = buildTree(i + 1, max);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTreesii().generateTrees(3));
    }
}
