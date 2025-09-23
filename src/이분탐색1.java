import java.util.*;
import java.lang.*;
import java.io.*;


// https://www.acmicpc.net/problem/1920
public class 이분탐색1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(origin);

        int M = Integer.parseInt(br.readLine());
        int[] temp = new int[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            temp[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int target = temp[i];

        /*
        1) 원본 배열의 중앙값을 정한다.
        2) 중앙값을 기준으로 target이 작으면, 중앙값의 기준 오른쪽을 전부버리고 새롭게 중앙값 세팅
        3) 중앙값을 기준으로 크면 오른쪽으로, 중앙값의 기준으로 왼쪽을 전부버리고 새롭게 중앙값 세팅
        4) 중앙값과 일치하지 않으면 0
         */

            int firstCenter = origin.length / 2;
            int center = firstCenter;

            while (true) {
                if (target == origin[center]) {
                    System.out.println(1);
                    break;
                }


                if (target < origin[center]) {
                    center = center / 2;
                }
                if (target > origin[center]) {
                    int tempCenter = (center + center / 2);
                    if(tempCenter >= origin.length){
                        center = origin.length-1;
                    }else { center = tempCenter; }
                }


                if (target == origin[center]) {
                    System.out.println(1);
                    break;
                }

                if(center == origin.length-1) break;

            }

            if (target != origin[center]) {
                System.out.println(0);
            }


        }

    }

}

