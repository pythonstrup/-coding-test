package com.code.no;

public class 안전지대 {
  public int solution(int[][] board) {
    int[] x = {-1, -1, -1, 1, 1, 1, 0, 0, 0};
    int[] y = {1, 0, -1, 1, 0, -1, 1, -1, 0};
    int n = board.length;
    int answer = n * n;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        for (int k = 0; k < 9; k++) {
          int nx = i + x[k];
          int ny = j + y[k];
          if (nx < 0 || n <= nx || ny < 0 || n <= ny) continue;
          if (board[nx][ny] == 1) {
            answer -= 1;
            break;
          }

        }

    return answer;
  }


}
