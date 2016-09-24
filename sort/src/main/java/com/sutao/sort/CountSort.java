package com.sutao.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 时间复杂度 （平均） 时间复杂度（最坏） 时间复杂度（最好） 空间复杂度     稳定性
// O(n+k)             O(n+k)            O(n+k)         O(n+k))      Y
public class CountSort {
    //    static List<Integer> LIST = Stream.of(2, 8, 5, 9, 3, 6, 1, 10, 7, 4).collect(Collectors.toList());
    static List<Integer> LIST = Stream.of(1, 2, 2, 3, 4, 5, 6, 4, 7, 8, 6, 9, 10).collect(Collectors.toList());
    //    static List<Integer> LIST = Stream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).collect(Collectors.toList());
    public static void main(String[] args) {
        new CountSort().countSort(LIST);
    }

    private void countSort(List<Integer> list) {
        int maxValue = Util.findMax(list);
        int bucket[] = new int[maxValue + 1];

        list.forEach((x) -> {
            bucket[x]++;
        });
        int index = 0;
        for(int i = 0; i < maxValue + 1; i ++) {
            while(bucket[i]-- > 0 ) {
                list.set(index++, i);
            }
        }

        list.forEach((x) -> {
            System.out.print(x + " " );
        });
    }
}
