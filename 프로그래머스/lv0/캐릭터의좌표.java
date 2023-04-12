package com.code.no;

public class 캐릭터의좌표 {
  public int[] solution(String[] keyinput, int[] board) {
    int[] range = {(board[0] - 1) / 2, (board[1] - 1) / 2};
    int[] answer = {0, 0};

    for (String order: keyinput) {
      switch (order) {
        case "left":
          answer[0] = Math.abs(answer[0] - 1) > range[0] ? -range[0]: answer[0]-1;
          break;
        case "right":
          answer[0] = answer[0]+1 > range[0] ? range[0]: answer[0]+1;
          break;
        case "up":
          answer[1] = answer[1]+1 > range[1] ? range[1]: answer[1]+1;
          break;
        case "down":
          answer[1] = Math.abs(answer[1]-1) > range[1] ? -range[1]: answer[1]-1;
          break;
      }
    }


    return answer;
  }
}
