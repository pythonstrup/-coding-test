package no;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class 원점에서가장가까운k개의점 {

  static class Point {
    double distance;
    int[] point;

    public Point(int[] point) {
      this.distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
      this.point = point;
    }
  }

  public int[][] kClosest(int[][] points, int k) {
    Queue<Point> queue = new PriorityQueue<>((point1, point2) -> {
      if (point1.distance == point2.distance) {
        return 0;
      }
      if (point1.distance > point2.distance) {
        return 1;
      }
      return -1;
    });
    for (int i = 0; i < points.length; i++) {
      queue.add(new Point(points[i]));
    }
    int[][] answer = new int[k][];
    for (int i = 0; i < k; i++) {
      answer[i] = queue.poll().point;
    }
    return answer;
  }
}
