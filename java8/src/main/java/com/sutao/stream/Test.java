package com.sutao.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		Stream<List<Integer>> inputStream = Stream.of(
			Arrays.asList(1),
			Arrays.asList(2, 3),
			Arrays.asList(4, 5, 6)
		);

		ArrayList input = (ArrayList) inputStream.collect(Collectors.toList());

		input.forEach(System.out::print);
		inputStream = input.stream();

		Stream<Integer> outputStream = inputStream.
			flatMap((childList) -> childList.stream());

		outputStream.collect(Collectors.toList()).forEach(System.out::print);

	}
}
