import java.util.*;
import java.io.*;


//https://www.acmicpc.net/problem/1817
public class ArrayQuestion {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        int sum = 0;
        int count = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            deque.addFirst(Integer.parseInt(st2.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            int out = deque.removeLast();
            if ((count+out) > M) {
                sum++;
                count = out;
            } else  {
                count+=out;
            }
        }

        if (count > 0) {
            sum++;
        }

        System.out.println(sum);
    }
}
