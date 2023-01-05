package com.sutao.leetcode.dp;

//https://leetcode.cn/problems/fibonacci-number/
//https://labuladong.github.io/algo/3/25/69/
public class Fib {
    public int fib(int n) {
        if(0 == n) return 0;
        int[] dp = new int[n +1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int fib2(int n) {
        if (n == 0 || n == 1) {
            // base case
            return n;
        }
        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = dp_i_1 + dp_i_2;
            // 滚动更新
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }

    public static void main(String[] args) {
        assert(new Fib().fib(10)== 55);
        assert(new Fib().fib(4) == 3);
    }
}
