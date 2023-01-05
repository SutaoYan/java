package com.sutao.leetcode.string;

//https://leetcode.cn/problems/longest-palindromic-substring/
//https://labuladong.github.io/algo/2/20/23/
//O(n2)
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) break;
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);

            res = s1.length()> res.length() ? s1: res;
            res = s2.length()> res.length() ? s2: res;
        }

        return res;
    }

}
