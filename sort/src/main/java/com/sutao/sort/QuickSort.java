package com.sutao.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 时间复杂度 （平均） 时间复杂度（最坏） 时间复杂度（最好） 空间复杂度 稳定性
// O(nlog2N)             O(n2)      O(nlog2N)       O(nlog2N)      N
public class QuickSort {
    static List<Integer> LIST = Stream.of(2, 8, 5, 9, 3, 6, 1, 10, 7, 4).collect(Collectors.toList());
//    static List<Integer> LIST = Stream.of(1,2,3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
//    static List<Integer> LIST = Stream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).collect(Collectors.toList());

    public static void main(String[] args) {
        quickSort(LIST, 0, LIST.size()-1);
    }

    public static void quickSort(List<Integer> origin, int first, int last) {
        if (first >= last) return ;
        int key = origin.get(first);
        int end = last;

        while(first < last ) {
            while (last > first && origin.get(last) >= key) last--;
            origin.set(first, origin.get(last));
            while (first < last && origin.get(first)<= key) first++;
            origin.set(last, origin.get(first));
        }
        origin.set(first, key);
        quickSort(origin, 0, first-1);
        quickSort(origin, first+1, end);

        System.out.println();
        origin.forEach((x) -> {
            System.out.print(x + " " );
        });
    }

}
