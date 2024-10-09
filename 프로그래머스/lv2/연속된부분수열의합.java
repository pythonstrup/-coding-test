package no;

import java.util.ArrayList;
import java.util.List;

public class 연속된부분수열의합 {

  // 투 포인터
  // 성공: 최대 15ms
  public int[] solution(int[] sequence, int k) {
    int[] answer = new int[2];
    int sum = 0;
    int start = 0, end = 0;
    int length = Integer.MAX_VALUE;
    for (; start < sequence.length; start++) {
      while (sum < k && end < sequence.length) {
        sum += sequence[end];
        end += 1;
      }
      if (sum == k && length > end - start) {
        length = end - start;
        answer[0] = start;
        answer[1] = end - 1;
      }
      sum -= sequence[start];
    }
    return answer;
  }

  // brute force 시간 초과
  public int[] failSolution(int[] sequence, int k) {
    List<Integer> answer = new ArrayList<>();
    for (int i = 0; i < sequence.length; i++) {
      int result = 0;
      int length = 0;
      for (int j = i; j < sequence.length; j++) {
        result += sequence[j];
        length++;
        if (result == k) {
          if (answer.isEmpty()) {
            answer.add(i);
            answer.add(j);
          } else if (answer.get(1) - answer.get(0) >= length) {
            answer.clear();
            answer.add(i);
            answer.add(j);
          }
          break;
        }
        if (result > k) {
          break;
        }
      }
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}
