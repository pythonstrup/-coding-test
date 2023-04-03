package com.code.commit;
import java.util.*;

public class 약수구하기 {

  public int[] solution(int n) {
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) list.add(i);
    }
    return list.stream().mapToInt(i -> i).toArray();
  }
}
