package com.code;

import java.util.*;
import java.util.stream.Collectors;

public class 배열회전시키기 {
  public int[] solution(int[] numbers, String direction) {
    Deque<Integer> deque = Arrays.stream(numbers).boxed()
        .collect(Collectors.toCollection(ArrayDeque::new));

    if(direction.equals("right")) {
      Integer num = deque.pollLast();
      deque.addFirst(num);
    } else {
      Integer num = deque.poll();
      deque.add(num);
    }

    return deque.stream().mapToInt(Integer::intValue).toArray();
  }
}
