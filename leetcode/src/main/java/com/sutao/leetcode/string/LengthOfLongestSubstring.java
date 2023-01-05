package com.sutao.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.cn/problems/longest-substring-without-repeating-characters/
//https://labuladong.github.io/algo/2/20/27/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("abcbcab"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("qwwecdq"));
        System.out.println("-------------------");

        System.out.println(lengthOfLongestSubstring2(" "));
        System.out.println(lengthOfLongestSubstring2("abcbcab"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("qwwecdq"));
        System.out.println(lengthOfLongestSubstring2("jbpnbwwd"));
        System.out.println("-------------------");

        System.out.println(length(" "));
        System.out.println(length("abcbcab"));
        System.out.println(length("bbbbb"));
        System.out.println(length("qwwecdq"));
        System.out.println(length("jbpnbwwd"));
    }

    private static int length(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        HashSet<Character> window = new HashSet<>();

        while (right < s.length()) {
            Character c = s.charAt(right);
            while (window.contains(c)) {
                window.remove(s.charAt(left++));
            }
            maxLength = Math.max(maxLength, right - left + 1);
            window.add(c);
            right++;
        }

        return maxLength;
    }


    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> maxSeq = new HashSet<>();
        int count = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (0 != i) {
                maxSeq.remove(s.charAt(i - 1));
            }

            while (right < s.length() && !maxSeq.contains(s.charAt(right))) {
                maxSeq.add(s.charAt(right));
                right++;
            }

            count = Math.max(right - i, count);
        }
        return count;
    }

    public static int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            int count = window.getOrDefault(c, 0);
            window.put(c, ++count);

            while (window.getOrDefault(c, 0) > 1) {
                char d = s.charAt(l);
                int otherCount = window.getOrDefault(d, 0);
                window.put(d, --otherCount);
                l++;
            }

            res = Math.max(res, r - l);
        }

        return res;
    }
}
