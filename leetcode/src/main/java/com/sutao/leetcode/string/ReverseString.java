package com.sutao.leetcode.string;

//https://leetcode.cn/problems/reverse-string/submissions/
//https://labuladong.github.io/algo/2/20/23/
//O(N)
public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(String.valueOf(s));

        s = new char[]{'h', 'e', 'l', 'l'};
        reverseString(s);
        System.out.println(String.valueOf(s));
    }

    private static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char c = s[right];
            s[right] = s[left];
            s[left] = c;
            left++;
            right--;
        }
    }
}
