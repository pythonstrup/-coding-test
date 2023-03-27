// 내 답안
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Math.abs(n-a) == Math.abs(n-b) ? b - a: Math.abs(n-a) - Math.abs(n-b);
            }
        };

        List<Integer> list = Arrays.stream(numlist).boxed().collect(Collectors.toList());
        Collections.sort(list, comparator);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 다른 사람 답안
// 왜인지 모르겠지만 내 답안이 효율성이 더 좋다. (stream의 sorted의 성능이 별로 안 좋은걸까?)
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numList, int n) {
        return Arrays.stream(numList)
                .boxed()
                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}