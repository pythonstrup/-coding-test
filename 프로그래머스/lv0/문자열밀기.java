package no;

public class 문자열밀기 {

  public static void main(String[] args) {
    System.out.println(solution("hello", "ohell"));
  }

  // 0.02 ~ 1.81 ms
  static public int solution(String A, String B) {
    int length = A.length();
    for (int i = 0; i < length; i++) {
      if (A.equals(B)) {
        return i;
      }

      A = A.substring(length-1, length) +  A.substring(0, length-1);
    }

    return -1;
  }

  // 0.01~0.02ms
  public int solution2(String A, String B) {
    String tempB = B.repeat(2);
    return tempB.indexOf(A);
  }
}
