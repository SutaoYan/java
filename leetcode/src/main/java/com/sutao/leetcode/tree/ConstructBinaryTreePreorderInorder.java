package com.sutao.leetcode.tree;

//https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//https://labuladong.github.io/algo/2/21/38/

import java.util.HashMap;

public class ConstructBinaryTreePreorderInorder {

    private HashMap<Integer, Integer> valueToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valueToIndex.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pStart, int pEnd,
                              int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;
        TreeNode node = new TreeNode(preorder[pStart]);
        // the index of root node in inorder list
        int index = valueToIndex.get(preorder[pStart]);
        int leftSize = index - iStart;
        node.left = buildTree(preorder, pStart + 1, pStart + leftSize,
                inorder, iStart, index - 1);
        node.right = buildTree(preorder, pStart + leftSize + 1, pEnd,
                inorder, index + 1, iEnd);

        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new ConstructBinaryTreePreorderInorder()
                .buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        System.out.println(BFS.bfsSearch(node));
    }
}
