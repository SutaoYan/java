package com.sutao.leetcode.array;
//https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
//https://labuladong.github.io/algo/2/20/23/
//O(n)
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(ArrayHelper.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));

        System.out.println(ArrayHelper.toString(twoSum(new int[]{2,3,4}, 6)));

        System.out.println(ArrayHelper.toString(twoSum(new int[]{-1,0}, -1)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        for (; left <= right; ) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }
}
