import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st3.nextToken());
            int x1 = Integer.parseInt(st3.nextToken()) - 1;
            int y1 = Integer.parseInt(st3.nextToken()) - 1;
            int x2 = Integer.parseInt(st3.nextToken()) - 1;

            if (w == 1) {
                int y2 = Integer.parseInt(st3.nextToken()) - 1;

                int sum = 0;

                for (int j = x1; j <= x2; j++) { // y2가 마지막
                    for (int k = y1; k <= y2; k++) {
                        sum += arr[j][k];
//                            System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
                    }
                }
                System.out.println(sum);
                ;
            } else {
                x2++;
                arr[x1][y1] = x2;
            }

        }
    }
}