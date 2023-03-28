package com.code;

public class 가까운수 {

  public static int main(String[] args) {
    int[] array = {3, 10, 28};
    int n = 20;
    int answer = -1000;
    for (int i: array) {
      if (Math.abs(n - answer) == Math.abs(n - i) && answer > i) {
        answer = i;
      } else if(Math.abs(n - answer) > Math.abs(n - i)) {
        answer = i;
      }
    }
    return answer;

    // stream - 다른 풀이
//    return Math.min(
//        array[Arrays.stream(array).map(operand -> Math.abs(n - operand)).boxed().collect(Collectors.toList()).indexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))],
//        array[Arrays.stream(array).map(operand -> Math.abs(n - operand)).boxed().collect(Collectors.toList()).lastIndexOf(Arrays.stream(array).map(operand -> Math.abs(n - operand)).min().orElse(0))]
//    );
  }
}