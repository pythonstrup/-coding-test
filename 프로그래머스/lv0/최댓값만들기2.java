package com.code.no;

import java.util.Arrays;

public class 최댓값만들기2 {
  public int solution(int[] numbers) {
    Arrays.sort(numbers);
    int ans1 = numbers[0] * numbers[1];
    int ans2 = numbers[numbers.length-2] * numbers[numbers.length-1];
    return ans1 > ans2 ? ans1: ans2;
  }
}
