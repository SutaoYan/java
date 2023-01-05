package com.sutao.leetcode.string;

//https://leetcode.cn/problems/repeated-substring-pattern/?plan=programming-skills&plan_progress=s5lrat5
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                boolean match = true;
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
//        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("aba"));
//        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc"));

        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("babbabbabbabbab"));
    }
}
