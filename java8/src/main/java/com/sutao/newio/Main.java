package com.sutao.newio;

import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println((int) 'a');
        System.out.println((int) 'A');
        System.out.println(new Main().isAlienSorted(new String[] {"hello","hello"}, "abcdefghijklmnopqrstuvwxyz"));
        System.in.read();
    }

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        int i = 0;
        for(char c : order.toCharArray()) {
            orderMap.put(c, i++);
        }

        for(int j = 0; j < words.length -1; j++) {
            if(compare(words[j], words[j+1], 0, orderMap) > 0) return false;
        }

        return true;
    }

    private int compare(String s1, String s2, int index, HashMap<Character, Integer> orderMap) {
        if(s1.length()> index && s2.length() <=index) return 1;
        else if(s1.length() <=index && s2.length()>index) return -1;
        else if(s1.length() == index && s2.length() == index) return 0;

        int comp = orderMap.get(s1.charAt(index)) - orderMap.get(s2.charAt(index));
        if(0 == comp) {
            return compare(s1, s2, index + 1, orderMap);
        }else return comp;
    }
}
