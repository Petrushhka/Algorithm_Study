import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.acmicpc.net/problem/1167
public class bfs_트리의지름 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        // List<Map<Integer, Integer>>[] origin = new ArrayList[V + 1];
        List<int[]>[] origin = new ArrayList[V + 1];   // {nextNode, cost}
        boolean[] visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            origin[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) { // (입력 줄 수는 필요시 <= V 로 조정)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNumber = Integer.parseInt(st.nextToken());
            while (true) {
                int stToken1 = Integer.parseInt(st.nextToken());
                if (stToken1 == -1) break;
                int stToken2 = Integer.parseInt(st.nextToken());

                // Map<Integer, Integer> map = new HashMap<>();
                // map.put(stToken1, stToken2);
                // origin[nodeNumber].add(map);
                origin[nodeNumber].add(new int[]{stToken1, stToken2}); // 자료형만 변경
            }
        }

        // int[][] sumCost = new int[V + 1][V + 1];
        int[] dist = new int[V + 1]; // 누적 거리만 1차원으로
        int result = 0;
        Deque<Integer> deq = new ArrayDeque<>();

        deq.offerFirst(1);
        int currentCost = 0; // 부모의 누적 거리 역할

        while (!deq.isEmpty()) {
            visited[1] = true;        // 기존 위치 유지
            int pollNode = deq.pollLast();

            // 현재 노드의 누적 거리(부모에서 넘겨받은 값 대체)
            currentCost = dist[pollNode];

            for (int k = 0; k < origin[pollNode].size(); k++) {
                // Map<Integer, Integer> nextNodeValueMap = origin[pollNode].get(k);
                // int nextNode = 0, valueOrCost = 0;
                // for (Integer key : nextNodeValueMap.keySet()) {
                //     nextNode = key;
                //     valueOrCost = nextNodeValueMap.get(key);
                // }
                int[] nextNodeValue = origin[pollNode].get(k);
                int nextNode = nextNodeValue[0];
                int valueOrCost = nextNodeValue[1];

                if (!visited[nextNode]) {
                    deq.offerFirst(nextNode);
                    visited[nextNode] = true;

                    // sumCost[pollNode][nextNode] = currentCost + valueOrCost;
                    dist[nextNode] = currentCost + valueOrCost;   // 자료형만 변경

                    // if(currentCost > result) result = currentCost;
                    if (currentCost > result) result = currentCost;

                    if (k == origin[pollNode].size() - 1) {
                        // currentCost = sumCost[pollNode][nextNode];
                        currentCost = dist[nextNode];             // 자료형만 변경
                        if (currentCost > result) result = currentCost;
                    }
                }
            }
        }

        System.out.println(result);
    }
}