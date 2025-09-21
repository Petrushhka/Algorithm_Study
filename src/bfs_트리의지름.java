import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.acmicpc.net/problem/1167
public class bfs_트리의지름 {

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
        int currentCost = 0; // 간선비용의 합을 저장하는 변수 -> 이것으로부터 자식 노드의 간선의 합을 구함.

        while (!deq.isEmpty()) {
            visited[1] = true;
            int pollNode = deq.pollLast();


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
                    if(currentCost > result) result = currentCost;

                    if (k == origin[pollNode].size() - 1) {
                        currentCost = sumCost[pollNode][nextNode];
                        if(currentCost > result) result = currentCost;
                    }

                }
            }

        }
        // 가장 큰 비용 구하기
//        for (int k = 1; k <= V; k++) {
//            for (int j = 1; j <= V; j++) {
//                if (sumCost[k][j] > result) {
//                    result = sumCost[k][j];
//                }
//            }
//        }
        System.out.println(result);


    }



        /*

        큐에 노드의 번호를 넣어줌
        큐가 비어있지 않다는 조건으로 while문 반복{

        1번노드부터 시작
        간선비용 저장하는 변수 = 0;
         pollNode = 1번 노드가 나옴
         pollNode에 연결된 노드를 연결해줌
         for(origin[pollNode]의 size만큼){

         origin[pollNode]는 Map의 형태임

         <Key값과 Value를 알고싶으면 반복문으로 돌려야함.>

         key와 value를 변수에 저장.

         key = nextNode

         if(다음노드에 방문한적없다면)
         큐에 다음노드 넣기
         방문체크하기

         간선비용을 이차원 배열에다가 담음

         간선비용[현재노드][다음노드] = 부모의 간선비용 + 간선비용

         부모의 간선비용을 기억하기위해 특정 변수 currentCost로 값을 저장.

         currentCost는 마지막까지 for문을 돌면 다시 값이 초기화됨.(자식노드가 여러개일때 매번 초기화 할 수 없음)

         모두 큐를 돌고나면

         이차원배열에서 가장 큰값을 출력!

         result변수에 currentCost가 더 클때마다 갱신해서 최대값만 가지고 있게하기.



         }


        }

         */


}



