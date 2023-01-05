package com.sutao.leetcode.string;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//https://labuladong.github.io/algo/2/20/27/
//https://leetcode.cn/problems/permutation-in-string/
public class PermutationInString {


    private static boolean isInclusive(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();

        for (Character c : s1.toCharArray()) {
            int count = need.getOrDefault(c, 0);
            need.put(c, count + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        HashMap<Character, Integer> window = new HashMap<>();

        while (right < s2.length()) {

            char c = s2.charAt(right++);
            int count = window.getOrDefault(c, 0);
            window.put(c, count + 1);
            if (count + 1 == need.getOrDefault(c, 0)) {
                valid++;
            }

            while (valid == need.size()) {

                if (right - left == s1.length()) {
                    return true;
                }

                char d = s2.charAt(left);
                count = window.getOrDefault(d, 0);
                window.put(d, count - 1);

                if (count == need.getOrDefault(d, 0)) {
                    valid--;
                }

                left++;
            }
        }

        return false;
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int count = needs.getOrDefault(s1.charAt(i), 0);
            needs.put(s1.charAt(i), ++count);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                int windowsCount = window.getOrDefault(c, 0);
                window.put(c, ++windowsCount);
                int needCount = needs.getOrDefault(c, 0);
                if (needCount == windowsCount) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (needs.size() == valid) return true;
                char d = s2.charAt(left);

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

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
        System.out.println();

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("test");

    }

}
