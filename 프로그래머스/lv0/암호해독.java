package com.code;

public class 암호해독 {

  public static String main(String[] args) {
    String cipher = "dfjardstddetckdaccccdegk";
    int code = 4;

    String answer = "";
    String[] strlist = cipher.split("");
    int length = cipher.length();
    for (int i = code-1; i < length; i+=code) {
      answer += strlist[i];
    }
    return answer;


    // 다른 풀이
//    String answer = "";
//    for (int i = code; i <= cipher.length(); i = i + code) {
//      answer += cipher.substring(i - 1, i);
//    }
//    return answer;

    // 스트림    
//    return IntStream.range(0, cipher.length())
//        .filter(value -> value % code == code - 1)
//        .mapToObj(c -> String.valueOf(cipher.charAt(c)))
//        .collect(Collectors.joining());
  }
}