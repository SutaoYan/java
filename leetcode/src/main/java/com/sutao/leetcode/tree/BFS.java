package com.sutao.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree();
//        System.out.println(bfsSearch(root));
//        System.out.println(bfeTraversal(root));
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        new BFS().Bfs(root, res);
        System.out.println(res);
    }


    //偶数行倒叙
    private void Bfs(TreeNode root, ArrayList<LinkedList<Integer>> res) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            LinkedList<Integer> layer = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();

                if ((res.size() % 2 == 0)) {
                    layer.addFirst(node.val);
                } else {
                    layer.addLast(node.val);
                }

                if (null != node.left) queue.offer(node.left);
                if (null != node.right) queue.offer(node.right);
                size--;
            }
            res.add(layer);
        }
    }


    public static String bfsSearch(TreeNode init) {
        return toArray(init).toString();
    }

    private static List<Integer> bfeTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (null != node.left) queue.offer(node.left);
            if (null != node.right) queue.offer(node.right);
        }

        return res;
    }


    public static List<Integer> toArray(TreeNode init) {
        ArrayList<Integer> result = new ArrayList<>();
        if (null == init) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(init);

        while (queue.size() > 0) {
            TreeNode root = queue.poll();
            result.add(root.val);
            if (null != root.left) queue.offer(root.left);
            if (null != root.right) queue.offer(root.right);
        }

        return result;
    }
}

