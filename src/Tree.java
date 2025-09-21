import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.acmicpc.net/problem/1167
public class Tree {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        List<Map<Integer, Integer>>[] origin = new ArrayList[V + 1];
        boolean[] visited = new boolean[V + 1];


        for (int i = 1; i <= V; i++) {
            origin[i] = new ArrayList<>();
        }

        for (int i = 1; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNumber = Integer.parseInt(st.nextToken());
            while (true) {
                int stToken1 = Integer.parseInt(st.nextToken());
                if (stToken1 == -1) break;
                int stToken2 = Integer.parseInt(st.nextToken());

                Map<Integer, Integer> map = new HashMap<>();

                map.put(stToken1, stToken2); // 매핑

                origin[nodeNumber].add(map); // 저장
            }
        }



        int[][] sumCost = new int[V + 1][V + 1];
        int result = 0;
        Deque<Integer> deq = new ArrayDeque<>();

        deq.offerFirst(1);
        while (!deq.isEmpty()) {
            visited[1] = true;
            int pollNode = deq.pollLast();

            int currentCost = 0; // 지금까지 더해왔던 비용의 합(이걸 기준으로 다른 자식들도 더할거임)

            for (int k = 0; k < origin[pollNode].size(); k++) {
                Map<Integer, Integer> nextNodeValueMap = origin[pollNode].get(k);

                int nextNode = 0;
                int valueOrCost = 0;

                for (Integer key : nextNodeValueMap.keySet()) {
                    nextNode = key;
                    valueOrCost = nextNodeValueMap.get(key);
                }
/// ///////////////////////////////////////////////////
                if (!visited[nextNode]) {
                    deq.offerFirst(nextNode);
                    visited[nextNode] = true;


                    sumCost[pollNode][nextNode] = currentCost + valueOrCost;
                    currentCost = sumCost[pollNode][nextNode];


                }
            }

        }
            // 가장 큰 비용 구하기
            for (int k = 1; k <= V; k++) {
                for (int j = 1; j <= V; j++) {
                    if (sumCost[k][j] > result) {
                        result = sumCost[k][j];
                    }
                }
                System.out.println(result);
            }



    }



        /*

        노드를 넘어갈때마다 간선의비용을 확인하기 위한 배열 sumCost[V+1][V+1]

        1번 노드를 que에 삽입

        1번노드의 방문배열 체크

        1번 노드를 뺄 때, (다음의 노드가 방문된적 없다면)다음의 노드를 다시 큐에 삽입과 동시에

        [현재노드][다음노드] = map.다음노드.값 을 지정

        다음 노드가 큐에서 빠질 때, 다음노드2를 큐에 삽입과 동시에

        [다음노드][다음노드2] = [현재노드][다음노드] + map.다음노드2.값
       -----------------------------------------

        [현재노드][다음노드] << 이값을 어떻게 들고있을거냐?

        다음 노드를 진행하기 전에 List의 Size를 확인함
        그 안에서  while문을 돌 때 while문 밖에서 현재 노드만 기억하고 잇으면됨


       --------------------------------------
       최대값의 판단은 다음과 처럼

       if(방문체크가 전부 방문되는 순간)
       지금 방문한 노드가 최종 값들의 모든 합이 되는 셈임

       따라서 해당 행에서 가장 큰 갑을 골라내면됨


         */


}



