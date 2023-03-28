package com.code;

import java.util.Arrays;

public class 삼각형의완성조건1 {

  public static int main(String[] args) {
    int[] sides = {1, 2, 3};
    Arrays.sort(sides);
    return sides[0] + sides[1] <= sides[2] ? 2: 1;
  }
}