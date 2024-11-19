package no;

import java.util.PriorityQueue;
import java.util.Queue;

public class k개정렬리스트병합 {

  private static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
      if (o1.val == o2.val) {
        return 0;
      }
      if (o1.val > o2.val) {
        return 1;
      }
      return -1;
    });
    for (ListNode node : lists) {
      if (node == null) {
        continue;
      }
      queue.add(node);
    }

    ListNode root = new ListNode(0);
    ListNode tail = root;
    while (!queue.isEmpty()) {
      ListNode node = queue.poll();
      tail.next = node;
      tail = node;

      if (node.next != null) {
        queue.add(node.next);
      }
    }
    return root.next;
  }

}
