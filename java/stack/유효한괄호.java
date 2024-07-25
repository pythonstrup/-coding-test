package no;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class 유효한괄호 {

  public boolean solution(String str) {
    Deque<Character> stack = new ArrayDeque<>();
    Map<Character, Character> brackets = Map.of(
        ')', '(',
        '}', '{',
        ']', '[');

    for (Character c: str.toCharArray()) {
      if (!brackets.containsKey(c)) {
        stack.push(c);
        continue;
      } else if (stack.isEmpty() || !stack.peek().equals(brackets.get(c))) {
        return false;
      }
      stack.pop();
    }
    return stack.isEmpty();
  }
}
