package com.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 컨트롤제트 {

  public static int[] main(String[] args) {
    int n = 12;
    Set<Integer> set = new HashSet<>();
    for (int i = 2; i <= Math.sqrt(n); i++) {
      while (n % i == 0) {
        set.add(i);
        n /= i;
      }
    }
    if (n != 1) set.add(n);

    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);
    return list.stream().mapToInt(i -> i).toArray();
  }
}