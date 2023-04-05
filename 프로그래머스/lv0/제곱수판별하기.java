package com.code.no;

public class 제곱수판별하기 {
  public int solution(int n) {
    int sqrt = (int) Math.sqrt(n);
    return Math.pow(sqrt, 2) == n ? 1: 2;
  }
}
