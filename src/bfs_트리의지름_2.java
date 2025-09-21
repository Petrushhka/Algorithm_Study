import java.util.*;


public class bfs_트리의지름_2 {

    public static class Node {
        int selfIndex;
        List<bfs_트리의지름_2.Node> child;


        Node(int a) {
            this.selfIndex = a;
        }


    }

    public static class edge {
        int twoNodeIndex;
        int cost;

        edge(int twoNodeIndex, int cost) {
            this.twoNodeIndex = twoNodeIndex;
            this.cost = cost;
        }
    }

    static List<Integer> check = new ArrayList<>(); // 등록리스트


    static Node makeTree(int nodeIndex, List<edge>[] edgeListArray) {
//        if (check.contains(nodeIndex))
//            return null;
//        check.add(nodeIndex);

        Node routeNode = new Node(nodeIndex);
        List<Node> children = new ArrayList<>();

        List<edge> edgeList = edgeListArray[routeNode.selfIndex];

        for (edge edge : edgeList) {
            if (!check.contains(edge.twoNodeIndex)) {
                check.add(edge.twoNodeIndex);
                Node child = new Node(edge.twoNodeIndex);
                children.add(child);
                makeTree(edge.twoNodeIndex, edgeListArray);
            }
        }

        routeNode.child = children;

        return routeNode;
    }


    public static void main(String[] args) {

        List<edge>[] nodeList = new ArrayList[5 + 1];

        for (int i = 1; i <= 5; i++) {
            nodeList[i] = new ArrayList<>();
        }
        nodeList[1].add(new edge(3, 2));
        nodeList[2].add(new edge(4, 4));
        nodeList[3].add(new edge(1, 2));
        nodeList[3].add(new edge(4, 3));
        nodeList[4].add(new edge(2, 4));
        nodeList[4].add(new edge(3, 3));
        nodeList[4].add(new edge(5, 6));
        nodeList[5].add(new edge(4, 6));

        List<Node> routeNodeList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Node node = makeTree(i, nodeList);
            routeNodeList.add(node);
        }

    }

}
