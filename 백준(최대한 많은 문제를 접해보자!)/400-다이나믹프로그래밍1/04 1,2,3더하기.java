import java.util.*;
import java.math.*;
public class Main {
	
	static int dp[] = new int [11];
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		dp[1] =1; //초기 값 초기화
		dp[2]=2;
		dp[3]=4;
		
		for(int j=4;j<=10;j++) { // 4부터 반복
			dp[j] = dp[j-3] + dp[j-2] + dp[j-1]; // 점화식
		}
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			
			System.out.println(dp[n]);
		}
	}
}

//
//
//
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int[] array = new int[11];
		
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		array[3] = 4;
		

		int a = 0;
		for(int i = 0; i < num; i++) {
			a = sc.nextInt();
			for(int j = 4; j <= a; j++) {
				array[j] = array[j - 1] + array[j - 2] + array[j - 3];
			}
			System.out.println(array[a]);
		}
	}

}