package no;

import java.util.LinkedList;
import java.util.Queue;

public class 큐를이용한스택구현 {

  private final Queue<Integer> values = new LinkedList<>();

  public void push(int x) {
    values.add(x);
    for (int i = 1; i < values.size(); i++) {
      values.add(values.remove());
    }
  }

  public int pop() {
    return values.remove();
  }

  public int top() {
    return values.peek();
  }

  public boolean empty() {
    return values.isEmpty();
  }
}
