package com.code.no;

public class 세균증식 {
  public int solution(int n, int t) {
    return n * (int) Math.pow(2, t);

    // 이진수로 푸는 법!!
//    int answer = 0;
//    answer = n << t;
//    return answer;
  }
}
