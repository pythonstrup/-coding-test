package no;

import java.util.*;

public class 더맵게 {

  public int solution(int[] scoville, int k) {
    Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    for (int i = 0; i < scoville.length; i++) {
      queue.add(scoville[i]);
    }

    int answer = 0;
    while (queue.size() >= 2) {
      int first = queue.poll();
      int second = queue.poll();
      if (first >= k) {
        return answer;
      }
      int score = calculateScore(first,second);
      queue.add(score);
      answer++;
    }

    int result = queue.poll();
    return result >= k? answer: -1;
  }

  private int calculateScore(int first, int second) {
    return first + (second * 2);
  }
}
