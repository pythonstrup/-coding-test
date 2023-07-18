package no;

public class 치킨쿠폰 {

  public int solution(int chicken) {
    int answer = 0;
    for (int i = 0; i <= 6; i++) {
      answer += chicken / 10;
      chicken = (chicken / 10) + (chicken % 10);
    }
    return answer;
  }


  // 다른 사람 풀이
  public int solution2(int chicken) {
    int answer = chicken/9;
    if(chicken>1&&chicken%9==0){
      answer--;
    }

    return answer;
  }
}
