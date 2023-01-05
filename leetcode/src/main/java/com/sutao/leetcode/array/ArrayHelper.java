package com.sutao.leetcode.array;

public class ArrayHelper {

    public static String toString(int[] numbers) {
        if (null == numbers) return "";
        StringBuilder sb = new StringBuilder();
        for (int c : numbers) {
            sb.append(c + " ");
        }

        return sb.toString();
    }
}
