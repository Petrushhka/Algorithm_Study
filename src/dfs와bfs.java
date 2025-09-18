import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.acmicpc.net/problem/1260


public class dfs와bfs {
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

    static int N,M,V;
    static List<Integer>[] origin;
    static boolean visited[];
    static ArrayDeque<Integer> deq;

    static void dfs(int node) {
        if (!visited[node]) {
            visited[node] = true;
            System.out.print(node + " ");

            for (int nextNode : origin[node]) {
                dfs(nextNode);
            }

        }
    }

    static void bfs(int node){
        visited[node] = true;
        deq.addFirst(node);

        while(!deq.isEmpty()){
            int pollNode = deq.pollLast();
            System.out.print(pollNode+" ");

            for(int next : origin[pollNode]){
                if(!visited[next] && origin[pollNode].contains(next) && origin[next].contains(pollNode)){
                    visited[next]=true;
                    deq.addFirst(next);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

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

        for(int i=1; i<=N; i++){
            Collections.sort(origin[i]); // 번호가 작은 정점부터 오름차순
        }

                dfs(V);


        System.out.println(); // 아래서 부턴 BFS

        /*
         BFS에서 큐를 어떤식으로 이용할까?
         현재 인접리스트를 가지고 있음.
         큐에다가 리스트의 첫번째 인덱스번호를 넣는다.(방문체크한다.)
         큐에서 뺄 때 첫번째인덱스의 속한 값들을 큐에 넣는다.
         이 과정을 반복한다.(방문배열이 전부 찰 때까지



         1) 큐에 첫번째 노드를 넣는다.
         2) 첫번째 노드의 인덱스와 간선으로 연결된 노드들을 큐에 넣는다.
         3) 큐에서 가장먼저 들어온 노드를 뺀다.(출력한다.)
         4) 다시 연결 노드를 큐에 넣는다.(해당 노드에 방문여부를 확인한 후에)
         5) 방문 배열이 전부 찼으면 끝낸다.

         !!!!!!!! 조건이 큐가 비어있지 않다면일때, 반복문으로 큐에 데이터를 삽입하면 계속 비어질때까지 큐의 데이터를 넣고 뺄 수 있음.
         */

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        deq = new ArrayDeque<>();

        bfs(V);




    }

}
