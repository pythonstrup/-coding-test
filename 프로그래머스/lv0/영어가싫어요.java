package com.code;

public class 영어가싫어요 {

  public static long main(String[] args) {
    String numbers = "onetwothreefourfivesixseveneightnine";

    String[] strlist = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    int num = 0;
    for (String str: strlist) {
      numbers = numbers.replace(str, Integer.toString(num));
      num += 1;
    }
    return Long.parseLong(numbers);
  }
}