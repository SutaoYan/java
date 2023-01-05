package com.sutao.leetcode.array;

//https://labuladong.github.io/algo/2/20/25/
public class RangeAddition {
    int[] diff;

    public RangeAddition(int[] nums) {
        if (null == nums || nums.length == 0) return;
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public int[] result() {
        if (null == diff || diff.length == 0) return null;
        int[] nums = new int[diff.length];
        nums[0] = diff[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + diff[i];
        }
        return nums;
    }

    public void add(int i, int j, int inc) {
        diff[i] += inc;
        if (j < diff.length - 1) diff[j + 1] -= inc;
    }

    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        RangeAddition rangeAddition = new RangeAddition(nums);
        for (int i = 0; i < updates.length; i++) {
            rangeAddition.add(updates[i][0], updates[i][1], updates[i][2]);
        }
        int[] res = rangeAddition.result();
        System.out.println(ArrayHelper.toString(res));
        return res;
    }

    public static void main(String[] args) {
        getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
    }
}
