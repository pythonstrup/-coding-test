package com.code.no;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class 문자열정렬하기2 {
  public String solution(String my_string) {
    String str = my_string.toLowerCase();
    String[] answer = str.split("");
    Arrays.sort(answer);
    return String.join("", answer);

  }

  public String charSolution(String my_string) {
    // char[]는 new String을 통해 문자열로 만들 수 있다.
    char[] c = my_string.toLowerCase().toCharArray();
    Arrays.sort(c);
    return new String(c);
  }

  public String streamSolution(String my_string) {
    // stream
    return Arrays.stream(my_string.toLowerCase(Locale.ROOT).split("")).sorted().collect(Collectors.joining());
  }
}
