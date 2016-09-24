package com.sutao.lambdasstream;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        Stream.of(3,1,4,1,5,9)
                .forEach(n-> System.out.println(n));
        System.out.println();
        Stream.of(3,1,4,1,5,9)
                .forEach(System.out::println);
        System.out.println();
        Consumer<Integer> printer = System.out::println;
        Stream.of(3,1,4,1,5,9)
                .forEach(printer);
    }
}
