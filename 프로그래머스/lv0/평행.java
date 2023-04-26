package com.code.no;

public class 평행 {
  public int solution(int[][] dots) {
    int answer = 0;
    for (int i = 1; i < 4; i++) {
      int x1 = dots[0][0] - dots[i][0];
      int y1 = dots[0][1] - dots[i][1];
      int x2 = dots[3-i][0] - dots[(5-i)%4][0];
      int y2 = dots[3-i][1] - dots[(5-i)%4][1];


      if (x2*y1 == x1*y2 && Math.abs(x1) == Math.abs(x2) && Math.abs(y1) == Math.abs(y2)) {
        answer = 1;
        break;
      }
    }

    return answer;
  }
}
