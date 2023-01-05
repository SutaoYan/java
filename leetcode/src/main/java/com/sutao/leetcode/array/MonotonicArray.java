package com.sutao.leetcode.array;

public class MonotonicArray {

    public boolean isMonotonic(int[] nums) {
        int i = 1;
        Boolean inc = null;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            if (null == inc) {
                inc = nums[i] > nums[i - 1];
            } else if (inc != nums[i] > nums[i - 1]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MonotonicArray().isMonotonic(new int[]{6, 5, 4, 4}));

        System.out.println(new MonotonicArray().isMonotonic(new int[]{1, 3, 2}));
    }
}
