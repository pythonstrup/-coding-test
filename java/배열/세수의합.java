package no;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 세수의합 {

  public List<List<Integer>> bruteForceSolution(int[] nums) {
    List<List<Integer>> results = new LinkedList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      for (int j = 0; j < nums.length; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }

        for (int k = 0; k < nums.length; k++) {
          if (k > j + 1 && nums[k] == nums[k - 1]) {
            continue;
          }
          if (nums[i] + nums[j] + nums[k] == 0) {
            results.add(Arrays.asList(nums[i], nums[j], nums[k]));
          }
        }
      }
    }
    return results;
  }

  public List<List<Integer>> twoPointerSolution(int[] nums) {
    int left, right, sum;
    List<List<Integer>> results = new LinkedList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i-1]) {
        continue;
      }

      left = i + 1;
      right = nums.length - 1;
      while (left < right) {
        sum = nums[i] + nums[left] + nums[right];
        if (sum < 0) {
          left++;
        } else if (sum > 0) {
          right--;
        } else {
          results.add(Arrays.asList(nums[i], nums[left], nums[right]));

          while (left < right && nums[left] == nums[left+1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right+1]) {
            right--;
          }
          left++;
          right--;
        }
      }
    }
    return results;
  }
}
