package com.code.no;

public class 자릿수더하기 {
  public int solution(int n) {
    int answer = 0;
    for (String num: Integer.toString(n).split("")) {
      answer += Integer.parseInt(num);
    }
    return answer;

    // stream
//    return Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
  }
}
