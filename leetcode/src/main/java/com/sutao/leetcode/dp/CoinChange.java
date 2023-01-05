package com.sutao.leetcode.dp;

//https://leetcode.cn/problems/coin-change/
//https://labuladong.github.io/algo/3/25/69/

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        memo[0] = 0;
        return dp(coins, amount, memo);
    }

    int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    private int dp(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        else if (amount < 0) return -1;

        if (memo[amount] != -666) return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subProblem = dp(coins, amount - coins[i], memo);
            if (-1 == subProblem) continue;
            res = Math.min(subProblem + 1, res);
        }

        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
    }
}
