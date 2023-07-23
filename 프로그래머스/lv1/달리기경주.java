package no;

import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {

  public static void main(String[] args) {
    String[] players = {"mumu", "soe", "poe", "kai", "mine"};
    String[] callings = {"kai", "kai", "kai", "mine", "mine"};
    System.out.println(solution(players, callings));
  }

  // 0.04 ~ 385ms
  public static String[] solution(String[] players, String[] callings) {
    Map<String, Integer> index = new HashMap<>();
    for (int i = 0; i < players.length; i++) {
      index.put(players[i], i);
    }

    for (String calling : callings) {
      int previous = index.get(calling) - 1;
      int overtaker = index.get(calling);

      index.put(players[overtaker], previous);
      index.put(players[previous], overtaker);

      String temp = players[overtaker];
      players[overtaker] = players[previous];
      players[previous] = temp;
    }

    return players;
  }

  // Length만 미리 선언해놔도 속도가 엄청 빨라진다.
  // 0.03 ~ 287 ms
  public String[] solutionLength(String[] players, String[] callings) {
    Map<String, Integer> index = new HashMap<>();
    int length = players.length;
    for (int i = 0; i < length; i++) {
      index.put(players[i], i);
    }

    for (String calling : callings) {
      int previous = index.get(calling) - 1;
      int overtaker = index.get(calling);

      index.put(players[overtaker], previous);
      index.put(players[previous], overtaker);

      String temp = players[overtaker];
      players[overtaker] = players[previous];
      players[previous] = temp;
    }

    return players;
  }
}
