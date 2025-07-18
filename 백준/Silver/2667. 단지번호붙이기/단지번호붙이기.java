import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2667
 * - 단지번호붙이기
 * - <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * - 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * - 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * - 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
 * - 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 7
 * 0110100
 * 0110101
 * 1110101
 * 0000111
 * 0100000
 * 0111110
 * 0111000
 */
public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int N;

    /// 상하좌우 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        /// 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N][N];

        /// 값 넣기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        List<Integer> result = new ArrayList<>();

        /// BFS 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    int bfs = bfs(i, j);
                    result.add(bfs);
                }
            }
        }
        
        Collections.sort(result);

        System.out.println(result.size());

        for(int v : result) {
            System.out.println(v);
        }
    }

    /// BFS 시작
    static int bfs(int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;

        /// 위에서부터 시작하도록
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            cnt++;

            /// 상하좌우 이동
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && graph[nx][ny] == 1) {

                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }
}
