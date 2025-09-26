import java.util.*;
import java.io.*;
import java.lang.*;


// https://www.acmicpc.net/problem/18352
public class 그래프1 {

    /*

       가중치 : 모두 동일
       출발 노드로부터 도착노드까지의 최단 거리가 K인 경우의 수와 지나온 경로를 출력하여라 -- dfs
       빨리갈 수 있는 노드는 여러간선을 거쳐서 가는건 인정 x

        N: 노드의 갯수
        M: 간선의 수
        K: 최단거리
        X: 출발노드 번호

     */


    static int N, M, K, X;
    static boolean[] visited;
    static List<Integer>[] origin;
    static Deque<int[]> deq = new ArrayDeque<>();

    /*
         처음 노드에서 다음 노드까지 가면 depth + 1;
         그 다음 노드에서 또 다음 노드까지 가면 depth + 1;
         currentDepth가 K가 되면 내려오면 출력

        K만큼의 길이로도 갈 수 있고, K보다 적은 길이로도 갈 수 있는 노드의 경우는 어떻게 걸러낼까?
        처음에 들렀던 node를 확인해서 비교?
        -> BFS 방법으로 풀어야함.

    */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        origin = new ArrayList[N + 1];


        for (int i = 1; i <= N; i++) {
            origin[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int firstNode = Integer.parseInt(st2.nextToken());
            int lastNode = Integer.parseInt(st2.nextToken());

            origin[firstNode].add(lastNode);
            /*
             반대로도 이어줘야하는지??
             -> 이어주면 안됨, 단방향이기 때문임
             */

        }


        deq.offerFirst(new int[]{X,0});
        boolean found = false;

        while (!deq.isEmpty()) {

            int[] pollArray = deq.pollLast();
            int pollNode = pollArray[0];
            int pollDepth = pollArray[1];


            if (visited[pollNode]) continue;
            visited[pollNode] = true;

            if (pollDepth == K) {
                System.out.println(pollNode);
                found = true;
                continue;
            }


            for (int nextNode : origin[pollNode]) {
                if (!visited[nextNode]) {
                    deq.offerFirst(new int[]{nextNode, pollDepth+1});

                }
            }

        }
        if(!found){
            System.out.println(-1);
        }
    }
}


