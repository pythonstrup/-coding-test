package com.code.no;

import com.code.Main;

public class 삼각형의완성조건2 {

  // 0.01~0.06ms
  public int solution(int[] sides) {
    return Math.min(sides[0], sides[1]) + (sides[0]+sides[1]-Math.max(sides[0], sides[1])-1);
  }

  // 나랑 같음
  public int otherSolution(int[] sides) {
    int cnt = 0;
    for (int i = (sides[0]>sides[1]?sides[0]-sides[1]:sides[1]-sides[0])+1; i < sides[0] + sides[1]; i++)  cnt++;
    return cnt;
  }
}
