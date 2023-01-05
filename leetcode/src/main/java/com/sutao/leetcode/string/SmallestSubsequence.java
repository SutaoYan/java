package com.sutao.leetcode.string;

import java.util.Stack;


public class SmallestSubsequence {

    public static void main(String[] args) {
        System.out.println(removeDuplicate("bcabc"));
        System.out.println(removeDuplicate("bcac"));
        System.out.println(removeDuplicate("cbacdcbc"));
    }

    private static String removeDuplicate(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[256];
        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : s.toCharArray()) {
            count[c]--;

            if (inStack[c]) continue;

            while (!stack.empty() && c < stack.peek() && count[stack.peek()] > 0) {
                inStack[stack.pop()] = false;
            }

            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


}
