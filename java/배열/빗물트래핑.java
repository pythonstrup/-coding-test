package no;

import java.util.ArrayDeque;
import java.util.Deque;

public class 빗물트래핑 {

  // 브루트 포스를 사용하면 O(n^2)의 시간복잡도가 나올 것이다.
  // 투 포인터를 사용하면 O(n)의 시간복잡도로 해결 가능하다.
  public static int solutionTwoPointer(int[] height) {
    int volume = 0;
    int left = 0;
    int right = height.length - 1;
    int leftMax = height[left];
    int rightMax = height[right];

    while (left < right) {
      leftMax = Math.max(height[left], leftMax);
      rightMax = Math.max((height[right]), rightMax);

      if (leftMax <= rightMax) {
        volume += leftMax - height[left];
        leftMax += 1;
      } else {
        volume += rightMax - height[right];
        rightMax -= 1;
      }
    }

    return volume;
  }

  // 스택을 사용해도 O(n)으로 해결가능하다.
  public static int solutionStack(int[] height) {
    Deque<Integer> stack = new ArrayDeque<>();
    int volume = 0;

    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
        Integer top = stack.pop();

        if (stack.isEmpty()) {
          break;
        }

        int distance = i - stack.peek() - 1;
        int waters = Math.min(height[i], height[stack.peek()]) - height[top];

        volume += distance * waters;
      }
      stack.push(i);
    }
    return volume;
  }
}
