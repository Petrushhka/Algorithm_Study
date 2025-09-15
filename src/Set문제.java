import java.util.*;
import java.io.*;
import java.lang.*;

// 프로그래머스 로또 번호 검출기 문제

/*
    - 1부터 45까지의 번호가 있는지 확인
    - 모든 자리수가 서로 다른지 확인
    - 결과는 true/false 로.

    1) 입력을 받음
    2) Set에 넣음(오름차순)
    3)

 */
public class Set문제 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> numbers = new TreeSet<>(); // 순서가 있게 저장 (오름차순)
        for(int i=0; i<6; i++){
            int inputNumber = Integer.parseInt(st.nextToken());
            numbers.add(inputNumber);
        }

        int isPrev = 0;
        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()){
            int oneNumber = iterator.next();
            if(oneNumber == isPrev){
                System.out.println("false");
                return;
            }
            if(oneNumber<0 || oneNumber>45){
                System.out.println("false");
                return;
            }
            isPrev = oneNumber;
        }
        System.out.println("true");


    }

}
