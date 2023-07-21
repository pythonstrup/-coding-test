package no;

public class k의개수 {

  public static void main(String[] args) {
    System.out.println(solution(1, 13, 1));
  }

  // 1ms ~ 68ms
  public static int solution(int i, int j, int k) {
    int answer = 0;
    char keyword = (char) (k + '0');
    for (int p = i; p <= j; p++) {
      String temp = Integer.toString(p);
      long count = temp.chars().filter(c -> c == keyword).count();
      answer += count;
    }
    return answer;
  }

  // 다른 사람 풀이
  // 10ms ~ 4999ms
  public int solution2(int i, int j, int k) {
    String str = "";
    for(int a = i; a <= j; a++) {
      str += a+"";
    }

    return str.length() - str.replace(k+"", "").length();
  }
}
