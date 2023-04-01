package com.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 한번만등장한문자 {

  public static String main(String[] args) {
    String s = "abcabcadc";

    Map<String, Integer> map = new HashMap<>();
    for (String c: s.split("")) {
      if (map.get(c) == null) {
        map.put(c, 1);
      } else {
        map.put(c, map.get(c)+1);
      }
    }
    String answer = "";
    for (String c: map.keySet()) {
      if (map.get(c) == 1) {
        answer += c;
      }
    }
    String[] strlist = answer.split("");
    Arrays.sort(strlist);
    return String.join("", strlist);

    // 아스키코드 사용
//    int[] alpha = new int[26];
//    for(char c : s.toCharArray()){
//      alpha[c - 'a']++;
//    }
//
//    StringBuilder answer = new StringBuilder();
//    for(int i = 0; i < 26; i++){
//      if(alpha[i] == 1){
//        answer.append((char)(i + 'a'));
//      }
//    }
//    return answer.toString();
    
    // 스트림 사용
//    return Arrays.stream(s.split(""))
//        .collect(Collectors.groupingBy(s1 -> s1))
//        .entrySet()
//        .stream()
//        .filter(entry -> entry.getValue().size() <= 1)
//        .map(Map.Entry::getKey)
//        .sorted()
//        .collect(Collectors.joining());
  }
}