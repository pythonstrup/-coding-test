package com.code.no;

import java.util.*;

public class 직사각형의넓이구하기 {
  public int solution(int[][] dots) {
    int[] x = new int[4];
    int[] y = new int[4];
    for (int i = 0; i < 4; i++) {
      x[i] = dots[i][0];
      y[i] = dots[i][1];
    }

    Arrays.sort(x);
    Arrays.sort(y);
    return (x[3]-x[0]) * (y[3]-y[0]);
  }
}
