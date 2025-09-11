import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11720
public class 숫자합 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long Numbers = Long.parseLong(br.readLine());

        long sum = 0;
        long number = Numbers;

        for (int i = 0; i < N; i++) {
            double w = Math.pow(10,N-1-i);

            long a =(long)((double) number % w);
            long b = (long) ((double) number / w);

            sum += b;
            number = a;
        }

        System.out.println(sum);


    }
}
