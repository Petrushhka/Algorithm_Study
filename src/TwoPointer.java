import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointer {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

//해당문제는 값이 한개만들어오기때문에 다음토큰x

        N = Integer.parseInt(st.nextToken());

// N만큼의 1씩증가하는 배열만들기
// 0인덱스 무시하고 1부터 증가
        Integer[] arr = new Integer[N + 1];
        arr[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            arr[i] = i;
        }

        //누적합
        Integer[] prefix = new Integer[N + 1];
        prefix[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }
// 두개포인터로 설정, 카운팅
        int s = 1;
        int e = 1;
        int count = 0;

// 포인터가 움직이는 방법
// 1) s는 e의 범위를 넘어갈수없음(같을순있음)
// 2) N으로 정한 값보다 합이 적으면, end 증가
// 3) N으로 정한 값보다 합이 많으면 start 증가
// 4) 원하는 합이 나올때 count후에 end 증가


        // i를 end로 놓겠음.
        while(e < N+1 && s < N+1){
            if(prefix[e] - prefix[s-1] < N) e++;
            else if(prefix[e] - prefix[s-1] > N) s++;
            else if(prefix[e] - prefix[s-1] == N) {count++; e++;}
        }
        System.out.println(count);


    }
}
