package com.sutao.sort;

import java.util.List;

public class Util {

  public static void swap(List<Integer> list, int a, int b ) {
    int tmp = list.get(a);
    list.set(a, list.get(b));
    list.set(b, tmp);
  }

  public static void insertSwap(List<Integer> list, int pos, int index) {
    assert (index > pos && pos > 0);
    int value = list.get(index);
    for (int i = index; i > pos; i--) {
      list.set(i, list.get(i-1));
    }
    list.set(pos, value);
  }

  public static int findMax(List<Integer> list) {
    assert(list.size() > 0);
    int max = list.stream().max((x, y) -> x.compareTo(y)).get();
    return max;
  }

  public static String toString(int[] numbers) {
    if (null == numbers) return "";
    StringBuilder sb = new StringBuilder();
    for (int c : numbers) {
      sb.append(c + " ");
    }

    return sb.toString();
  }
}
