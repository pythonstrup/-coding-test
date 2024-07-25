package no;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 중복문자제거 {

  public String solution(String str) {
    List<String> characters = str.chars()
        .mapToObj(e -> (char) e)
        .collect(Collectors.toSet()).stream()
        .sorted(Comparator.comparingInt(a -> a))
        .map(String::valueOf)
        .collect(Collectors.toList());
    return String.join("", characters);
  }
}
