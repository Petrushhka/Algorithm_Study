import java.io.*;
import java.util.*;
import java.lang.*;


//https://www.acmicpc.net/problem/11724
public class dfs문제 {

    /*
    몇개의 그래프가 나오는지 확인하는 문제

    주어진 예제에 따라 그래프를 만듦
    N: 노드의 갯수, M: 간선의 갯수

    2차원 배열을 만들자.
    인덱싱이 노드의 번호라 생각하고 배열의 값이 간선의 표시라고 가정.
    간선이 없는경우: 0, 간선이 있는경우: 1

    1) 배열은 origin[N+1][N+1]로 생성 -> 0번째 인덱스는 제외하기 위해
    2) 만약 1,2 로 연결되어있으면, [1][2]과 [2][1]의 값을 1로 치환
    3) 연결이 안되어있으면 전부 0

    그럼 어디서 시작해서 조회해야하나? -> 아무곳이나 상관없음(기준은 내가 결정)

    그전에 방문여부를 확인하는 방문체크를 하는 배열이 필요함 = visited[N+1] (1차원배열, 크기는 N+1)
    1번 노드의 탐색이 종료됬으면 true

    재귀함수를 만든다.
    dfs(int node){
        visited[node] = true; -> 노드에 들어오면 방문체크
        for(int i=0;i<N;i++){ -> 해당 노드와 연결되는 간선 확인
            if(origin[node][i] == 1 && !visited[i]
            dfs(i);
        }
    }

    for문을 통해 탐색을 시작한다.
    for문에서 한번만 사이클이 돌았다는건 특정 그래프를 전부 탐색했다는것으로 count를 올려줌
    그렇게 전부 탐색해서 counting하기
     */

    static int N;
    static int M;

    public static int parseInt(String string) {
        return Integer.parseInt(string);
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && origin[node][i] == 1) {
                dfs(i);
            }
        }
    }

    static int[][] origin;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

         origin = new int[N + 1][N + 1];
         visited = new boolean[N + 1];

        int count = 0; // 그래프의 갯수

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = parseInt(st2.nextToken());
            int end = parseInt(st2.nextToken());

            origin[start][end] = 1;
            origin[end][start] = 1;
        }


        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }

        }
            System.out.println(count);

    }
}
