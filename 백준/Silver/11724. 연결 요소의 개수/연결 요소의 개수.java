import java.io.*;
import java.util.*;

/**
 * 백준 - 11724 번
 * - 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 * - 무방향 그래프 -> 2배
 * - 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
 * - 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
 */
public class Main {

    /// 그래프 static 생성
    static ArrayList<Integer>[] graph;

    /// DFS, boolean 배열 생성
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        /// 첫번째 줄 읽기
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /// 정점만큼 인접리스트 배열 생성
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        /// 각 배열 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        /// 각 줄에서 읽어서 리스트에 넣기
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            /// 반대에서 값 넣기
            graph[u].add(v);
            graph[v].add(u);
        }

        /// 값 초기화
        int count = 0;
        /// 스택에서 빼면서 사용
        for (int i = 1; i <= N; i++) {

            /// boolean 이 true가 될 때까지
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        bw.write(count + "\n");
        bw.flush();
        br.close();
    }

    /// DFS 함수 작성
    static void dfs(int u) {

        /// 방문했던 곳이라면, 패스
        if (visited[u]) {
            return;
        }

        visited[u] = true;

        /// 다음 정점으로 이동
        for (int v : graph[u]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
    
}

