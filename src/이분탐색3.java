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

    B[7] = 4의 뜻 : 4보다 작거나 같은 원소의 갯수가 최소 7개 있다는 뜻

    ** 오름차순을 했으니까 당연한 얘기임!!

    B[k] = x 라고할때,
    그럼 x 보다 작거나 같은 값은 몇개??
    x는 최대 N^2까지 가질 수 있음.
    다시말하면,
    x <= k

    ** B[k]의 값보다 작은 원소들의 갯수는 최소 k만큼이라는 뜻임.

    그럼 k를 알면 x의 값을 찾을 수있음(목표 -> x의 값을 찾아내자)
---------------------------------------------
    예시)
    만약 B[k] = 3이라고 하면,

    3보다 같거나 작은 원소의 갯수 k는??

    1, 2, 3 -- 1단
    2, 4, 6 -- 2단
    3, 6, 9 -- 3단

    일 때,

    1단에서 1, 2, 3
    2단에서 2
    3단에서 3

    ** 3으로 나눠서 몫이 1과 같거나 작아야함.
    따라서 k의 값은 5
---------------------------------------------
    그럼 어떻게??
    x값을 조정해가면서 k값을 맞춰본다.
    B[k] = x 이므로,
    left <= x(B[k]) <= right 이다.

    left, right를 정한다.
    left = 1; --- (1부터 시작해서 값을 찾아나감)
    right = k; --- right는 x의 최대값이라고하면 (x는 k를 넘을 수 없으니까)

    mid = (left+right) / 2; --- 어떠한 중간값(x의 값임)

    for(int i=1; i<=N; i++){
        count += Math.min(mid/ i, N); 5+2+1+1
    }
    --- x를  i로 나눠서 얼마나 나오는지 확인(1단부터 작거나 같은값을 추출)/ 즉, count의 값이 k의 값과 같아지는지 확인하는거임
    --- N보다 더 많은 원소의 갯수를 가질 수 없음. 최대 N개까지 갖을 수 있음

    if(count <= K){ --- mid값보다 작거나 같은 수의 갯수가 K랑 같은지 비교
        left = mid + 1; --- 적으면 한 번올려서 다시 비교
    }
    else {
        right = mid - 1; --- k보다 많다면 다시 줄임
    }


------------------------------------------------
    예시2)
    만약 B[k] = 5라고 하면,
    5보다 작거나 같은 원소의 갯수는?(k의 갯수)

    1, 2, 3, 4
    2, 4, 6, 8
    3, 6, 9, 12
    4, 8, 12, 16

    1단: 1,2,3,4
    2단: 2,4
    3단: 3
    4단: 4

    k는 8이 됨



     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());


        int left = 1;
        int right = k;
        int result = 0;

        while (left < right) {

            int count = 0;
            int mid = (left + right) / 2; // 임의의 x값
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N); // x/i를 가질 수 있는 값이 최대 N개 만큼 넘어갈 수 없음.
            }

            if (count < k) { // k개 미만
                left = mid + 1;
            } else { // k개 이상
                result = mid;
                right = mid - 1;
            }

        }


        System.out.println(result);
    }
}
