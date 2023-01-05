package com.sutao.leetcode.backtrack;

//https://leetcode.cn/problems/combination-sum
//https://labuladong.github.io/algo/4/31/107/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(candidates, track, 0, target);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, int pos, int target) {

        if(0 == target) {
            res.add(new LinkedList(track));
        }else if(target < 0) {
            return;
        }

        for(int i = pos; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, track, i, target - nums[i]);
            track.removeLast();
        }
    }
}
