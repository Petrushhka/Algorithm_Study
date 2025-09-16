import java.util.*;
import java.io.*;
import java.lang.*;

// https://www.acmicpc.net/problem/11724
public class dfs문제_인접리스트 {
    /*
    1) N: 노드, M: 간선의 수
    2) 인접리스트 배열 생성-> List<Integer>[]
    3) 방문배열 생성
    4) dfs 재귀함수 생성
    5) counting 하기
     */

    static int N,M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count;

    static void dfs(int node){
        visited[node] = true;
        int connectNode = graph[node].get(0);
        if(!visited[connectNode]){
            dfs(connectNode);
        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i=1;i<=N;i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }


        System.out.println(count);



    }

}
