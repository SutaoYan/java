package com.sutao.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 时间复杂度 （平均） 时间复杂度（最坏） 时间复杂度（最好） 空间复杂度 稳定性
// O(n2)             O(n2)            O(n)            O(1)      Y
public class InsertionSort {

  static List<Integer> LIST = Stream.of(2, 8, 5, 9, 3, 6, 1, 10, 7, 4).collect(Collectors.toList());
//  static List<Integer> LIST = Stream.of(1,2,3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
//  static List<Integer> LIST = Stream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).collect(Collectors.toList());
  public static void main(String[] args) {

    List<Integer> list = LIST.stream().collect(Collectors.toList());
    System.out.println("start insertion sort ...");
    list.forEach( x -> System.out.print (" " + x));
    System.out.println();
    int count = 0;

    for(int i = 1; i < list.size(); i++) {
      int preIndex = i - 1;
      int current = list.get(i);
      while ( preIndex >= 0 && list.get(preIndex) > current ) {
        list.set(preIndex+1, list.get(preIndex));
        preIndex--;
        count++;
      }
      list.set(preIndex+1, current);
    }

    System.out.println();
    list.forEach( x -> System.out.print (" " + x));
    System.out.println();

    System.out.println("\n"+count);
  }
}
