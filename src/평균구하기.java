import java.util.*;
import java.io.*;
import java.lang.*;
// https://www.acmicpc.net/problem/1546
public class 평균구하기 {
    public static void main(String[] args) throws IOException {


        /*
        시험본 과목: N (1000개)
        성적 나열: 다음 줄(20, 10, 40...)

        1) 성적 중 최대값을 선택
        2) (첫번째부터 / 최댓값) * 100 값을 특정 변수에 담아놓음
        3) 특정 변수 / N(시험본과목) 으로 평균 값을 구함
        4) 평균값의 허용오차는 10^-2 임.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long[] arr = new Long[(int)N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long max = 0;

        for (int i = 0; i < N; i++) {
            if (i != N-1) {
                if(arr[i] > arr[i+1]){
                    max = arr[i];
                }
            }
            else if(i==N-1 && max < arr[i]){
                max = arr[i];
            }
        }

        long sum = 0;

        for (Long number : arr) {
            if(number < max){
                sum += (number/(double)max) * 100;
            }
            else if(number == max){
                sum += (number/(double)max) * 100;
            }
        }

        double average = (double) sum / N;

        System.out.println(average);


    }

}
