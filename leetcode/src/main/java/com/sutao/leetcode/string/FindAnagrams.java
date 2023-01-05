package com.sutao.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.cn/problems/find-all-anagrams-in-a-string/
//https://labuladong.github.io/algo/2/20/27/
public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            int count = needs.getOrDefault(p.charAt(i), 0);
            needs.put(p.charAt(i), ++count);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                int windowsCount = window.getOrDefault(c, 0);
                window.put(c, ++windowsCount);
                int needCount = needs.getOrDefault(c, 0);
                if (needCount == windowsCount) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (needs.size() == valid) {
                    res.add(left);
                }

                char d = s.charAt(left);

                if (needs.containsKey(d)) {
                    int needCount = needs.getOrDefault(d, 0);
                    int windowsCount = window.getOrDefault(d, 0);
                    if (needCount == windowsCount) {
                        valid--;
                    }
                    window.put(d, --windowsCount);
                }
                left++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
