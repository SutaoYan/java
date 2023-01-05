package com.sutao.leetcode.string;

import java.util.LinkedList;

public class DecodeString {
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("100[leetcode]"));
    }

    public static String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            //if not ], push to stack
            if (s.charAt(i) != ']') stack.addLast(String.valueOf(s.charAt(i)));
            //else parse string in []
            else {
                String tmp = repeatString(stack);
                //push parsed string in stack
                stack.addLast(tmp);
            }
        }
        return getString(stack);
    }

    private static String repeatString(LinkedList<String> stack) {
        LinkedList<String> sb = new LinkedList<>();
        while (!stack.isEmpty()) {
            //check char in top stack
            //if it's [ then just remove
            //if it's number then parse the int
            //if normal char then translate to string
            String c = stack.peekLast();
            if (c.equals("[")) {
                //pop '['
                stack.removeLast();
                continue;
            } else if (c.compareTo("0") >= 0 && c.compareTo("9") <= 0) {
                int num = getDigits(stack);
                String sub = getString(sb);
                while (num > 1) {
                    sb.addLast(sub);
                    num--;
                }
                break;
            } else {
                sb.addFirst(c);
                stack.removeLast();
            }
        }

        return getString(sb);
    }

    private static int getDigits(LinkedList<String> s) {

        StringBuilder tmp = new StringBuilder();
        while (!s.isEmpty()) {
            String c = s.peekLast();
            if (c.compareTo("0") >= 0 && c.compareTo("9") <= 0) {
                c = s.removeLast();
                tmp.insert(0, c);
            } else {
                break;
            }
        }

        return Integer.parseInt(tmp.toString());
    }

    public static String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

}
