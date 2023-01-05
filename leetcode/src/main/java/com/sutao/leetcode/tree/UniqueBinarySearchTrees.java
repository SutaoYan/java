package com.sutao.leetcode.tree;

//https://leetcode.cn/problems/unique-binary-search-trees/

public class UniqueBinarySearchTrees {


    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        int count = buildTree(n, dp);
        System.out.println(count);
        return count;
    }

    private int buildTree(int len, int[] dp) {
        if (len == 0 || len ==1) {
            return 1;
        }

        if(dp[len] != 0) return dp[len];

        int sum = 0;
        for (int i = 1; i <= len; i++) {
            int m = buildTree(i - 1 , dp);
            int n = buildTree(len - i, dp);
            sum += m * n;
        }
        dp[len] = sum;
        return sum;
    }

    public static void main(String[] args) {
        new UniqueBinarySearchTrees().numTrees(10);
    }
}
