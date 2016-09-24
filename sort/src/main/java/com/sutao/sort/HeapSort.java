package com.sutao.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 时间复杂度 （平均） 时间复杂度（最坏） 时间复杂度（最好） 空间复杂度 稳定性
// O(nlog2N)             O(nlog2N)      O(nlog2N)       O(1)      N
public class HeapSort {
//    static List<Integer> LIST = Stream.of(2, 8, 5, 9, 3, 6, 1, 10, 7, 4).collect(Collectors.toList());
    static List<Integer> LIST = Stream.of(1,2,3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
//    static List<Integer> LIST = Stream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).collect(Collectors.toList());
    private static int count = 0;
    public static void main(String[] args) {
        new HeapSort().heapSort(LIST);
        LIST.forEach((x) -> {
            System.out.print(x + " " );
        });
        System.out.println("\n"+count);
    }

    private void buildMaxHeap(List<Integer> list, int len) {
        for (int i = len/2; i >= 0; i--) {
            heapify(list, i, list.size());
        }
    }

    private void heapify(List<Integer> list, int i, int len) {
        int left = 2 * i + 1,
                right = 2 * i + 2,
                largest = i;

        if (left < len && list.get(left) > list.get(largest)) {
            largest = left;
        }

        if (right < len && list.get(right) > list.get(largest)) {
            largest = right;
        }
        count++;
        if (largest != i) {
            Util.swap(list, i, largest);
            heapify(list, largest, len);
        }
    }

    private void heapSort(List<Integer> list) {
        buildMaxHeap(list, list.size());
        count = 0;
        int len = list.size();
        for (int i = len - 1; i > 0; i--) {
            Util.swap(list, i, 0);
            len --;
            heapify(list, 0, len);
        }
    }
}
