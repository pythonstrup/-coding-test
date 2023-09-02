package no;

public class 기사단원의무기 {
  // 80ms까지 찍힘
  public int solution(int number, int limit, int power) {
    int answer = 0;
    for (int i = 1; i <= number; i++) {
      int result = divisorCount(i);
      if (result > limit) {
        answer += power;
        continue;
      }
      answer += result;
    }
    return answer;
  }

  private int divisorCount(int number) {
    int count = 0;
    for (int i = 1; i*i <= number; i++) {
      if (i*i == number) count++;
      else if (number % i ==0) count += 2;
    }
    return count;
  }


  // 다른 사람 풀이
  // 최대 10ms
  public int anotherSolution(int number, int limit, int power) {
    int[] count = new int[number + 1];
    for (int i = 1; i <= number; i++) {
      for (int j = 1; j <= number / i; j++) {
        count[i * j]++;
      }
    }
    int answer = 0;
    for (int i = 1; i <= number; i++) {
      if (count[i] > limit) {
        answer += power;
      } else {
        answer += count[i];
      }
    }
    return answer;
  }
}
