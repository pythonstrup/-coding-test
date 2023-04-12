package com.code.no;

public class 다항식더하기 {
  public String solution(String polynomial) {
    int x = 0;
    int constant = 0;
    for (String word: polynomial.split(" ")) {
      if (word.contains("x")) {
        word = word.replace("x", "");
        x += Integer.parseInt(word.equals("") ? "1": word);
      } else if(!word.equals("+")) {
        constant += Integer.parseInt(word);
      }
    }
    String answer = "";
    if (x != 0) {
      answer += x == 1 ? "x": x + "x";
      if (constant > 0 ) answer += " + ";
    }
    if (constant != 0) {
      answer += Integer.toString(constant);
    }

    return answer.equals("") ? "0": answer;
  }
}
