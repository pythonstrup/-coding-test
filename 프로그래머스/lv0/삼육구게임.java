package com.code;

public class 삼육구게임 {

  public static int main(String[] args) {
    int order = 29423;
    int answer = 0;
    String str = Integer.toString(order);
    for (String c: str.split("")) {
      int num = Integer.parseInt(c);
      if (num != 0 && num % 3 == 0) answer += 1;
    }
    return answer;

    // 스트림 활용
//    return (int) Arrays.stream(String.valueOf(order).split("")).map(Integer::parseInt).filter(i -> i == 3 || i == 6 || i == 9).count();
  }
}