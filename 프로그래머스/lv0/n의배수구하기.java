package com.code.no;

import java.util.ArrayList;
import java.util.List;

public class n의배수구하기 {
  public int[] solution(int n, int[] numlist) {
    List<Integer> answer = new ArrayList<>();
    for (int num: numlist) {
      if (num % n == 0) answer.add(num);
    }
    return answer.stream().mapToInt(i -> i).toArray();

    // 디른 사람 풀이
//    return Arrays.stream(numlist).filter(value -> value % n == 0).toArray();
  }
}
