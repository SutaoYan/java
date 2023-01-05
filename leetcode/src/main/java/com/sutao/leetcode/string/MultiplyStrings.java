package com.sutao.leetcode.string;

//https://leetcode.cn/problems/multiply-strings/?plan=programming-skills&plan_progress=s5lrat5

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p = i + j, q = i + j + 1;
                int sum = mul + res[q];
                res[q] = sum % 10;
                res[p] += sum / 10;
            }
        }

        int i = 0;
        for (; i < res.length; i++) {
            if (res[i] != 0) break;
        }
        StringBuilder sb = new StringBuilder();
        while (i < res.length) {
            sb.append((char) ('0' + res[i++]));
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("20", "45"));
    }
}
