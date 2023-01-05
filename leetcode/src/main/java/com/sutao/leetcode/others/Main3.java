package com.sutao.leetcode.others;

import java.util.LinkedList;

public class Main3 {

    public static void main(String[] args) {
        System.out.println(minCost("abccbd", new int[]{0, 1, 2, 3, 4, 5}));
        System.out.println(minCost2("abccbd", new int[]{0, 1, 2, 3, 4, 5}));

        System.out.println(minCost("aabbcc", new int[]{1, 2, 1, 2, 1, 2}));
        System.out.println(minCost2("aabbcc", new int[]{1, 2, 1, 2, 1, 2}));
//
        System.out.println(minCost("aaaa", new int[]{3, 4, 5, 6}));
        System.out.println(minCost2("aaaa", new int[]{3, 4, 5, 6}));
//
        System.out.println(minCost("ababa", new int[]{10, 5, 10, 5, 10}));
        System.out.println(minCost2("ababa", new int[]{10, 5, 10, 5, 10}));

        System.out.println(minCost2("abbbbaba", new int[]{10, 5, 6, 4, 8, 10, 5, 10}));

//        System.out.println(minCost2("ababa", new int[]{10, 5, 10, 5, 10}));
    }


    public static int minCost(String s, int[] c) {
        int totalCost = 0;
        char prev = s.charAt(0);
        int lastCost = c[0];
        int curTotalCost = c[0];

        for (int i = 1; i < s.length(); i++) {
            char d = s.charAt(i);
            int curCost = c[i];
            if (d == prev) {
                lastCost = Math.max(lastCost, curCost);
                curTotalCost += curCost;
            } else {
                totalCost += curTotalCost - lastCost;
                prev = d;
                lastCost = curCost;
                curTotalCost = curCost;
            }
        }
        totalCost += curTotalCost - lastCost;
        return totalCost;
    }


    public static int minCost2(String s, int[] c) {
        int totalCost = 0;
        LinkedList<Integer> leftEquals = new LinkedList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (leftEquals.isEmpty()) {
                    if (c[i] > c[i + 1]) {
                        totalCost += c[i + 1];
                        leftEquals.push(i);
                    } else {
                        totalCost += c[i];
                        leftEquals.push(i + 1);
                    }
                } else {
                    int pos = leftEquals.peek();
                    if (c[pos] > c[i + 1]) {
                        totalCost += c[i + 1];
                    } else if (c[pos] < c[i + 1]) {
                        totalCost += c[pos];
                        leftEquals.pop();
                        leftEquals.push(i + 1);
                    }
                }
            } else {
                leftEquals.clear();
            }
        }

        return totalCost;
    }
}
