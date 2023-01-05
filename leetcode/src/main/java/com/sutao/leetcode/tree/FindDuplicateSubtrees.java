package com.sutao.leetcode.tree;

//https://leetcode.cn/problems/find-duplicate-subtrees/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    ArrayList<TreeNode> res = new ArrayList<>();
    HashMap<String, Integer> subTrees = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode node) {
        if (null == node) return "#";

        String left = traverse(node.left);
        String right = traverse(node.right);

        String current = "" + node.val + "," + left + "," + right;
        int count = subTrees.getOrDefault(current, 0);
        if (count == 1) {
            res.add(node);
        }
        subTrees.put(current, ++count);

        return current;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(Arrays.asList(1, 2, 3, 4, null, 2, 4, null, null,null,null, 4, null), 0);
        System.out.println(new FindDuplicateSubtrees().findDuplicateSubtrees(root));
    }
}
