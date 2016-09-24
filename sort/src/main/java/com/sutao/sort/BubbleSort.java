package com.sutao.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 时间复杂度 （平均） 时间复杂度（最坏） 时间复杂度（最好） 空间复杂度 稳定性
// O(n2)             O(n2)            O(n)            O(1)      Y
public class BubbleSort {

  static List<Integer> LIST = Stream.of(2, 8, 5, 9, 3, 6, 1, 10, 7, 4).collect(Collectors.toList());
//  static List<Integer> LIST = Stream.of(1,2,3, 4, 5, 6, 7, 8, 9, 10).collect(Collectors.toList());
//  static List<Integer> LIST = Stream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).collect(Collectors.toList());
  public static void main(String[] args) {
    BubbleSort.bubbleSort1();
    BubbleSort.bubbleSort2();
  }


  public static void bubbleSort1() {

    List<Integer> list = LIST.stream().collect(Collectors.toList());
    System.out.println("start bubble sort 1...");
    list.forEach( x -> System.out.print (" " + x));
    System.out.println();
    boolean changed = true;
    int count = 0;
    for (int i = 0;  i < list.size() - 1 && changed; i++) {
      changed = false;
      for (int j = 0; j< list.size() - i -1; j++) {
        if (list.get(j) > list.get(j+1)) {
          changed = true;
          Util.swap(list, j, j+1);
        }
        count++;
      }
      System.out.println();
      list.forEach( x -> System.out.print (" " + x));
      System.out.println();
    }

//    list.forEach( x -> System.out.print (" " + x));
    System.out.println("\n"+count);
  }

  public static void bubbleSort2() {
    List<Integer> list = LIST.stream().collect(Collectors.toList());
    System.out.println("start bubble sort 2...");
    list.forEach( x -> System.out.print (" " + x));
    System.out.println();
    int count = 0;

    int i, len = list.size();
    boolean changed;
    do {
      changed = false;
      len-=1;
      for (i = 0; i < len; i++) {
        if (list.get(i) > list.get(i + 1)) {
          Util.swap(list, i, i+1);
          changed = true;
        }
        count++;
      }
      System.out.println();
      list.forEach( x -> System.out.print (" " + x));
      System.out.println();
    } while (changed);

    list.forEach( x -> System.out.print (" " + x));
    System.out.println("\n"+count);
  }

}
