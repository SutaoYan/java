package com.sutao.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.cn/problems/combinations/
//https://labuladong.github.io/algo/4/31/107/
public class Combinations {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    private void backtrack(int n, int k, int pos, LinkedList<Integer> track) {
        if (k == track.size()) {
            res.add(new LinkedList(track));
        }

        for (int i = pos; i <= n; i++) {
            track.addLast(i);
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }

    }
}
