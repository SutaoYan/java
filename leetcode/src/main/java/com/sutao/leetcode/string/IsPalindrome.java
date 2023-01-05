package com.sutao.leetcode.string;

//https://labuladong.github.io/algo/2/20/23/
//O(N)
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("helleh"));
        System.out.println(isPalindrome("abac"));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("a"));
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
