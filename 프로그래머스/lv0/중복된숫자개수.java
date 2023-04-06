package com.code.no;

import java.util.*;

public class 중복된숫자개수 {
  public int solution(int[] array, int n) {
    return Collections.frequency(Arrays.asList(Arrays.stream(array).boxed().toArray()), n);
  }

  public int otherSolution(int[] array, int n) {
    int answer = 0;
    for (int num : array) {
      if (num == n) answer++;
    }
    return answer;
  }

  public int streamSolution(int[] array, int n) {
    return (int) Arrays.stream(array).filter(i -> i == n).count();
  }
}
