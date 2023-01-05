package com.sutao.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree();
        System.out.println(root.toString());

        //    先序遍历（递归）：35 20 15 16 29 28 30 40 50 45 55
        System.out.println("pre order result");
        System.out.println(recursionPreOrderTraversal(root));
        System.out.println(preorderTraversal(root));

        //    中序遍历（递归）：15 16 20 28 29 30 35 40 45 50 55
        System.out.println("in order result");
        System.out.println(recursionInOrderTraversal(root));
        System.out.println(inOrderTraversal(root));


        //    后序遍历（递归）：16 15 28 30 29 20 45 55 50 40 35
        System.out.println("post order result");
        System.out.println(recursionPostOrderTraversal(root));
        System.out.println(postOrderTraversal(root));
    }

    private static String recursionPreOrderTraversal(TreeNode root) {
        if (null != root) {
//            result.add(root.val);
            System.out.print("" + root.val + ",");
            recursionPreOrderTraversal(root.left);
            recursionPreOrderTraversal(root.right);
        }
        return "";
    }

    private static String recursionInOrderTraversal(TreeNode root) {
        if (null != root) {
            recursionInOrderTraversal(root.left);
            System.out.print("" + root.val + ",");
            recursionInOrderTraversal(root.right);
        }
        return "";
    }

    private static String recursionPostOrderTraversal(TreeNode root) {
        if (null != root) {
            recursionPostOrderTraversal(root.left);
            recursionPostOrderTraversal(root.right);
            System.out.print("" + root.val + ",");
        }
        return "";
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            while (node != null) {
                res.add(node.val);
                if (node.right != null) stack.push(node.right);
                node = node.left;
            }
        }
        return res;
    }


    private static List<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root) return res;

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (null != node || !stack.isEmpty()) {

            while (null != node) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }

        }
        return res;
    }

    private static List<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root) return res;

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode visited = null;
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.peek();
                if (null == node.right || visited == node.right) {
                    res.add(node.val);
                    stack.pop();
                    visited = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return res;
    }
}
