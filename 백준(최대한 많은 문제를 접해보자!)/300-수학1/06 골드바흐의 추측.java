import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[10000001];
        arr[0] = arr[1] = true;

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i]) continue;

            for (int j = i + i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }

        int num;
        while (true) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            int a = 0;
            for (int i = 2; i <= num / 2; i++) {
                if (!arr[i] && !arr[num - i]) {
                    a = i;
                    sb.append(num).append(" = ").append(a).append(" + ").append(num - i).append("\n");
                    break;
                }
            }

            if (a == 0) {
                bw.write("Goldbach's conjecture is wrong.");
                bw.flush();
                bw.close();
                return;
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

//
//
// 다른 풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static boolean[] arr;
	public static final int MOD = 1000000;
	public static void main(String[] args) throws IOException {
		arr = new boolean[MOD+1];
		arr[0]=arr[1] = true;
		for(int i=2; i<=Math.sqrt(MOD); i++) {
			if(arr[i]) continue;
			for(int j=i*i ; j< MOD; j+=i) {
				arr[j] = true;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num;
		
		while((num=Integer.parseInt(br.readLine())) !=0){
			boolean ok = false;
			for(int i=2; i<=num/2; i++) {
				if(!arr[i] && !arr[num-i]) {
					ok = true;
					sb.append(num+" = "+i+" + "+(num-i)+"\n");
					break;
				}
			}
			if(!ok) {
				sb.append("Goldbach's conjecture is wrong."+"\n");
			}
		}
		System.out.println(sb);
	}
}
