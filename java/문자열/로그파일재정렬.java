package no;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 로그파일재정렬 {

  // 내 풀이
  public static String[] solution(String[] logs) {
    List<String> letters = new ArrayList<>();
    List<String> digits = new ArrayList<>();

    for (String log: logs) {
      if (Character.isDigit(log.split(" ")[1].charAt(0))) {
        digits.add(log);
        continue;
      }
      letters.add(log);
    }

    StringComparator comparator = new StringComparator();
    letters = letters.stream().sorted(comparator).collect(Collectors.toList());
    letters.addAll(digits);
    return letters.toArray(new String[letters.size()]);
  }

  private static class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      List<String> a = Arrays.asList(o1.split(" "));
      List<String> b = Arrays.asList(o2.split(" "));
      int compared = String.join(" ", a.subList(1, a.size() - 1))
          .compareTo(String.join(" ", b.subList(1, b.size() - 1)));
      return compared != 0? compared: a.get(0).compareTo(b.get(0));
    }
  }

  // 모범답안
  public static String[] reorderLogFiles(String[] logs) {
    List<String> letterList = new ArrayList<>();
    List<String> digitList = new ArrayList<>();

    for (String log: logs) {
      if (Character.isDigit(log.split(" ")[1].charAt(0))) {
        digitList.add(log);
      } else {
        letterList.add(log);
      }
    }

    letterList.sort((s1, s2) -> {
      // todo. split을 사용해 원하는만큼만 쪼갤 수도 있다.
      String[] s1x = s1.split(" ", 2);
      String[] s2x = s2.split(" ", 2);

      int compared = s1x[1].compareTo(s2x[1]);
      if (compared == 0) {
        return s1x[0].compareTo(s2x[0]);
      } else {
        return compared;
      }
    });

    letterList.addAll(digitList);
    return letterList.toArray(new String[0]);
  }
}
