package com.sutao.leetcode.array;

//https://leetcode.cn/problems/corporate-flight-bookings/
//https://labuladong.github.io/algo/2/20/25/
public class CorpFlightBookings {

    int[] diff;

    public CorpFlightBookings(int[] nums) {
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


    private static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        CorpFlightBookings rangeAddition = new CorpFlightBookings(nums);
        for (int i = 0; i < bookings.length; i++) {
            rangeAddition.add(bookings[i][0] -1, bookings[i][1] -1, bookings[i][2]);
        }
        int[] res = rangeAddition.result();
        System.out.println(ArrayHelper.toString(res));
        return res;
    }

    public static void main(String[] args) {
        corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
    }
}
