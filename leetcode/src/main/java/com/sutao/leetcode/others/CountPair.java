package com.sutao.leetcode.others;

public class CountPair {

    // function to Count pairs in an array whose
    // absolute difference is divisible by k
    static int countPair(int arr[], int k) {

        // initialize the count
        int cnt = 0;

        // making every element of arr in
        // range 0 to k - 1
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] + k) % k;
        }

        // create an array hash[]
        int hash[] = new int[k];

        // store to count of element of arr
        // in hash[]
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        int max = 0;
        // count the pair whose absolute
        // difference is divisible by k
        for (int i = 0; i < k; i++) {
//            cnt += (hash[i] * (hash[i] - 1)) / 2;
            max = Math.max(hash[i], max);
        }

        // print the value of count
        System.out.print(max + "\n");
        return max;
    }

    // Driver Code
    public static void main(String[] args) {
        // input array
        int arr[] = {1, 2, 3, 4, 6};
        int k = 2;

        // calculate the size of array
        int n = arr.length;
        countPair(arr, k);

        countPair(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3);

        countPair(new int[] {7, 1, 11, 8, 4, 10}, 8);
    }
}
