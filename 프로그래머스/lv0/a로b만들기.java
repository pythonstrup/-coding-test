package no;

import java.util.*;

public class a로b만들기 {

  // 0.1ms~1.8ms
  public int solution(String before, String after) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c: before.toCharArray()) {
      if (map.get(c) == null) {
        map.put(c, 1);
        continue;
      }
      map.put(c, map.get(c) + 1);
    }

    for (char c: after.toCharArray()) {
      if (map.get(c) == null || map.get(c) < 1) {
        return 0;
      }

      map.put(c, map.get(c)-1);
    }

    return 1;
  }

  // 쉽게 푼 방식, 심지어 속도도 더 빠름
  // 0.1~1.0ms
  public int solution2(String before, String after) {
    char[] a = before.toCharArray();
    char[] b = after.toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);

    return new String(a).equals(new String(b)) ? 1 :0;
  }
}
