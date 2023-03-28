package com.code;

import java.util.Arrays;

public class 배열원소의길이 {

  public static int[] main(String[] args) {
    String[] strlist = {"We", "are", "the", "world!"};
    return Arrays.stream(strlist).mapToInt(s -> s.length()).toArray();

    // 아래 방법도 가능!
    // return Arrays.stream(strList).mapToInt(String::length).toArray();
  }
}