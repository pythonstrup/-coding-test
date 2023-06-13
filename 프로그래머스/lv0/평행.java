package commit;

public class 평행 {
  class Solution {
    public int solution(int[][] dots) {
      int answer = 0;
      for (int i = 1; i < 4; i++) {
        int x1 = dots[3][0] - dots[i][0];
        int y1 = dots[3][1] - dots[i][1];
        int x2 = dots[(i+1)%3][0] - dots[(i+2)%3][0];
        int y2 = dots[(i+1)%3][1] - dots[(i+2)%3][1];

        if ((double) x1/y1 == (double) x2/y2) {
          answer = 1;
          break;
        }
      }

      return answer;
    }
  }
}
