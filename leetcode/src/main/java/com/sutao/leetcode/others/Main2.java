package com.sutao.leetcode.others;

import java.util.LinkedList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
//        System.out.println(addBinary("1010", "1011"));

        System.out.println(addToArrayForm(new int[] {0}, 10000));
    }



    public static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int inc = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            if (k == 0 && inc == 0) {
                res.addFirst(num[i]);
                continue;
            }
            num[i] = num[i] + k % 10 + inc;
            k = k / 10;
            inc = num[i] / 10;
            res.addFirst(num[i] % 10);
        }

        while(k != 0) {
            int p = k % 10 + inc;
            inc = p / 10;
            k = k / 10;
            res.addFirst(p % 10);
        }

        if(inc == 1)  res.addFirst(1);
        return res;
    }

    public static String addBinary(String a, String b) {
        if (a.equals("0")) return b;
        if (b.equals("0")) return a;
        int delta = 0;
        int tail = 0;
        boolean aLong = false;
        if (a.length() > b.length()) {
            delta = a.length() - b.length();
            tail = b.length();
            aLong = true;
        } else {
            delta = b.length() - a.length();
            tail = a.length();
        }

        int inc = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = tail - 1; i >= 0; i--) {
            int res = a.charAt(aLong ? i + delta : i) + b.charAt(aLong ? i : delta + i) - '0' - '0' + inc;
            inc = res / 2;
            sb.append(res % 2);
        }

        if (a.length() == b.length()) {

        } else if (aLong) {
            for (int i = delta - 1; i >= 0; i--) {
                int res = a.charAt(i) - '0' + inc;
                inc = res / 2;
                sb.append(res % 2);
            }
        } else {
            for (int i = delta - 1; i >= 0; i--) {
                int res = b.charAt(i) - '0' + inc;
                inc = res / 2;
                sb.append(res % 2);
            }
        }

        if (inc == 1) sb.append("1");
        return sb.reverse().toString();
    }
}
