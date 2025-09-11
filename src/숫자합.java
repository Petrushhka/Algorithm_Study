import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11720
public class 숫자합 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        String Numbers = br.readLine();

        long sum = 0;

        char[] arr = Numbers.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            sum += Character.getNumericValue(arr[i]);
        }

        System.out.println(sum);


    }
}
