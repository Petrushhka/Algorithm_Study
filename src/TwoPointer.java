import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int s = 1;
        int e = 1;
        int count = 0;
        int sum  = 1;

        while(e<=N && s<=N){
            if( sum < N){
                e++;
                sum += e;
            }
            else if(sum > N){
                sum -= s;
                s++;
            }
            else if(sum == N){
                count++;
                e++;
                sum += e;
            }
        }
            System.out.println(count);

    }
}
