import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int rm = 0;
        int N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
        int K = Integer.parseInt(st.nextToken());
        System.out.print("<");
        for (int i = 0; i < N - 1; i++) {
            rm = (rm + (K - 1)) % arr.size();
            System.out.print(arr.remove(rm) + ", ");
        }
        System.out.println(arr.remove(0) + ">");
    }
}

//
//
// 다른 풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer command = new StringTokenizer(br.readLine()," ");

        int num = Integer.parseInt(command.nextToken());
        int k = Integer.parseInt(command.nextToken());
        for(int i = 1; i<=num; i++){
            list.add(i);
        }

        int setCount = -1;
        for(int i = 0; i < num; i++){

            for(int j = 0; j < k;j++){
                setCount++;
                if(setCount >= num){
                    setCount = i;
                }
            }
            Collections.swap(list, i, setCount);
            Collections.sort(list.subList(i+1, num));
        }
        sb.append("<");
        for(int i = 0; i<num;i++) {
            sb.append(list.get(i));
            if(i != num-1)
                sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
