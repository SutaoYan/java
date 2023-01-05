package com.sutao.leetcode.others;

import java.util.HashMap;

public class MinimumSubString {

    public static void main(String[] args) {
        System.out.println(new MinimumSubString().minimumSubString("abaaba"));
        System.out.println(new MinimumSubString().minimumSubString("zyzyzyz"));
        System.out.println(new MinimumSubString().minimumSubString("aabbbabaaa"));
    }

    private int minimumSubString(String s) {
        if (null == s || s.isEmpty()) return 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                int count = hashMap.getOrDefault(sub, 0);
                hashMap.put(sub, ++count);
            }
        }
        for (String item : hashMap.keySet()) {
            if (1 == hashMap.get(item)) {
                min = Math.min(min, item.length());
            }
        }
        return min;
    }
}
