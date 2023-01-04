import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<Integer>();
		int last = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			
			switch(S) {
			case "push" :
				last = Integer.parseInt(st.nextToken());
				que.offer(last);
				break;
			case "pop" :
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(que.poll()).append("\n");
				break;
			case "size" :
				sb.append(que.size()).append("\n");
				break;
			case "empty" :
				if(que.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "front" :
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(que.peek()).append("\n");
				break;
			case "back" :
				if(que.isEmpty()) sb.append(-1).append("\n");
				else sb.append(last).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
	
}

//
//
// 다른 풀이
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{

    public static int[] queue;
    public static int rear = -1; // 후단 (삽입 위치)
    public static int front = -1; // 전단 (삭제 부위)
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        queue = new int[N];
        rear = -1; front = -1;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
            
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                
                case "size":
                    sb.append(size()).append("\n");
                    break;
                
                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "front":
                    sb.append(front()).append("\n");
                    break;

                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // push X: 정수 X를 큐에 넣는 연산이다.
    public static void push(int x){
        queue[++rear] = x;
    }

    // pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static int pop() {
        if(empty() != 1){
            return queue[++front];
        } else {return -1;}
    }

    // size: 큐에 들어있는 정수의 개수를 출력한다.
    public static int size(){
        return rear - front;
    }

    // empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    public static int empty(){
        if (rear == front){
            return 1;
        } else {return 0;}
    }

    // front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static int front(){
        if (empty() != 1){
            return queue[front + 1];
        } else {return -1;}
    }

    // back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    public static int back(){
        if (empty() != 1){
            return queue[rear];
        } else {return -1;}
    }

} // Main