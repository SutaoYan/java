package com.sutao.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 时间复杂度 （平均） 时间复杂度（最坏） 时间复杂度（最好） 空间复杂度 稳定性
// O(n2)             O(n2)            O(n2)            O(1)      N
public class SelectionSort {
  static List<Integer> LIST = Stream.of(2, 8, 5, 9, 3, 6, 1, 10, 7, 4).collect(Collectors.toList());
//  static List<Integer> LIST = Stream.of(1,2,3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
//  static List<Integer> LIST = Stream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).collect(Collectors.toList());
  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>(LIST);
    System.out.println("start selection sort ...");
    list.forEach( x -> System.out.print (" " + x));
    System.out.println();

    for(int i = 0; i < list.size() -1; i++) {
      int index = i;
      for (int j = i+1; j < list.size(); j++) {
        if (list.get(j) < list.get(index)) {
          index = j;
        }
      }
      if(i !=index) Util.swap(list, i, index);
    }

    System.out.println();
    list.forEach( x -> System.out.print (" " + x));
    System.out.println();
  }
}
