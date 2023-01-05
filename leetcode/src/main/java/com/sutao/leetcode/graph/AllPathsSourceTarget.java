package com.sutao.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.cn/problems/all-paths-from-source-to-target/

public class AllPathsSourceTarget {

    private static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        ArrayList<Integer>[] test = new ArrayList[4];
        for(int i = 0; null != test[0] && i <  test[0].size(); i++) {

        }
        traverse(graph, 0, path);

        return res;
    }

    private static void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        //traverse neighborhood
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        path.removeLast();
    }

}
