package com.code.commit;
import java.util.*;

public class 배열의유사도 {
  public int solution(String[] s1, String[] s2) {
    int answer = 0;
    Map<String, Integer> map = new HashMap<>();
    for (String s: s1) {
      map.put(s, 1);
    }

    for (String s: s2) {
      if (map.get(s) != null) answer += 1;
    }

    return answer;
  }
}
