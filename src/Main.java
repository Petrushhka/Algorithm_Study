import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //첫번째줄 읽어오기
        BufferedReader text = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(text.readLine());

        // n: 배열의 길이(주어지는 수의 개수), m: 나눠야할 수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 일반 배열 설정
        int[] array = new int[n];

        // 누적 합 배열 설정
        int[] prefix = new int[n];

        // 두번재줄 읽어오기
        StringTokenizer st2 = new StringTokenizer(text.readLine());

        // 기본 배열에 토큰 하나 씩 세팅
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st2.nextToken());
        }

        // 누적 합 배열 만들기(prefix.length == array.lenght)
        // 배열 처음은 값이 똑같음(누적해서 더한 값이 없기때문)
        prefix[0] = array[0];

        for (int i = 1; i < n; i++) {

            // 누적합( 현재 값 + 이전 값의 sum)
            prefix[i] = array[i] + prefix[i - 1];

        }

        // m 으로 몇번 나눠질 수 있는지 카운트 하는 인자
        int count = 0;


        // 누적합과 구갑합을 m 이랑 나눠보기
        for (int i = 0; i < n; i++) {

            // 누적합이 0으로 나누어 지는 부분을 확인해서 카운팅
            if (prefix[i] % m == 0) {
                count++;
            }
            // for문 안에서 (구간합 % m )의 값을 확인해서 카운팅
            for (int j = 0; j < i; j++) {
                if ((prefix[i] - prefix[j]) % m == 0) {
                    count++;
                }
            }
        }

            System.out.println(count);

    }
}