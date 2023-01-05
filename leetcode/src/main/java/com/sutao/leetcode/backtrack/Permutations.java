package com.sutao.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.cn/problems/permutations/
//https://labuladong.github.io/algo/4/31/105/

public class Permutations {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        boolean[] track = new boolean[nums.length];
        LinkedList<Integer> onPath = new LinkedList<>();
        backTrack(nums, track, onPath);
        return ans;
    }

    private void backTrack(int[] nums, boolean[] track, LinkedList<Integer> onPath) {
        for(int i =0 ; i < nums.length; i++) {
            if(!track[i]) {
                track[i] = true;
                onPath.addLast(nums[i]);
                if(onPath.size() < nums.length) {
                    backTrack(nums, track, onPath);
                }else {
                    ans.add(new LinkedList(onPath));
                }

                track[i] = false;
                onPath.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[] {1,2,3}));
    }
}
