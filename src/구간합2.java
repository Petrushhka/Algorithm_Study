import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.acmicpc.net/problem/11660
public class 구간합2 {
    public static void main(String[] args) throws IOException {
        /*
        1) 처음 행에 N개의 크기, M(출력횟수) 가 제시
        2) NxN의 테이블이여서 N만큼의 행을 읽어서 배열에 담아둬야함. -이차원배열
        3) 똑같은 이차원배열의 누적합 배열을 만듦
        4) M만큼의 반복문을 돌려 주어지는 좌표에 해당하는 값을 출력

        5) 주어지는 좌표 x1, x2, y1,y2
        6) 좌표 (x1,x2) ~ (x1,y2)
        7) 좌표 (y1,x2) ~ (y1,y2) 의 구간을 구해야함
            */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] origin = new int[N + 1][N + 1];
        int[][] prefix = new int[N + 1][N + 1];

        origin[0][0] = 0;
        prefix[0][0] = 0;

        for (int i = 1; i < origin.length; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j < origin.length; j++) {
                origin[i][j] = Integer.parseInt(st2.nextToken());
                prefix[i][j] = prefix[i][j - 1] + origin[i][j];
            }
        }

        for(int i=0; i<M; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int x1 =Integer.parseInt(st3.nextToken());
            int x2 = Integer.parseInt(st3.nextToken());
            int y1 = Integer.parseInt(st3.nextToken());
            int y2 = Integer.parseInt(st3.nextToken());
            int sum = 0;
            for(int j=x1; j<=y1; j++) {
                sum += prefix[j][y2] - prefix[j][x2 - 1];
               if(j==y1) {
                   System.out.println(sum);
                    sum = 0;
               }
            }
        }

    }
}
