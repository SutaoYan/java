package com.sutao.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.cn/problems/permutations-ii
//https://labuladong.github.io/algo/4/31/107/
public class PermutationsII {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, track, used);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {

        if(track.size() == nums.length) {
            res.add(new LinkedList(track));
        }

        int preNum = -66;

        for(int i = 0; i < nums.length; i++) {
            if(used[i] || nums[i] == preNum) continue;
            preNum = nums[i];
            used[i] = true;
            track.addLast(nums[i]);
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
