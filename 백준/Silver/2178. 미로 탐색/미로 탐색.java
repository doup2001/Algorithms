import java.io.*;
import java.util.*;

/**
 * 백준 2178문제
 * - 미로문제
 * - 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 * - 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * - 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 * - 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 * 4 6
 * 101111
 * 101010
 * 101011
 * 111011
 */
public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int M;

    static int[] dx = {-1, 1, 0, 0}; /// 위,아래
    static int[] dy = {0, 0, -1, 1}; /// 좌,우

    public static void main(String[] args) throws IOException {

        /// 값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        /// N,M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /// 배열 생성
        arr = new int[N][M];
        visited = new boolean[N][M];

        /// 값 넣기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        /// 미로 찾기
        bfs(N - 1, M - 1);

        /// 그대로 출력
        System.out.println(arr[N - 1][M - 1]);

    }

    static void bfs(int endX, int endY) {

        int x = 0; int y = 0;

        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            /// 값 추출
            int[] cur = queue.poll();
            x = cur[0];
            y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >=0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arr[nx][ny] == 1) {

                    arr[nx][ny] = arr[x][y] + 1;

                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }

        }
    }
}
