import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] prefix = new int[n];
        int[] mod = new int[n];
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i  = 1; i < n; i++){
           prefix[0] = arr[0];
           prefix[i] = prefix[i-1]+arr[i];
        }

        for(int i = 0; i < n; i++){
            mod[i] = prefix[i] % m;
            if(mod[i] == 0) {
                count++;
            }
        }





        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(mod));





    }
    }
