package com.sutao.leetcode.array;

public class RecursionTraversal {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        recursionTraversal(array, 0);
    }

    private static void recursionTraversal(int[] nums, int i) {
        if (i == nums.length) return;
        System.out.println("start from " + nums[i]);
        recursionTraversal(nums, i + 1);
        System.out.println("end from " + nums[i]);
    }
}
