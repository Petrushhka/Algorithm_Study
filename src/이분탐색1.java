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
        2) 중앙값을 기준으로 target이 작으면, 오른쪽경계를 -1 한다. (그리고 다시 중앙값을 구함. 중앙값을 포함한 오른쪽은 전부 제외됨)
        3) 중앙값을 기준으로 크면 오른쪽으로, 왼쪽경계를 +1 한다.(그리고 다시 중앙값을 구함. 중앙값을 포함한 왼쪽은 전부 제외됨)
        4) 중앙값과 일치하지 않으면 0
         */

            int left = 0;
            int right = origin.length-1;
            boolean found = false;


            while (left<=right) {
                int mid = (left+right) / 2;
                if(origin[mid] == target){
                    found = true;
                    break;
                }else if(origin[mid] < target){
                    left = mid +1;
                }else{
                    right = mid-1;
                }

            }
                System.out.println(found ? 1:0);

        }

    }

}

