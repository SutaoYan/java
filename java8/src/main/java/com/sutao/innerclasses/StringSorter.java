package com.sutao.innerclasses;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringSorter {
    private List<String> strings;

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public List<String> naturalSort() {
        Collections.sort(strings);
        int[] a = new int[1] ;
        Arrays.sort(a);
        return strings;
    }

    public List<String> naturalSortWithStreams() {
        return strings.stream().sorted().collect(Collectors.toList());
    }

    public List<String> lengthSort() {
        Collections.sort(strings, (o1, o2) -> o1.length() - o2.length());
        return strings;
    }

    public List<String> lengthSortWithStreams() {
        return strings.stream().sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
                .collect(Collectors.toList());
    }
}
