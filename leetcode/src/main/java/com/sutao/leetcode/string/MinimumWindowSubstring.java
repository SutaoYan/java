package com.sutao.leetcode.string;

import java.util.HashMap;

//https://labuladong.github.io/algo/2/20/27/
//https://leetcode.cn/problems/minimum-window-substring/
//O(N)
public class MinimumWindowSubstring {

    private static String minWindow(String s, String t) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            int needCount = needs.getOrDefault(t.charAt(i), 0);
            needs.put(t.charAt(i), ++needCount);
        }
        int left = 0, right = 0;
        while (right < s.length()) {
            int needsCount = needs.getOrDefault(s.charAt(right), 0);
            //如果是需要的字符，放进窗口
            //如果窗口里该字符数量和需要的数量相等，那满足条件的字符加1
            if (needsCount > 0) {
                int windowCount = window.getOrDefault(s.charAt(right), 0);
                window.put(s.charAt(right), ++windowCount);
                if (windowCount == needsCount) {
                    valid++;
                }
            }
            right++;
            //如果需要字符串个数和满足条件的个数相等
            //缩小窗口
            while (needs.size() == valid) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //如果窗口包含移除的字符
                //窗口中该字符数量减1
                //如果减1前窗口中数量和需要的数量相同，那满足条件的字串减1
                if (window.containsKey(s.charAt(left))) {
                    int windowCount = window.getOrDefault(s.charAt(left), 0);
                    if (windowCount == needs.getOrDefault(s.charAt(left), 0)) {
                        valid--;
                    }
                    window.put(s.charAt(left), --windowCount);
                }
                left++;
            }
        }

        return len < Integer.MAX_VALUE ? s.substring(start, start + len) : "";
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
