import java.util.Arrays;

public class 중복좌표문제_프로그래머스 {


    static int road(int distance) {
        if (distance < 0) {
            return +1;
        } else if (distance > 0) {
            return -1;
        }
        return 0;
    }

    class Solution {
        public int solution(int[][] points, int[][] routes) {
            int answer = 0;

            int N = points.length; // 포인트의 갯수
            int M = routes.length; // 로봇의 갯수

            int[][] robotDistance = new int[M][2]; // 로봇들이 이동할 이동값

            // 이동값 구하기
            for (int i = 0; i < M; i++) {
                int start = routes[i][0];
                int end = routes[i][1];

                int yDistance = points[start][0] - points[end][0]; // 도착지점 - 출발지점: y이동값
                int xDistance = points[start][1] - points[end][1]; // 도착지점 - 출발지점: x이동값

                robotDistance[i][0] = yDistance; // 이해하기 편하게 한단계 더 풀어놓음
                robotDistance[i][1] = xDistance;
            }

            int biggestSumDistance = 0; // for문의 조건을 걸어주기 위한 변수 -> 가장 큰길이로 for문을 돌려야함.
            for (int i = 0; i < M; i++) {
                int candidate = Math.abs(robotDistance[i][0]) + Math.abs(robotDistance[i][1]);
                if (biggestSumDistance < candidate) biggestSumDistance = candidate;
            }

            // 실제로 움직이는 for 문

            return answer;
        }









        /*
             이동경로의 규칙
            1) 아래로 먼저이동(r좌표부터) -> points[이부분][]
            2) 그다음 열을 이동(c좌표) -> points[][이부분]

            points의 인덱스 번호 = routes에서 정한 지점

            eg) routes[4,2]가 표현하는 것
            시작점: points[1,4] -> 도착점: points[6,4]

            y좌표로 먼저 움직여야함: 6->1 까지 움직여야함 (기준: 도착지점 - 출발지점)
            x좌표가 그다음으로 움직임: 4->4 니까 이동하지 않음.

            y 이동값: 6-1 = 5 (양수면 하행)
            x 이동값: 4-4 = 0

            eg2) routes[1,3]
            y 이동값: 4-3 = 1
            x 이동값: 7-2 = 5 (양수면 우방향 이동) / (음수면 좌방향 이동)

            eg3) routes[2,4]
            y 이동값: 1-6 = -5 (음수면 상행)
            x 이동값: 4-4 = 0


            어떻게 answer를 올릴까?
            1) rountes로 주어지는 애들의 경로를 모두 변수에 담아놓고 비교(메모리 비용 과다) -> 안될것같음
            2) 하나의 for문에서 i를 증가시켜 모든 로봇을 칸마다 조건별로 움직이게하고 해당 좌표가 같은지 비교
                -> 이렇게하면 i는 좌표와 연관지을수는 없음
                -> i가 증가하면 x좌표와 y좌표를 어떻게 움직이게 할건지??? --- **1 주석에서 계획

            **1
            1) routes의 좌표을 미리 계산하여 구해놓는다. (y 이동값, x 이동값으로  총 2개가 구해짐)
            2) 다음의 조건문을 전역적으로 설정 (해당 부분은 메서드화 시켜서 직관적으로 바꿔야함)
                - y 이동값이 0이 아니고, y 이동값이 음수이면 해당 좌표를 y방향으로 +1로 움직인다.
                - y 이동값이 0이 아니고, y 이동값이 양수이면 해당 좌표를 y방향으로 -1로 움직인다.
                - y 이동값이 0이고, x 이동값이 0이 아니면서, x 이동값이 양수이면 +1로 움직인다.
                - y 이동값이 0이고, x 이동값이 0이 아니면서, x 이동값이 음수이면 -1로 움직인다.
                - 좌표를 이동하고나서는 이동값도 움직이 방향 만큼 더해서 0이 될때까지 좌표를 옮겨줌

            3) for문에서 i만큼의 이동이 이루어질때 마다 겹치는 좌표가 2개 이상이면 answer++;
        */





        }
    }



