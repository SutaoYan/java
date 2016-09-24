package com.sutao.lambdasstream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdasDemo {
    public static void main(String[] args) {
        Stream.of(3,1,4,1,5,9)
                .forEach(n -> System.out.println(n));

        Consumer<Integer> printer = n -> System.out.println(n);
        Stream.of(3,1,4,1,5,9)
                .forEach(printer);

        System.out.println();

        Predicate<Integer> mod3 = n -> n % 3 == 0;
        Stream.of(3,1,4,1,5,9)
                .filter(mod3)
                .forEach(printer);

        System.out.println();
        Function<Integer, Integer> doubler = n -> n * 2;
        Stream.of(3,1,4,1,5,9)
                .map(doubler)
                .filter(mod3)
                .forEach(printer);
    }
}
