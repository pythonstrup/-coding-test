package com.code;

public class 소인수분해 {

  public static int main(String[] args) {
    String s = "1 2 Z 3";
    int answer = 0;
    int z = 0;
    for (String c: s.split(" ")) {
      if (c.equals("Z")) {
        answer -= z;
      } else {
        int num = Integer.parseInt(c);
        answer += num;
        z = num;
      }
    }
    return answer;
  }
}