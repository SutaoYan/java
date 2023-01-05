package com.sutao.leetcode.graph;

import java.util.HashMap;

public class DeepClone {
    private HashMap<Graph, Graph> map = new HashMap<>();

    public Graph deepCone(Graph node) {
        return dfs(node);
    }

    private Graph dfs(Graph node) {
        if (null == node) return null;

        if (map.containsKey(node)) return map.get(node);
        Graph newNode = new Graph(node.val + 10);
        map.put(node, newNode);
        for (Graph neighbor : node.neighbors) {
            if (map.containsKey(neighbor)) {
                newNode.neighbors.add(map.get(neighbor));
            } else {
                newNode.neighbors.add(dfs(neighbor));
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        Graph node1 = new Graph(1);
        Graph node2 = new Graph(2);
        Graph node3 = new Graph(3);
        Graph node4 = new Graph(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        node4.neighbors.add(node1);
        System.out.println(new DeepClone().deepCone(node1));
    }
}
