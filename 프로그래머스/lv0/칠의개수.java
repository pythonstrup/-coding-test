package com.code.no;

import java.util.*;
import java.util.stream.Collectors;

public class 칠의개수 {
  public int solution(int[] array) {
    int answer = 0;
    for (int num: array) {
      String temp = Integer.toString(num);
      int before = temp.length();
      answer += before - temp.replace("7", "").length();
    }
    return answer;
  }

  public int streamSolution(int[] array) {
    return (int) Arrays.stream(
            Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining())
                .split("")
        )
        .filter(s -> s.equals("7"))
        .count();
  }

  public int otherSolution(int[] array) {
    int answer = 0;
    for(int a : array){
      while(a != 0){
        if(a % 10 == 7){
          answer++;
        }
        a /= 10;
      }
    }
    return answer;
  }
}
