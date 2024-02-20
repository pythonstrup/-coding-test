package no;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 가장흔한단어 {

  private final HashMap<String, Integer> counter = new HashMap<>();
  private Set<String> banned;

  public String mostCommon(String str, String[] banned) {
    this.banned = new HashSet<>(Arrays.asList(banned));

    String[] words = str.replaceAll("\\W+", " ").toLowerCase().split(" ");
    for (String word: words) {
      if (this.banned.contains(word)) {
        continue;
      }
      this.counter.put(word, counter.getOrDefault(word, 0) + 1);
    }
    return Collections.max(this.counter.entrySet(), Map.Entry.comparingByValue()).getKey();
  }
}
