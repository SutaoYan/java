package com.sutao.leetcode.others;

import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static int countGroups(int[] A) {
        if (A.length < 2) return A.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= A[i - 1]) stack.push(i);
            for (int j = i; j > 0 && A[j] < A[j - 1]; j--) {
                swap(A, j, j - 1);
                if (j <= stack.peek()) stack.pop();
            }
        }
        return stack.size();
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int countSlice(int[] A) {
        int currMax = 0;
        LinkedList<Integer> maxStack = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > currMax) {
                maxStack.push(currMax);
                currMax = A[i];
            } else if (A[i] > maxStack.peek() && A[i] < currMax) {
                currMax = Math.max(currMax, A[i]);
            } else if (A[i] < maxStack.peek()) {
                while (!maxStack.isEmpty() && A[i] < maxStack.peek()) {
                    int pre = maxStack.pop();
                    currMax = Math.max(currMax, pre);
                }
            }
        }

        return maxStack.size();

    }


    public static int coins(int[] A) {

        int head = 0, tail = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                if (A[i] == 1) head++;
                if (A[i] == 0) tail++;
            } else {
                if (A[i] == 0) head++;
                if (A[i] == 1) tail++;
            }
        }
        return Math.min(head, tail);
    }


    public static int binaryString(String s) {
        int index = 0;
        for (; index < s.length(); index++) {
            if (s.charAt(index) != '0') break;
        }

        int count = 0;
        for (int i = s.length() - 1; i >= index; i--) {
            char c = s.charAt(i);
            if (c == '1') count += 2;
            else {
                count++;
            }
        }

        return count - 1;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 6, 5, 9, 7};
        int n = arr.length;


        System.out.println(countGroups(new int[] {2, 4, 1, 6, 5, 9, 7}));
        System.out.println(countSlice(new int[] {2, 4, 1, 6, 5, 9, 7}));

        System.out.println(countGroups(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(countSlice(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}));

        System.out.println(countGroups(new int[] {1, 43, 2, 5, 6, 9, 8, 7}));
        System.out.println(countSlice(new int[] {1, 43, 2, 5, 6, 9, 8, 7}));

        System.out.println(countGroups(new int[] {9, 2, 3, 4, 5, 6, 7, 1, 8}));
        System.out.println(countSlice(new int[] {9, 2, 3, 4, 5, 6, 7, 1, 8}));

        System.out.println(countGroups(new int[] {3, 2, 7, 4, 5, 6, 1, 8, 9}));
        System.out.println(countSlice(new int[] {3, 2, 7, 4, 5, 6, 1, 8, 9}));

//        System.out.println(coins(new int[]{0, 1, 0}));

//        System.out.println(binaryString("011100"));

//        System.out.println(binaryString("111"));

//        System.out.println(binaryString("1111010101111"));
    }

}
