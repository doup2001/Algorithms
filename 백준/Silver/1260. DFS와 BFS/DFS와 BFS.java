import java.io.*;
import java.util.*;

/**
 * 백준 - 1260번
 * 문제
 * - 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * - 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 * - 정점 번호는 1번부터 N번까지이다.
 *
 * 입력
 * - 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 * - 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * - 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
 * - 입력으로 주어지는 간선은 양방향이다. (무방향)
 */
public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] stackVisited;
    static boolean[] queuedVisited;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        /// 첫째 줄 읽기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        /// 배열 초기화
        graph = new ArrayList[N + 1];
        stackVisited = new boolean[N + 1];
        queuedVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        /// 무방향 간선 입력하기
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            graph[src].add(dest);
            graph[dest].add(src);
        }

        /// DFS 실행

        /// V부터 인접 그래프 실행 결과 출력
        /// 작은 것 부터 수행
        /// 스택 활용 하기

        stackVisited[V] =true;
        System.out.print(V + " ");

        /// 작은것부터 나오게 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        for (int i : graph[V]) {

            /// 이미 방문했다면 패스
            if (stackVisited[i]) {
                continue;
            }

            /// 방문하지 않은 곳에서 진행
            stack.push(i);
            DFS(i);
        }

        /// BFS 실행
        /// V부터 인접 그래프 바탕 실행 결과 출력
        /// 작은 것 부터 수행
        /// 큐 활용 하기
        System.out.println();
        BFS(V);
    }

    /**
     * DFS
     */
    static void DFS(int src) {

        /// 이미 방문했다면 패스
        if (stackVisited[src]) {
            return;
        }

        stackVisited[src] = true;
        int i = stack.pop();

        System.out.print(i + " ");

        /// POP 뽑기
        for (int v : graph[src]){
            if (!stackVisited[v]) {
                stack.push(v);
                DFS(v);
            }
        }
    }

    /**
     * BFS
     */
    static void BFS(int start) {

        /// 큐 생성 및 값 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        queuedVisited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int next : graph[current]) {
                if (!queuedVisited[next]) {
                    queuedVisited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
