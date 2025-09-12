import java.util.*;
import java.io.*;
import java.lang.*;



//https://www.acmicpc.net/problem/10986
public class 나머지합 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefix = new int[N + 1];
        int count = 0;

        prefix[0] = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st2.nextToken());
            prefix[i] = prefix[i - 1] + a;
        }

        int mod[] = new int[N];
        for(int i =1; i<=N; i++){
            mod[i-1] = prefix[i]%M;
        }

        long sameMod[] = new long[M];
        for(int i=0; i<N; i++){
            if(mod[i] == 0){count++;}
            sameMod[mod[i]]++;
        }

        for(int i=0; i<M; i++){
            long l = (sameMod[i]*(sameMod[i]-1))/2;
            count += l;
        }

        System.out.println(count);
    }


}



