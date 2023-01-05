package com.sutao.leetcode.others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HasCycle {
    private boolean cycled = false;

    public boolean hasCycle(int[] A, int[] B) {
        List<Integer>[] graph = buildGraph(A, B);
        LinkedList<Integer> onPath = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            graphTraversal(graph, i, onPath);
        }
        return cycled;
    }

    private List<Integer>[] buildGraph(int[] A, int[] B) {
        List<Integer>[] graph = new ArrayList[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            if (graph[A[i]] == null) {
                graph[A[i]] = new ArrayList<>();
            }
            graph[A[i]].add(B[i]);
        }
        return graph;
    }

    public void graphTraversal(List<Integer>[] graph, int root, LinkedList<Integer> onPath) {

        if (null == graph[root] || onPath.contains(root) || cycled) {
            if (onPath.size() == graph.length - 1) cycled = true;
//            System.out.println("has cycle");
            return;
        }
        onPath.addLast(root);
        for (int i = 0; i < graph[root].size(); i++) {
            graphTraversal(graph, graph[root].get(i), onPath);
        }

        onPath.removeLast();
    }

    public static void main(String[] args) {
        System.out.println(new HasCycle().hasCycle(new int[]{3, 1, 2}, new int[]{2, 3, 1}));
        System.out.println(new HasCycle().hasCycle(new int[]{1, 2, 1}, new int[]{2, 3, 3}));
        System.out.println(new HasCycle().hasCycle(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 4}));
        System.out.println(new HasCycle().hasCycle(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3}));
        System.out.println(new HasCycle().hasCycle(new int[]{1, 2, 2, 3, 3}, new int[]{2, 3, 3, 4, 5}));
    }
}
