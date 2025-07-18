import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - 문제
 * - 오늘도 서준이는 너비 우선 탐색(BFS) 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
 * - N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다.
 * - 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다. 정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
 * - 너비 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 오름차순으로 방문한다.
 *
 *
 * 입력
 * - 첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.
 * - 다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다. (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.
 */
public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int cnt = 0;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        /// 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        /// 초기 설정
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        order = new int[n + 1];

        /// 배열 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        /// 반복해서 정점과 간선 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        /// 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        /// BFS 진행하기
        BFS(r);

        /// 결과 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(order[i]);
        }

    }

    /**
     * BFS
     * - 인접한 그래프부터 방문하도록 설정
     */
    static void BFS(int u) {

        visited[u] = true;
        order[u] = cnt++;
        queue.add(u);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            order[v] = cnt++;

            for (int w : graph[v]) {
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }

    }
}
