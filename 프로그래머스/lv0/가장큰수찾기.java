package com.code.commit;

public class 가장큰수찾기 {
  public int[] solution(int[] array) {
    int[] answer = new int[2];
    answer[0] = -1;
    answer[1] = -1;
    for (int i = 0; i < array.length; i++) {
      if (answer[0] < array[i]) {
        answer[0] = array[i];
        answer[1] = i;
      }
    }
    return answer;
  }
}
