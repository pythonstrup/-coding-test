// Top-Down
import java.util.Scanner;
 
public class Main {
	
	static int[] seq;
	static Integer[] dp;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		seq = new int[N];
		dp = new Integer[N];
		
		
		for(int i = 0; i < N; i++) {
			seq[i] = in.nextInt();
		}
		
		// 0 ~ N-1 까지 모든 부분수열 탐색 
		for(int i = 0; i < N; i++) {
			LIS(i);
		}
		
		int max = dp[0];
		// 최댓값 찾기 
		for(int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	
	
	static int LIS(int N) {
		
		// 만약 탐색하지 않던 위치의 경우 
		if(dp[N] == null) {
			dp[N] = 1;	// 1로 초기화 
			
			// N-1 부터 0까지중 N보다 작은 값들을 찾으면서 재귀호출. 
			for(int i = N - 1; i >= 0; i--) {
				if(seq[i] < seq[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
		}
		return dp[N];
	}
}

//
//
// Bottom-up
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] seq = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			seq[i] = in.nextInt();
		}
		
		// dp
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
		    
			// 0 ~ i 이전 원소들 탐색
			for(int j = 0; j < i; j++) {
		    
				// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if(seq[j] < seq[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;	// j번째 원소의 +1 값이 i번째 dp가 된다.
				}
			}
		}
		
		// 최댓값(최대 길이) 탐색 
		int max = -1;
		for(int i = 0; i < N; i++) {
			max = dp[i] > max ? dp[i] : max;
		}
		System.out.println(max);
		
	}
 
}