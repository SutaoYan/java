package com.sutao.leetcode.string;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        int left = 0;
        int right = 0;
        int dest = 0;

        while (right < haystack.length()) {

            while (right< haystack.length() && dest < needle.length() && haystack.charAt(right) == needle.charAt(dest)) {
                right++;
                dest++;
            }

            if (right - left == needle.length()) {
                return left;
            }

            left++;
            right = left;
            dest = 0;
        }
        return -1;
    }


    public static void main(String[] args) {
//        System.out.println(new FindTheIndexOfTheFirstOccurrenceInAString().strStr("sadbutsad", "sad"));
//        System.out.println(new FindTheIndexOfTheFirstOccurrenceInAString().strStr("leetcode", "leeto"));
        System.out.println(new FindTheIndexOfTheFirstOccurrenceInAString().strStr("hello", "ll"));
//        System.out.println(new FindTheIndexOfTheFirstOccurrenceInAString().strStr("aaa", "aaaa"));
        System.out.println(new FindTheIndexOfTheFirstOccurrenceInAString().strStr("mississippi", "issipi"));
    }
}
