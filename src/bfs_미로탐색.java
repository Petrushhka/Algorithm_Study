import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2178
public class bfs_미로탐색 {

    /*
        BFS, DFS가 사용 될 수 있는 자료구조는
        Graph(교과서), 그리드(2차원배열), 이진트리(BST)

        시작점:(1,1) / 도착점(N,M)

        1. N과 M을 입력하여 이차원배열을 만든다.
        2. 띄어쓰기가 없는 다음 행을 읽는다.
        3. split("")을 통해 한글자씩 자른다.
        4. string letter : string.split("")
            array[0][0] ~~ [0][N]

        ----------------------------
        큐를 만들어 놓는다.
        5. 시작점에서 상하좌우로 갈 수 있는 것을 확인
        6. 시작점에 도착표시를 하고, 빼낸다.
        7. 갈수 있는 지점을 큐에 넣는다.
        8. 빼낼 때마다 갈 수 있는 지점을 넣는다.
        9. 그리고 큐가 없을 때까지 반복한다.


        그럼 최소 경로의 수는??
        최소 경로의 수는 최소 깊이를 뜻함.
        따라서 갯수를 세는게 아닌 깊이를 파악해야함.
        깊이를 파악하는 변수가 필요함.
        큐에 연결된 노드를 넣을때 1씩 증가시키면 되는데
        노드가 2개이상이면? 1씩 어떤식으로 증가?
        (연결된 가장 마지막 노드를 넣을 때 넣으면됨)

     */


    static int N, M;
    static int[][] origin;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        origin = new int[N + 1][M + 1];
        boolean[][] visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String nextLine = br.readLine();
            for (int j = 1; j <= M; j++) {
                origin[i][j] = nextLine.charAt(j-1) - '0'; // '0'의 아스코드 48, '1'의 아스키코드 49 이기대문에 0만빼줘도 원래 수가 나옴
            }
        }

        Deque<int[]> deq = new ArrayDeque<>();

        /*
        현재 이차원배열에서 자기의 위치에는 방문체크를 한다.
        갈수있는곳을 찾는다.
        찾아서 가면 방문체크를 하고, 방문하기전에 있던 숫자보다 +1해서 숫자를 올린다.

        1) [1,1] -> 값은 1이다.
        2) [2,1] 로 내려갈 수 있다 -> 방문체크 후 [2,1]의 값을 (1+1 =2)로 올려준다.
        3) [3,1]로 내려갈 수 있다 -> 방문체크 후 [3,1] 의 값을 (2+1 =3)로 올려준다.
        4) 왼쪽과 아래쪽 모두 갈 수 있으면??
        5) 그럼 방문하기전에(deque에 집어넣기전에 체크해서 먼저 숫자를 올려주고 해당 인덱스의 자리를 넣어주는거임)
         */
        deq.offerFirst(new int[]{1, 1});
        visited[1][1] = true;
        while (!deq.isEmpty()) {
            int[] current = deq.pollLast();
            int Y = current[0];
            int X = current[1];
            if(N == Y && M == X) { //최종 목표지점에 도달했으면 출력해라
                System.out.println(origin[Y][X]);
            }
            //  바닥을 벗어나지 않고 + 위의 행이 0이 아닌 경우 + 방문한적 없으면
            if (Y+1 <= N && origin[Y + 1][X] != 0 && !visited[Y + 1][X]) {
                visited[Y + 1][X] = true;
                origin[Y+1][X] = origin[Y][X]+1;
                deq.offerFirst(new int[]{Y+1,X});
            }
            // 천장을 벗어나지 않고 + 아래의 행이 0이 아닌 경우 + 방문한적 없으면
            if (Y-1 >= 0 && origin[Y - 1][X] != 0 && !visited[Y - 1][X]) {
                visited[Y - 1][X] = true;
                origin[Y-1][X] = origin[Y][X]+1;
                deq.offerFirst(new int[]{Y-1,X});
            }
            // 우측벽을 벗어나지 않고 + 오른쪽 열이 0이 아닌 경우 + 방문한적 없으면
            if (X+1 <= M && origin[Y][X + 1] != 0 && !visited[Y][X + 1]){
                visited[Y][X+1] = true;
                origin[Y][X+1] = origin[Y][X]+1;
                deq.offerFirst(new int[]{Y,X+1});
            }
                // 왼쪽벽을 벗어나지 않고 + 왼쪽 열이 0이 아닌 경우  + 방문한적 없으면
                if (X-1 >=0 && origin[Y][X - 1] != 0 && !visited[Y][X - 1]){
                    visited[Y][X-1] = true;
                    origin[Y][X-1] = origin[Y][X]+1;
                    deq.offerFirst(new int[]{Y,X-1});
                }

        }

    }

}
