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
        2) (과목점수 / 최댓값) * 100 값을 특정 변수에 담아놓음
        3) 특정 변수 / N(시험본과목) 으로 평균 값을 구함
        4) 평균값의 허용오차는 10^-2 임.


        2)에서 보면 {(과목1 점수 + 과목2 점수 + ...) * 100 / 최댓값} / 과목의갯수 = 평균 << 값을 구할 수 있음

         */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long[] arr = new Long[N];

        long max = 0;
        int scoreSum = 0;

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            scoreSum += score;
            if(score > max){
                max = score;
            }
        }
        double average = ((scoreSum*100.0)/max)/N;

        System.out.println(average);

    }

}
