package com.sutao.leetcode.dp;

public class MaxSubArray {

    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{-3, 1, 3, -1, 2, -4, 2}));

        System.out.println(maxSubArray(new int[]{-1}));

    }

    private static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = dp[0];
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
