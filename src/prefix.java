import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prefix {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        long[] prefix = new long[n];
        // prefix의 나머지를 담아두는 배열임
        int[] mod = new int[n];

        // 해당 배열은 같은 나머지를 가지고 있는 누적합이 몇개나 있나 확인해보는 용도임
        //누적합일 때 숫자가 int의 범위를 넘어서기 때문에 long
        //배열의 사이즈는 int 까지로 밖에 설정못함
        long[] remainderCount = new long[m];

        long count = 0;

        // 입력값을 배열로 만들기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 배열 만들기
        prefix[0] = arr[0];
        for(int i  = 1; i < n; i++){
            prefix[i] = prefix[i-1]+arr[i];
        }

        // 1) 누적합에서의 나머지가 0인 부분 카운트
        for(int i = 0; i < n; i++){
            // prefix의 값이 long일 수 있기 때문에 하지만 m의 값은 int 범위에 있으므로 형변환 시 문제없음
            mod[i] = (int)(prefix[i] % m);
            if(mod[i] == 0) {
                count++;
            }
            // 해당 부분은 누적합의 나눗셈의 나머지와 같은 인덱스를 증가시키는 것임.
            remainderCount[mod[i]]++;
        }


        for(int i = 0; i < remainderCount.length; i++){
            //같은 나머지를 같은 인덱스의 조합을 구하기

            // 구간은 항상 2개의 구간만 존재 (i,j)
            // 나머지가 같은 인덱스를 두가지 선택할 수 있는(구간) 경우의 수는 remainderCount[i] * remainderCount[i-1] 임.
            // 하지만 순서가 중복되어도 상관없으니 2로 나누어줌
            long l = remainderCount[i] * (remainderCount[i] - 1) / 2;
            count += l;
        }
        System.out.println(count);


    }
}