import java.io.*;
import java.util.*;
import java.lang.*;


//https://www.acmicpc.net/problem/1300
public class 이분탐색3 {

    /*
    3x3의 이차원배열 A가 있으면
    일차원배열 B는 length가 3x3=9 임.
    k가 7이면,  B[7] = 6이고
    A베열 형태는 다음과같음(배열의 인덱스시작은 1번이라고 문제에서 얘기함)
    123
    246
    369

    B배열의 형태는(배열의 인덱스시작은 1번이라고 문제에서 얘기함, 그리고 오름차순 정렬!!)
    122334669

    2차원배열 -> 1차원배열로 만들고 거기서 꺼낸다?
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int A[][] = new int[N + 1][N + 1];
        int[] B = new int[N * N + 1];

        /* 이차원배열 -> 일차원배열 옮기기
         1행의 1부터 3까지 넣었으면?
           2행의 4부터 6까지 넣어야함.
           1,2,3 - j (i == 1),
           4,5,6 - j+N (i == 2)
           7,8,9 - j+N*2 (i ==3)

           조건을 j+N*(i-1) 하면됨.
         */
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                A[i][j] = i * j;
                B[j + N * (i - 1)] = A[i][j];
            }
        }

        Arrays.sort(B);

        System.out.println(B[k]);
    }
}
