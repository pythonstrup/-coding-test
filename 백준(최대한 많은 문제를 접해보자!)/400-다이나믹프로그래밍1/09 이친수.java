// Bottom-up
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String args[]) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int count = Integer.parseInt(br.readLine());
            long d[] = new long[count+1];
            // d[n] = n자리 이친수.
            d[0] = 0;
            d[1] = 1;
            for (int i = 2; i <= count; i++){
                d[i] = d[i-1] + d[i-2];
            }
            System.out.println(d[count]);
    }
}

//
//
// Top-Down
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static long d[];
    public static void main(String args[]) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int count = Integer.parseInt(br.readLine());
            d = new long[count+1];
            System.out.println(Calculate(count));
    }

    public static long Calculate(int count){
        if(count == 0){
            return 0;
        }
        if(count == 1){
            return 1;
        }
        if(d[count] > 0){
            return d[count];
        }
        d[count] = Calculate(count-1) + Calculate(count-2);
        return d[count];
    }
}