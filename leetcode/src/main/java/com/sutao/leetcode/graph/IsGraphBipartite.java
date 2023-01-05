package com.sutao.leetcode.graph;

//https://leetcode.cn/problems/is-graph-bipartite/
//https://labuladong.github.io/algo/2/22/52/
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] colors = new boolean[graph.length];
        boolean isBipartite = true;
        for(int i = 0; i < graph.length; i++) {
            isBipartite = traverse(graph, i, true, colors, visited);
            if(!isBipartite) break;
        }

        return isBipartite;
    }

    public boolean traverse(int[][] graph, int i, boolean color, boolean[] colors, boolean[] visited) {
        if (visited[i]) return true;
        visited[i] = true;
        colors[i] = color;
        boolean isBipartite = true;

        for(int v: graph[i]) {
            if(!visited[v]) {
                isBipartite = traverse(graph, v, !color, colors, visited);
                if(!isBipartite) break;
            }else {
                if(colors[v] == color) {
                    isBipartite = false;
                }
            }
        }

        return isBipartite;
    }

    public static void main(String[] args) {
        System.out.println(new IsGraphBipartite().isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(new IsGraphBipartite().isBipartite(new int[][]{{1,2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
    }
}
