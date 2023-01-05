package com.sutao.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReplaceQuestionMark {

    public static void main(String[] args) {
//        replaceQuestionMark("??????", 0);

        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    private static String replaceQuestionMark(String pattern, int index) {

        System.out.println(pattern);
        if (index == pattern.length()) {
            return pattern;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pattern.substring(0, index) + "a" + pattern.substring(index + 1));
        replaceQuestionMark(sb.toString(), index + 1);

        return pattern;
    }

    private static List<LinkedList<Integer>> res = new ArrayList<>();

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }

        helper(nums, 0, new LinkedList<>(), result);
        return result;
    }

    private static void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new LinkedList<>(subset));
        } else if (index < nums.length) {

            helper(nums, index + 1, subset, result);
            subset.add(nums[index]);
            helper(nums, index + 1, subset, result);
            subset.removeLast();
        }
    }
}
