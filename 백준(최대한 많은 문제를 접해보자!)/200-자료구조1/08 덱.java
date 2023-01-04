import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            String str;

            switch (command) {
                case "push_back":
                    str = st.nextToken();
                    deque.offerLast(str);
                    break;
                case "push_front":
                    str = st.nextToken();
                    deque.offerFirst(str);
                    break;
                case "pop_front":
                    str = deque.pollFirst();
                    sb.append(str != null ? str : -1).append("\n");
                    break;
                case "pop_back":
                    str = deque.pollLast();
                    sb.append(str != null ? str : -1).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    str = deque.peekFirst();
                    sb.append(str != null ? str : -1).append("\n");
                    break;
                case "back":
                    str = deque.peekLast();
                    sb.append(str != null ? str : -1).append("\n");
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
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] que = new int[20001];
	static int head = 10000;
	static int tail = 10000;
	static int size = 0;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();

			switch(S) {
			case "push_front" :
				push_front(Integer.parseInt(st.nextToken()));
				break;
			case "push_back" : 
				push_back(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front" :
				sb.append(pop_front()).append("\n");
				break;
			case "pop_back" : 
				sb.append(pop_back()).append("\n");
				break;
			case "size" :
				sb.append(size()).append("\n");
				break;
			case "empty" :
				sb.append(empty()).append("\n");
				break;
			case "front" :
				sb.append(front()).append("\n");
				break;
			case "back" :
				sb.append(back()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

	private static int pop_back() {
		if(size == 0) {
			return -1;
		}else {
			int P = que[tail];
			tail--;
			size--;
			return P;
		}		
	}

	private static int pop_front() {
		if(size == 0) {
			return -1;
		}else {
			int P = que[head + 1];
			head++;
			size--;
			return P;
		}
	}

	private static void push_back(int parseInt) {
		tail++;
		size++;
		que[tail] = parseInt;
		
	}

	private static void push_front(int parseInt) {
		que[head] = parseInt;
		head--;
		size++;
		
	}

	private static int back() {
		if(size == 0) {
			return -1;
		}else {
			return que[tail];
		}
	}

	private static int front() {
		if(size == 0) {
			return -1;
		}else {
			return que[head+1];
		}
	}

	private static int empty() {
		if(size  == 0) {
			return 1;
		}else {
			return 0;
		}
	}

	private static int size() {
		return size;
	}
}
