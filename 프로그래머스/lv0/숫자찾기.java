package com.code.no;

public class 숫자찾기 {
  public int solution(int num, int k) {
    int answer = -1;
    int index = 1;
    for (String s: Integer.toString(num).split("")) {
      int i = Integer.parseInt(s);
      if (i == k) {
        answer = index;
        break;
      }
      index += 1;
    }
    return answer;

    // 다른 사람 풀이 - indexOf 사용
//    return ("-" + num).indexOf(String.valueOf(k));
  }
}
