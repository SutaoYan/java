package com.sutao.sort;

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
        int[] array = new int[]{106, 9, 58, 74, 6, 5, 43, 3, 21, 1};

        System.out.println(Util.toString(new MergeSort().mergeSort(array, 0, array.length - 1)));
    }

//    public static List<Integer> mergeSort(List<Integer> origin) {
//        if (origin.size() < 2) return origin;
//        return merge(
//                mergeSort(origin.subList(0, origin.size() / 2)),
//                mergeSort(origin.subList(origin.size() / 2, origin.size()))/

//        );
//
//    }

//    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
//        List<Integer> result = new ArrayList<Integer>();
//        int leftIndex = 0, rightIndex = 0;
//
//        while (leftIndex < left.size() && rightIndex < right.size()) {
//            if (left.get(leftIndex) <= right.get(rightIndex)) {
//                result.add(left.get(leftIndex));
//                leftIndex++;
//            } else {
//                result.add(right.get(rightIndex));
//                rightIndex++;
//            }
//        }
//
//        if (leftIndex < left.size()) result.addAll(left.subList(leftIndex, left.size()));
//        if (rightIndex < right.size()) result.addAll(right.subList(rightIndex, right.size()));
//
//        return result;
//    }


    public int[] mergeSort(int[] array, int start, int end) {
        if (start >= end) return new int[]{array[start]};

        return merge(mergeSort(array, start, start + (end - start) / 2),
                mergeSort(array, start + (end - start) / 2 + 1, end));
    }

    int[] merge(int[] a, int[] b) {
        if (null == a) return b;
        else if (null == b) return a;

        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        int i = 0;
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] < b[bIndex]) result[i++] = a[aIndex++];
            else result[i++] = b[bIndex++];
        }

        if (aIndex == a.length) {
            while (bIndex < b.length) result[i++] = b[bIndex++];
        } else {
            while (aIndex < a.length) result[i++] = a[aIndex++];
        }

        return result;
    }
}
