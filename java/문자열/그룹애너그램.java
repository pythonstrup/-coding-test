package no;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 그룹애너그램 {

  private static final Map<String, List<String>> results = new HashMap<>();

  public static List<List<String>> groupAnagrams(String[] strs) {
    for (String str: strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = String.valueOf(chars);

      if (results.containsKey(key)) {
        results.get(key).add(str);
        continue;
      }
      results.put(key, new ArrayList<>(Arrays.asList(str)));
    }
    return new ArrayList<>(results.values());
  }
}
