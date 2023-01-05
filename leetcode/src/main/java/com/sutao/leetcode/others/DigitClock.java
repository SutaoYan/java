package com.sutao.leetcode.others;

import java.util.HashSet;

public class DigitClock {
    private int numberOfInterestingPoints(String s, String t) {
        int count = 0;

        while (!s.equals(t)) {
            if (isInteresting(s)) count++;
            s = step(s);
        }

        if (isInteresting(t)) count++;
        return count;
    }

    private boolean isInteresting(String time) {
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < time.length(); i++) {
            if (':' != time.charAt(i)) set.add(time.charAt(i));
        }

        return set.size() <= 2;
    }


    private String step(String time) {
        //HH:MM:SS
        int second = Integer.valueOf(time.substring(6, 8)) + 1;
        if (second != 60) {
            return time.substring(0, 6) + String.format("%02d", second);
        }

        int min = Integer.valueOf(time.substring(3, 5)) + 1;
        if (min != 60) {
            return time.substring(0, 3) + String.format("%02d", min) + ":00";
        }
        int hour = Integer.valueOf(time.substring(0, 2)) + 1;
        if (hour == 24) {
            return "00:00:00";
        }
        return String.format("%02d", hour) + ":00:00";
    }


    public static void main(String[] args) {

        System.out.println(new DigitClock().numberOfInterestingPoints("15:59:58", "16:00:05"));
        System.out.println(new DigitClock().numberOfInterestingPoints("15:15:00", "15:15:12"));
        System.out.println(new DigitClock().numberOfInterestingPoints("22:22:21", "22:22:23"));
    }

}
