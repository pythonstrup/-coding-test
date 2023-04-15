package com.code.no;

public class 외계어사전 {
  public int solution(String[] spell, String[] dic) {

    int answer = 2;
    for (String d: dic) {
      if(this.containsAllStrings(spell, d)) {
        answer = 1;
      }
    }

    return answer;
  }

  public boolean containsAllStrings(String[] spell, String str) {
    for (String s: spell) {
      if (!str.contains(s)) {
        return false;
      }
    }

    return true;
  }
}
