package com.sutao.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int val;
    public List<Graph> neighbors;

    public Graph(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("val=" + val + ";");
        return sb.toString();
    }
}
