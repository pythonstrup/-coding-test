package com.code.no;

import java.util.*;
import java.util.stream.IntStream;

public class 잘라서배열로저장하기 {
  public String[] solution(String my_str, int n) {

    int length = my_str.length();
    String[] strlist = my_str.split("");
    List<String> answer = new ArrayList<>();
    String temp = "";
    for (int i = 0; i < length; i++) {
      temp += strlist[i];
      if ((i + 1) % n == 0) {
        answer.add(temp);
        temp = "";
      } else if (i == length-1) {
        answer.add(temp);
      }
    }
    return answer.stream().toArray(String[]::new);
  }

  public String[] otherSolution(String my_str, int n) {
    int resultCnt = (my_str.length() + n - 1) / n;
    String[] answer = new String[resultCnt];

    for (int i = 0; i < resultCnt; i++) {
      int start = n * i;
      int end = start + n >= my_str.length()? my_str.length(): start + n;
      answer[i] = my_str.substring(start, end);
    }

    return answer;
  }

  public String[] StreamSolution(String myStr, int n) {
    return IntStream.range(0, myStr.length() / n + (myStr.length() % n > 0 ? 1 : 0))
        .mapToObj(i -> i == myStr.length() / n ? myStr.substring(i * n) : myStr.substring(i * n, (i + 1) * n))
        .toArray(String[]::new);
  }
}
