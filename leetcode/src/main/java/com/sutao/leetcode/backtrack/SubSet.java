package com.sutao.leetcode.backtrack;

import java.util.LinkedList;

//https://leetcode.cn/problems/subsets/
//https://labuladong.github.io/algo/4/31/107/
public class SubSet {
    private static LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    private static LinkedList<Integer> tracker = new LinkedList<>();

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 2};
//        res.add(new LinkedList<>());
        backTraversal(nums, 0);
        System.out.println(res);
    }

    private static void backTraversal(int nums[], int pos) {

        res.add(new LinkedList<>(tracker));
        for (int i = pos; i < nums.length; i++) {
            tracker.addLast(nums[i]);
            backTraversal(nums, i + 1);
            tracker.removeLast();
        }
    }
}
