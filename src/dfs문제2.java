import java.io.*;
import java.util.*;
import java.lang.*;

// https://www.acmicpc.net/problem/2023
public class dfs문제2 {
    /*
    소수찾기(나와 1 말고는 나눌수있는 수가 없음)

    최대 8자리까지
    가장 처음 생각: for문으로 전체 탐색 -> 당연히 안될거라 생각
    두번째 생각:
    그냥 단순 소수가 아니라 소수로 이루어진 소수를 찾는거임.
    따라서 각 자리마다 소수인지 확인하면 됨.
    1~9자리까지 소수는 2,3,5,7


   2,3,5,7로 다음 수를 탐 색하자!!

   eg) 7331 -> 733 -> 73 -> 7 모수 소수여야함.

  가장 밖에서부터 10의 자리수까지 조합이 차례대로 모두 소수인 경우를 만족해야함

  1) N -> 자리수 지정
  2) 예시를 보면 가장 큰자리의 숫자는 반드시 소수여야함. 따라서 저기서 x10 씩 증가해서 소수인지 아닌지 판별
  3) dfs(2) -> 를 시작하면  21,22,23 등을 탐색해서 소수인 애들만 판별.
  4) 21은 소수가 아님. 따라서 더 이상 탐색하면 안됨 return;
  5) 23은 소수이기 때문에 dfs(23)으로 탐색
  6) 231, 232...
  7) 총 N번째 자리까지 갔다면 출력
  8) 소수 판별 함수 boolean isPrime(int number)
  -> for(int i=2; i<number; i++)
  -> if(number % i == 0)
  -> return false;
  -> else { return true; }

   9) 재귀함수는? dfs(k)
    if(isPrime(k)) {
        for(int i=1; i<10; i++){
            int nextNumber = k*10+1;
            if(isPrime(nextNumber && nextNumber < Math.pow((double)nextNumber, (double)N){
                dfs(nextNumber);
            }

       }
    }

     */


    static boolean isPrime(int number){
        for(int i=2; i<number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int number){
        if(isPrime(number)){
            for(int i=1; i<10; i++){
                int k = number * 10 + i;
                if(k > Math.pow(10,N-1) && k<Math.pow(10,N) && isPrime(k)){
                   System.out.println(k);
                }else if(k < Math.pow(10,N-1)){
                    dfs(k);
                }
            }
        }
    }

    static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(2);
        dfs(3);
        dfs(5);
        dfs(7);



    }


}
