package com.sutao.leetcode.string;

//https://leetcode.cn/problems/reverse-words-in-a-string-iii/

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i ++) {
            if (' ' == s.charAt(i)) {
                for(int j = i - 1; j>=0 && s.charAt(j) != ' '; j--) {
                    sb.append(s.charAt(j));
                }
                 sb.append(' ');
            }else if (i == s.length() - 1) {
                for(int j = i; j>=0 && s.charAt(j) != ' '; j--) {
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
