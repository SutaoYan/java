package com.sutao.innerclasses;

import java.util.Arrays;
import java.util.List;

public class SortStringsDemo {
    public static void main(String[] args) {
        StringSorter ss = new StringSorter();
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        ss.setStrings(strings);
        System.out.println(strings);
        System.out.println("After natural sorting:");
        System.out.println(ss.naturalSort());
        System.out.println("After natural stream sorting:");
        System.out.println(ss.naturalSortWithStreams());
        System.out.println("After length sorting:");
        System.out.println(ss.lengthSort());
        System.out.println("After length stream sorting:");
        System.out.println(ss.lengthSortWithStreams());
    }
}
