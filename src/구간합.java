import java.util.*;
import java.io.*;
import java.lang.*;

/*
    구간합 -> 배열을 만들 때 미리 구간의 합을 계산해 놓은 배열을 같이 만들어 놓는다.
    공식: S[i] = S[i-1] + A[i] / 특정구간의 합 = S[j]-S[i]

    1) N: 주어지는 숫자의 갯수, M: 몇번 계산하게 할지
    2) 일반 배열 A와 누적합 S 배열을 미리 생성해놓음 (N의 크기만큼)
    3) 바로 다음 행을 읽어서 값을 초기화함.
    4) S와 A의 배열 처음은 같은 값으로 초기화하고 그 이후의 공식대로 값을 초기화
    5) 반복문을 M번 만큼 돌림, 인덱스 번호로 특정 구건의 합을 구함(j,i 가 인덱스번호)
    6) 특정 구간의 합에서 인덱스가 1일 경우 음수(-)로 바뀌면서 에러가 터지므로 배열을 한칸 더 늘려야함.
 */

//https://www.acmicpc.net/problem/11659
public class 구간합 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 주어지는 숫자의 갯수
        int M = Integer.parseInt(st.nextToken()); // 출력 횟 수

        int[] A = new int[N+1]; // A,S 배열 만들기
        int[] S = new int[N+1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st2.nextToken());
            if (i == 1) S[i] = A[i];
            else S[i] = S[i - 1] + A[i];
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken());
            int end = Integer.parseInt(st3.nextToken());

            int rangeSum = 0;
            rangeSum = S[end] - S[start-1];

            System.out.println(rangeSum);
        }


    }
}
