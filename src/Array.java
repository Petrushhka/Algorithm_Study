import java.util.*;
import java.io.*;
import java.util.Stack;


//https://www.acmicpc.net/problem/1817
public class Array {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = 0;
        int count = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.addFirst(Integer.parseInt(st2.nextToken()));
        }
        for (int i = 0; i < N; i++) {
            int out = deque.removeLast();
           count += out;
            if (count == M) {
                count = 0;
                sum++;
            } else if (count > M) {
                count = 0;
                sum++;
                deque.addLast(out);
            } else if ( count < M && i == N - 1 && N > 0) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
