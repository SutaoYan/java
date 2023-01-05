package com.sutao.leetcode.string;

public class ShiftingLetters {

    public static void main(String[] args) {
        //jyh
//        System.out.println(shiftingLetters("bad", new int[] {10,20,30}));
        //wqqwlcjnkphhsyvrkdod
        System.out.println(shiftingLetters("mkgfzkkuxownxvfvxasy",
                new int[]{505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326,
                        137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513}));
    }

    public static String shiftingLetters(String s, int[] shifts) {
        int start = (int) 'a';
        int end = (int) 'z';
        long total = 0;
        for (int j = 0; j < shifts.length; j++) {
            total += shifts[j];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int tmp = (int) s.charAt(i);
            if(i > 0) {
                total -=  shifts[i-1];
            }

            long result = (tmp + total) / (end + 1) > 0 ? (tmp + total - start) % 26 + start : tmp + total;
            sb.append((char) result);
        }
        return sb.toString();
    }
}
