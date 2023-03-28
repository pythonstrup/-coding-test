package com.code;

import java.util.HashMap;
import java.util.Map;

public class 중복된문자제거 {

  public static String main(String[] args) {
    String my_string = "people";
    String answer = "";
    Map<String, Integer> map = new HashMap<>();
    for (String s: my_string.split("")) {
      if (map.get(s) == null) {
        map.put(s, 1);
        answer += s;
      }
    }
    return answer;

    // 다른 풀이
//    return my_string.chars()
//        .mapToObj(Character::toString)
//        .distinct()
//        .collect(Collectors.joining());
  }
}