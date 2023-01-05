package com.sutao.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HasCycle {

    public static void main(String[] args) {
        LinkedList<Integer> onPath = new LinkedList<>();
        /*
        V[1] = [2, 3]
        V[2] = [3]
        V[3] = [4]
        V[4] = [1]
         */

        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 2));
        graph.add(Arrays.asList(2));
        graph.add(Arrays.asList(3));
        graph.add(Arrays.asList(4));
        graph.add(Arrays.asList());
//        graph.add(Arrays.asList(0));
        boolean hasCycle = false;
        for(int i = 0; !hasCycle && i < graph.size(); i++) {
            hasCycle = hasCycle(graph, i, onPath);
        }

        System.out.println(hasCycle);
    }

    private static boolean hasCycle(List<List<Integer>> graph, int root, LinkedList<Integer> onPath) {
        if(onPath.contains(root)) return true;
        boolean hasCycle = false;

        onPath.addLast(root);
        for(int val : graph.get(root)) {
            hasCycle = hasCycle(graph, val, onPath);
            if(hasCycle) break;
        }
        onPath.removeLast();

        return hasCycle;
    }

    public static void graphTraversal(List<List<Integer>> graph, int root, LinkedList<Integer> onPath) {

        if (onPath.contains(root)) {
            System.out.println("has cycle");
            return;
        }
        onPath.addLast(root);
        for (int i = 0; i < graph.get(root).size(); i++) {
            graphTraversal(graph, graph.get(root).get(i), onPath);
        }

        onPath.removeLast();
    }
}
