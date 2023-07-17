package no;

public class 유한소수판별하기 {

  public int mySolution(int a, int b) {
    int gcd = gcd(a, b);
    b /= gcd;

    while (b % 2 == 0 || b % 5 == 0) {
      if (b % 2 == 0) {
        b /= 2;
      }

      if (b % 5 == 0) {
        b /= 5;
      }
    }

    return b == 1 ? 1: 2;
  }

  public int shortestSolution(int a, int b) {
    // int answer = ((a*1000)%b == 0) ? 1 : 2; // 잘못된 풀이 => 512(2^9), 625(5^4)을 체크하지 않음
    int answer = ((a*320000)%b == 0) ? 1 : 2;
    return answer;
  }

  private int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
