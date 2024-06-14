package no;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 두수의합 {

  // 가장 간단한 해결방법
  // 하지만 O(n^2)의 시간복잡도
  public static int[] solutionBruteForce(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i == j) {
          continue;
        }

        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

  // 해시 테이블을 사용하면 성능을 O(n)으로 개선할 수 있다.
  // 하지만 만약 중복되는 숫자가 있다면? 그러면 아래 방식으로는 불가능하다.
  public static int[] solutionHash(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      numsMap.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
        return new int[]{i, numsMap.get(target - nums[i])};
      }
    }

    return null;
  }

  // 투포인터를 사용하면 성능을 O(n)으로 개선할 수 있으나...
  // 사실 이 문제는 투포인터로 풀 수 없다.
  // 투포인터는 주로 정렬된 입력값을 대상으로 하는데, nums가 정렬된 상태가 아니기 때문이다.
  public static int[] solutionTwoPointer(int[] nums, int target) {
    Arrays.sort(nums); // 정렬 로직이 없으면
    int left = 0;
    int right = nums.length - 1;

    while (left != right) {
      if (nums[left] + nums[right] < target) {
        left += 1;
      } else if (nums[left] + nums[right] > target) {
        right -= 1;
      } else
        return new int[]{left, right};
    }
    return null;
  }
}
