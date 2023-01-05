package com.sutao.leetcode.graph;

//https://leetcode.cn/problems/number-of-provinces/submissions/
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {

        boolean[] nums = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!nums[i]) {
                traverse(isConnected, i, nums);
                count++;
            }
        }
        return count;
    }

    private void traverse(int[][] isConnected, int index, boolean[] nums) {

        for (int i = 0; i < isConnected[index].length; i++) {
            if (nums[i] || isConnected[index][i] == 0) continue;
            nums[i] = true;
            traverse(isConnected, i, nums);
        }
    }

    public static void main(String[] args) {

        int count = new NumberOfProvinces().findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}});
        System.out.println(count);

    }
}
