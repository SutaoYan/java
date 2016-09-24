package com.sutao.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 时间复杂度 （平均） 时间复杂度（最坏） 时间复杂度（最好） 空间复杂度 稳定性
// O(nlog2N)             O(nlog2N)      O(nlog2N)       O(n)      Y
public class MergeSort {
    static List<Integer> LIST = Stream.of(2, 8, 5, 9, 3, 6, 1, 10, 7, 4).collect(Collectors.toList());
//    static List<Integer> LIST = Stream.of(1,2,3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
//    static List<Integer> LIST = Stream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).collect(Collectors.toList());

    public static void main(String[] args) {
        mergeSort(LIST);
    }

    public static List<Integer> mergeSort(List<Integer> origin) {
        if (origin.size() <2) return origin;
        return merge(
                mergeSort(origin.subList(0, origin.size()/2)),
                mergeSort(origin.subList(origin.size()/2, origin.size()))
        );

    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<Integer>();
        int leftIndex = 0, rightIndex = 0;

        while ( leftIndex < left.size() &&rightIndex <right.size() ) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                result.add(left.get(leftIndex));
                leftIndex++;
            }else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        if (leftIndex < left.size()) result.addAll(left.subList(leftIndex, left.size()));
        if (rightIndex < right.size()) result.addAll(right.subList(rightIndex, right.size()));

        System.out.println();
        result.forEach((x) -> {
            System.out.print(x + " " );
        });

        return result;
    }

}
