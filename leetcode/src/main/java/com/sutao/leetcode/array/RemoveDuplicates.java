package com.sutao.leetcode.array;

//https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
//https://labuladong.github.io/algo/2/20/23/
//O(N)
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(removeDuplicates(new int[] {1,1,2}));
        System.out.println(removeDuplicates(new int[]{0}));
    }

    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }

        for (int j = 0; j <= i; j++) {
            System.out.print(nums[j]);
            System.out.print(",");

        }
        System.out.println();
        return i + 1;
    }
}
