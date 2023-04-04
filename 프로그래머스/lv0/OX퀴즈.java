package com.code.no;
import java.util.*;

public class OX퀴즈 {
  public String[] solution(String[] quiz) {
    List<String> answer = new ArrayList<>();
    for (String q: quiz) {
      String[] list = q.split(" ");
      int num1 = Integer.parseInt(list[0]);
      int num2 = Integer.parseInt(list[2]);
      int num3 = Integer.parseInt(list[4]);
      if (calculator(list[1], num1, num2) == num3) {
        answer.add("O");
      } else {
        answer.add("X");
      }
    }
    return answer.stream().toArray(String[]::new);

    // stream 풀이
//    return Arrays.stream(quiz).map(s -> {
//      String[] arr = s.trim().split(" ");
//      return arr[1].equals("+") && Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) || Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) ? "O" : "X";
//    }).toArray(String[]::new);

    // 삼항연산자 적절히 사용
//    for(int i=0; i<quiz.length; i++){
//      String[] text = quiz[i].split(" ");
//      int result = Integer.parseInt(text[0]) + ( Integer.parseInt(text[2]) * ( text[1].equals("+") ? 1:-1) );
//      quiz[i] = result == Integer.parseInt(text[4])? "O": "X";
//    }
//    return quiz;
  }

  private static int calculator(String op, int num1, int num2) {
    switch (op) {
      case "+":
        return num1 + num2;
      case "-":
        return num1 - num2;
      default:
        return 0;
    }
  }
}
