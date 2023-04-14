package com.code.no;

import java.util.*;

public class 숨어있는숫자의덧셈2 {
  public int solution(String my_string) {
    int answer = 0;
    String temp = "";
    for (char c: my_string.toCharArray()) {
      if (Character.isDigit(c)) {
        temp += c;
      } else if(!temp.equals("")) {
        answer += Integer.parseInt(temp);
        temp = "";
      }
    }

    if (!temp.equals("")) {
      answer += Integer.parseInt(temp);
    }

    return answer;
  }

  public int solution2(String my_string) {
    int answer = 0;

    String[] str = my_string.replaceAll("[a-zA-Z]", " ").split(" ");

    for(String s : str){
      if(!s.equals("")) answer += Integer.valueOf(s);
    }

    return answer;
  }

  public int streamSolution(String myString) {
    return Arrays.stream(myString.split("[A-Z|a-z]")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).sum();
  }
}
