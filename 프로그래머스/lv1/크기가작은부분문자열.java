package no;

public class 크기가작은부분문자열 {
  public int solution(String t, String p) {
    int answer = 0;
    int targetLength = p.length();
    for (int i = 0; i < t.length()-targetLength+1; i++) {
      String temp = t.substring(i, i+targetLength);
      answer += compareNumber(temp, p);
    }

    return answer;
  }

  private long compareNumber(String splitStr, String target) {
    if (Long.parseLong(splitStr) <= Long.parseLong(target)) {
      return 1;
    }
    return 0;
  }
}
