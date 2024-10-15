package commit;

import java.util.*;

public class LetterCombinationOfAPhoneNumber {
  Map<Character, List<Character>> keypad =
      Map.of(
          '2', List.of('a', 'b', 'c'),
          '3', List.of('d', 'e', 'f'),
          '4', List.of('g', 'h', 'i'),
          '5', List.of('j', 'k', 'l'),
          '6', List.of('m', 'n', 'o'),
          '7', List.of('p', 'q', 'r', 's'),
          '8', List.of('t', 'u', 'v'),
          '9', List.of('w', 'x', 'y', 'z'));

  public static void main(String[] args) {
    LetterCombinationOfAPhoneNumber letterCombinationOfAPhoneNumber = new LetterCombinationOfAPhoneNumber();
    List<String> strings = letterCombinationOfAPhoneNumber.letterCombinations("23");
    System.out.println(strings);
  }

  public List<String> letterCombinations(String digits) {
    List<String> answer = new ArrayList<>();
    dfs(digits, 0, new StringBuilder(), answer);
    return answer;
  }

  private void dfs(String digits, int index, StringBuilder path, List<String> answer) {
    if (path.length() == digits.length()) {
      answer.add(path.toString());
      return;
    }
    for (Character c: keypad.get(digits.charAt(index))) {
      dfs(digits, index + 1, new StringBuilder(path).append(c), answer);
    }
  }
}
