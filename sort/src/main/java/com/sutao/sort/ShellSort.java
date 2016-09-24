package com.sutao.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 时间复杂度 （平均） 时间复杂度（最坏） 时间复杂度（最好） 空间复杂度 稳定性
// O(n2)             O(n2)            O(n)            O(1)      N
public class ShellSort {

  static List<Integer> LIST = Stream.of(2, 8, 5, 9, 3, 6, 1, 10, 7, 4).collect(Collectors.toList());
  //  static List<Integer> LIST = Stream.of(1,2,3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
//  static List<Integer> LIST = Stream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).collect(Collectors.toList());
  public static void main(String[] args) {
    List<Integer> list = LIST.stream().collect(Collectors.toList());
    System.out.println("start selection sort ...");
    list.forEach( x -> System.out.print (" " + x));
    System.out.println();

    int number = list.size() / 3;
    int i;
    int j;
    int temp;
    while (number >= 1) {
      for (i = number; i < list.size(); i++) {
        temp = list.get(i);
        j = i - number;
        while (j >= 0 && list.get(j) > temp) {
          list.set(j+number, list.get(j));
          j = j - number;
        }
        list.set(j+number, temp);
      }
      number = number / 3;
    }

    list.forEach( x -> System.out.print (" " + x));
    System.out.println();
  }
}
