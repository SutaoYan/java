package com.sutao.leetcode.others;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumDeletion {
    // Function to find the minimum count of
    // characters required to be deleted to make
    // frequencies of all characters unique
    static int minCntCharDeletionsfrequency(int[] A) {

        HashMap<Integer, Integer> mp =
                new HashMap<>();

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((x, y) ->
                        Integer.compare(y, x));

        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (mp.containsKey(A[i])) {
                mp.put(A[i], mp.get(A[i]) + 1);
            } else {
                mp.put(A[i], 1);
            }
        }

        for (Map.Entry<Integer,
                Integer> it :
                mp.entrySet()) {
            pq.add(it.getValue());
        }

        while (!pq.isEmpty()) {
            int frequent = pq.poll();
            if (pq.isEmpty()) {
                return count;
            }

            // If frequent and topmost
            // element of pq are equal
            if (frequent == pq.peek()) {
                // If frequency of the topmost
                // element is greater than 1
                if (frequent > 1) {
                    // Insert the decremented
                    // value of frequent
                    pq.add(frequent - 1);
                }
                count++;
            }
        }

        return count;
    }

    // Driver Code
    public static void main(String[] args) {
        //1
        System.out.println(minCntCharDeletionsfrequency(new int[]{1, 1, 1, 2, 2, 2}));
        //2
        System.out.println(minCntCharDeletionsfrequency(new int[]{5, 3, 3, 2, 5, 2, 3, 2}));
        //4
        System.out.println(minCntCharDeletionsfrequency(new int[]{127, 15, 3, 8, 10}));
        //4
        System.out.println(minCntCharDeletionsfrequency(new int[]{100, 100, 5, 5, 5, 2, 2, 2, 0, 0}));
    }
}
