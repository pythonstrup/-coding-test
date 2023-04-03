package com.code.commit;

public class 문자열계산하기 {

  public int solution(String my_string) {
    int answer = 0;
    String[] list = my_string.split("\\+");
    for (String s : list) {
      String[] temp = s.split("\\-");
      answer += Integer.parseInt(temp[0].trim());
      for (int j = 1; j < temp.length; j++) {
        answer -= Integer.parseInt(temp[j].trim());
      }
    }
    return answer;

    // 다른 사람 풀이
//    return Arrays.stream(myString.replaceAll("- ", "-").replaceAll("[+] ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
  }
}
