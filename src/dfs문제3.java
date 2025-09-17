import java.util.*;
import java.io.*;
import java.lang.*;

//https://www.acmicpc.net/problem/13023
public class dfs문제3 {

    /*
    이건 한 노드에서 깊이가 4가 될 수 있는지 물어보는 문제임
    그러니까 노드 5개가 간선 4개로 연결되는 경우가 1이고 아니면 0인 문제
    그럼 깊이탐색이 필요함

    그럼 한번 들어갈때마다 깊이를 증가시켜서 5가되는지 확인을 해보면됨.
     */

    static int N, M;
    static boolean isTrue;
    static boolean[][] origin;
    static boolean[] visited;

    static void dfs(int node, int depth) {
        if (depth >= 5) isTrue = true;
        visited[node] = true;
        for (int nextNode = 0; nextNode < N; nextNode++) {
            if (origin[node][nextNode] && !visited[nextNode]) {
                dfs(nextNode, depth + 1);
            }
        }
        visited[node] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        origin = new boolean[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());

            origin[start][end] = true;
            origin[end][start] = true;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, 1);
            }
        }

        System.out.println(isTrue ? 1 : 0);


    }
}
