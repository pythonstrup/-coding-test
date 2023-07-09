package no;

import java.util.Arrays;

public class 겹치는선분의길이 {

  public int solution(int[][] lines) {
    int answer = 0;

    int[] line = new int[200];
    Arrays.fill(line, 0);

    Arrays.stream(lines).forEach(l -> {
      for (int i = l[0]; i < l[1]; i++) {
        line[i + 100] += 1;
      }
    });

    for (int number: line) {
      answer += number > 1 ? 1: 0;
    }

    return answer;
  }
}
