import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.acmicpc.net/problem/1260


public class dfs와_bfs {
    /*
     N: 노드의 개수
     M: 간선의 수
     V: 탐색을 시작하는 노드

     출력: dfs 결과 \n bfs


     1. DFS
      1) 인접리스트를 생성한다.
      2) 방문배열을 만든다.
      3) 재귀함수로 탐색한다.

     2. BFS
      1) 인접리스트를 만든다.
      2) 방문 배열을 만든다.
      3) 큐의 형태로 부모 노드가 빠지면 자식노드가 추가되게한다.

     */

    static List<Integer>[] origin;
    static boolean visited[];

    static void dfs(int node) {
        if (!visited[node]) {
            visited[node] = true;
            System.out.print(node + " ");

            for (int nextNode : origin[node]) {
                dfs(nextNode);
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        origin = new ArrayList[N + 1];

        //인접리스트 초기화
        for (int i = 0; i <= N; i++) {
            origin[i] = new ArrayList<>();
        }

        // 인접리스트로 간선 정보 표시
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());

            origin[start].add(end);
            origin[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }


    }

}
