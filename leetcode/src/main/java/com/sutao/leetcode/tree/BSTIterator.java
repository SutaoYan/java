package com.sutao.leetcode.tree;

import java.util.LinkedList;

//https://leetcode.cn/problems/binary-search-tree-iterator/?envType=study-plan&id=programming-skills-basic&plan=programming-skills&plan_progress=43k6uue
public class BSTIterator {

    LinkedList<TreeNode> stack = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        DFS(root);
    }

    public void DFS(TreeNode root) {
        if (null == root) return;
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if(node.right != null) {
            DFS(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }


    public static void main(String[] args) {
        BSTIterator bstIterator = new BSTIterator(TreeNode.initTree());

        while(bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}
