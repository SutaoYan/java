package com.sutao.leetcode.tree;

//https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//https://labuladong.github.io/algo/2/21/38/

import java.util.HashMap;

public class ConstructBinaryTreeInorderPostorder {

    private HashMap<Integer, Integer> valueToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valueToIndex.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1
                );
    }

    public TreeNode buildTree(int[] postorder, int pStart, int pEnd,
                              int[] inorder, int iStart, int iEnd) {
        if (iStart > iEnd) return null;
        TreeNode node = new TreeNode(postorder[pEnd]);
        // the index of root node in inorder list
        int index = valueToIndex.get(postorder[pEnd]);
        int leftSize = index - iStart;
        node.left = buildTree(postorder, pStart, pStart + leftSize -1,
                inorder, iStart, index - 1);
        node.right = buildTree(postorder, pStart + leftSize, pEnd -1,
                inorder, index + 1, iEnd);

        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new ConstructBinaryTreeInorderPostorder()
                .buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9,15,7,20,3});

        System.out.println(BFS.bfsSearch(node));
    }
}
