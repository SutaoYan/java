package com.sutao.leetcode.string;

//https://labuladong.github.io/algo/2/20/26/
//https://leetcode.cn/problems/reverse-words-in-a-string/

public class ReverseWordsInAString {

    public static String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String temp = words[right];
            words[right] = words[left];
            words[left] = temp;
            left++;
            right--;
        }

        return String.join(" ", words);
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));

        System.out.println(reverseWords("  hello world  "));

        System.out.println(reverseWords("a good   example"));
    }
}
