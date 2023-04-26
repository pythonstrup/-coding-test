package com.code.no;

public class 저주의숫자 {
  public int solution(int n) {
    int answer = n;
    int i = 1;
    while (n != 0) {
      if (i % 3 == 0) answer += 1;
      else if (Integer.toString(i).contains("3")) answer += 1;
      else n -=1;
      i += 1;
    }

    return answer;
  }

  public int solution2(int n) {
    int answer = 0;

    for (int i = 1; i <= n; i++) {
      answer++;
      if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
        i--;
      }
    }

    return answer;
  }

  // ㅎㅍ좌
  public int solution3(int n) {
    int answer = 0;

    for (int i = 0; i < n; i++) {
      answer++;
      while (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
        answer++;
      }
    }
    return answer;
  }
}
