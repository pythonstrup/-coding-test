package no;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 등수매기기 {

  // 5ms~10ms 정도 걸림
  public int[] solution(int[][] score) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> avgList = Arrays.stream(score)
        .map(array -> Arrays.stream(array).sum())
        .collect(Collectors.toList());
    List<Integer> sortedList = avgList.stream()
        .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    for (int i = 0; i < sortedList.size(); i++) {
      if (map.get(sortedList.get(i)) == null) {
        map.put(sortedList.get(i), i+1);
      }
    }

    return avgList.stream()
        .mapToInt(s -> map.get(s))
        .toArray();
  }

  // 0.3ms
  public int[] solution2(int[][] score) {
    List<Integer> scoreList = new ArrayList<>();
    for(int[] t : score){
      scoreList.add(t[0] + t[1]);
    }
    scoreList.sort(Comparator.reverseOrder());

    int[] answer = new int[score.length];
    for(int i=0; i<score.length; i++){
      answer[i] = scoreList.indexOf(score[i][0] + score[i][1])+1;
    }
    return answer;
  }

  // 3~4ms
  public int[] solution3(int[][] score) {
    int[] answer = new int[score.length];
    List<Integer> avgList = Arrays.stream(score)
        .map(array -> Arrays.stream(array).sum())
        .collect(Collectors.toList());
    List<Integer> sortedList = avgList.stream()
        .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    for(int i = 0; i < sortedList.size(); i++) {
      answer[i] = sortedList.indexOf(avgList.get(i))+1;
    }

    return answer;
  }

  // 1~3ms => 스트림이 느리긴하다..
  public int[] solution4(int[][] score) {
    int[] answer = new int[score.length];
    List<Integer> avgList = Arrays.stream(score)
        .map(array -> Arrays.stream(array).sum())
        .collect(Collectors.toList());
    avgList.sort(Comparator.reverseOrder());
    for(int i = 0; i < avgList.size(); i++) {
      answer[i] = avgList.indexOf(score[i][0]+ score[i][1])+1;
    }

    return answer;
  }

  // 7~15ms - 더 오래 걸리긴 하지만 한 줄 코드
  public int[] solution5(int[][] score) {

    return Arrays.stream(score)
        .map(ints -> Arrays.stream(ints)
            .average().orElse(0))
        .mapToInt(d -> Arrays.stream(score)
            .map(ints -> Arrays.stream(ints)
                .average().orElse(0))
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList())
            .indexOf(d) + 1)
        .toArray();
  }
}
