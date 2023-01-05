package com.sutao.leetcode.others;

import com.sutao.leetcode.dp.tree.TreeNode;

import java.util.Arrays;

public class VisibleNode {
    private static int count;

    static void preOrder(TreeNode node, int max) {

        // Base case
        if (node == null) {
            return;
        }

        // If the current node value is greater
        // or equal to the max value,
        // then update count variable
        // and also update max variable
        if (node.val >= max) {
            count++;
            max = Math.max(node.val, max);
        }

        // Traverse to the left
        preOrder(node.left, max);

        // Traverse to the right
        preOrder(node.right, max);
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.initTree(Arrays.asList(8,2,6,8,7,null,null),0);
        preOrder(node, Integer.MIN_VALUE);

        System.out.println(count);
    }
}
