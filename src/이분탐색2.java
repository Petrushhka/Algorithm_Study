import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.acmicpc.net/problem/2343
public class 이분탐색2 {
    /*
    N: 강의의 갯수
    M: 블루레이 갯수

    블루레이는 모두 길이가 같아야함.
    블루레이는 몇분짜리여야하나?

    강의의 갯수가 3묶음으로 묶여야함.
    전부더한값 / N 하면 3묶음으로 나뉘지가 않음

    1) 디스크의 최소용량은 최대강의 길이만큼으로 지정할 수 있음.
    2) 디스크의 최대용량은 모든강의의 합만큼으로 지정할 수 있음.
    최소(9) ~ 최대(45)

    3) 최소와 최대값을 가지고 중간값을 찾음
    4) 중간값을 가지고 강의가 몇번 담아지는지 확인함.
    5) 중간값이 나뉜 구간이 < M 이면 중간값의 경계를 왼쪽으로 옮김
    6) 중간값이 나뉜 구간이 > M 이면 중간값의 경계를 오른쪽으로 옮김
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] origin = new int[N];
        int right = 0;
        int left = 0;


        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st2.nextToken());
            left = Math.max(left, origin[i]); // 강의 길이는 순서대로가 아니라 강의 순서대로 길이가 주어지는거였음.!!!
            right += origin[i];
        }

        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 1; // 현재까지 사용된 블루레이 갯수

            for(int i=0; i<N; i++){
                if(sum+origin[i] <= mid){
                    sum += origin[i];
                }else if(sum+origin[i] > mid){
                    count++;
                    sum = origin[i];
                }
            }
            if (count <= M) {
                result = mid;//최소 값을 구해야해서 더 작은 값을 구해야함.
                right = mid - 1;
            }
            if (count > M) {
                left = mid + 1;
            }
        }
        System.out.println(result);


    }

}
