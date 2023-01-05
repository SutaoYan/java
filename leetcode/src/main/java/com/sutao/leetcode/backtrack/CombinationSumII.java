package com.sutao.leetcode.backtrack;

//https://leetcode.cn/problems/combination-sum-ii/
//https://labuladong.github.io/algo/4/31/107/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, target, 0, track);
        return res;
    }

    private void backtrack(int[] candidates, int target, int pos, LinkedList<Integer> track) {
        if (target == 0) {
            res.add(new LinkedList(track));
        } else if (target < 0) {
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) continue;
            if (i > pos && candidates[i] == candidates[i - 1]) continue;
            track.addLast(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
