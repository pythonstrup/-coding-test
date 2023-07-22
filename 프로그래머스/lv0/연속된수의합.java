package no;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 연속된수의합 {

  // 2.62 ~ 13ms
  public int[] solution(int num, int total) {
    for (int i = -num; i <= total; i++) {

      List<Integer> list = new ArrayList<>();

      for (int j = i; j < i+num; j++) {
        list.add(j);
      }

      int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
      if (Arrays.stream(answer).sum() == total) {
        return answer;
      }
    }
    return null;
  }

  // 0.1 ~ 0.3 ms
  public int[] solution3(int num, int total) {
    int[] answer = new int[num];
    int start = (total/num) - ((num - 1)/2);

    for(int i = 0; i < num; i++) {
      answer[i] = start;
      start++;
    }

    return answer;
  }

  // 0.02ms
  public int[] solution2(int num, int total) {
    int[] answer = new int[num];
    int check = num*(num+1) / 2;
    int start = (total - check) / num + 1;
    for (int i = 0; i < answer.length; i++) {
      answer[i] = start + i ;
    }
    return answer;
  }
}
