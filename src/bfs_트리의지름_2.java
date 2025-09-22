import java.util.*;
import java.io.*;


public class bfs_트리의지름_2 {

    public static class Node {
        int selfIndex;
        int cost;
        List<bfs_트리의지름_2.Node> child;

        Node(int a) {
            this.selfIndex = a;
        }
    }

    public static class Edge {
        int twoNodeIndex;
        int cost;

        Edge(int twoNodeIndex, int cost) {
            this.twoNodeIndex = twoNodeIndex;
            this.cost = cost;
        }
    }

    static boolean[] visited; // 등록리스트


    static Node makeTree(int nodeIndex, List<Edge>[] edgeListArray) {
//        if (check.contains(nodeIndex))
//            return null;
        visited[nodeIndex] = true;

        Node routeNode = new Node(nodeIndex);
        List<Node> children = new ArrayList<>(); // 빈 리스트 초기화(이후에 간선정보담음)

        List<Edge> edgeList = edgeListArray[routeNode.selfIndex];

        for (Edge edge : edgeList) {
            int nxt = edge.twoNodeIndex;

            if (!visited[nxt]) {
                Node childNode = makeTree(edge.twoNodeIndex, edgeListArray); // 자식노드를 재귀하여 손자노드 탐색
                childNode.cost = edge.cost; // 간선비용 저장
                children.add(childNode); // 부모노드 리스트에 자식노드 객체 저장
            }
        }

        routeNode.child = children;

        return routeNode;
    }

    // 트리 지름(최대 경로 가중치 합) 정답을 담을 전역 변수
    static int maxDiameter = 0;

    // 후위순회 DFS: 현재 노드에서 "자식으로 내려가는 최대 경로 길이"를 반환
    static int dfsDepth(Node node) {
        int first = 0, second = 0; // 자식 경로 top1, top2

        if (node.child != null) {
            for (Node ch : node.child) {
                int d = dfsDepth(ch) + ch.cost; // 자식 서브트리 최대 + 간선 가중치
                if (d > first) {
                    second = first;
                    first = d;
                } else if (d > second) {
                    second = d;
                }
            }
        }

        // 현재 노드를 경유하는 경로의 최대(= top1 + top2)로 지름 갱신
        if (first + second > maxDiameter) maxDiameter = first + second;

        return first;
    }


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        List<Edge>[] nodeList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            while (true) {
                int nextNumb1 = Integer.parseInt(st.nextToken());
                if (nextNumb1 == -1) break;
                int nextNumb2 = Integer.parseInt(st.nextToken());

                Edge edge = new Edge(nextNumb1, nextNumb2);
                nodeList[root].add(edge);
            }
        }


        Node root = makeTree(1, nodeList);

        dfsDepth(root);
        System.out.println(maxDiameter);
    }

}
