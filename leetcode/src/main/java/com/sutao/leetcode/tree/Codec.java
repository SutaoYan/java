package com.sutao.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;

//https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class Codec {
    private StringBuilder res = new StringBuilder();

    // 把一棵二叉树序列化成字符串
    public String serialize(TreeNode root) {
        if (null == root) return "#";

        traverse(root);
        return res.substring(0, res.length() - 1);
    }

    public void traverse(TreeNode treeNode) {
        if (null == treeNode) {
            res.append("#").append(",");
            return;
        }

        res.append(treeNode.val).append(",");
        traverse(treeNode.left);
        traverse(treeNode.right);
    }

    // 把字符串反序列化成二叉树
    public TreeNode deserialize(String data) {
        if (null == data || data.length() < 1) return null;

        String[] nodes = data.split(",");
        LinkedList<String> nodesList = new LinkedList<>();
        for (String node : nodes) {
            nodesList.addLast(node);
        }
        return deserialize(nodesList);
    }

    public TreeNode deserialize(LinkedList<String> nodesList) {
        String nodeVal = nodesList.peekFirst();
        if (null == nodeVal) return null;
        nodesList.removeFirst();
        if ("#".equals(nodeVal)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(nodeVal));
        node.left = deserialize(nodesList);
        node.right = deserialize(nodesList);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(Arrays.asList(1, 2, 3, null, null, 4, 5), 0);
        String serialize = new Codec().serialize(root);

        System.out.println(serialize);

        System.out.println(BFS.bfsSearch(new Codec().deserialize(serialize)));
    }
}
