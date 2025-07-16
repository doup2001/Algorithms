import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 - 11003번
 * - 최솟값 찾기
 * - 슬라이딩 윈도우
 * - N개의 수 A1, A2, ..., AN과 L이 주어진다.
 * - Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오.
 * - 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
 * - 범위
 * i-L+1 ~ i => i - (i-L+1) +1 = L
 * 슬라이딩 윈도우 + deque 로 정렬 효율 높이기
 *
 *
 * 덱의 마지막 위치에서부터 now보다 큰 값은 덱에서 제거하기
 */
public class Main {
    public static void main(String[] args) throws IOException {

        /// 입력,출력 값 정의하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        /// 값 분리하기
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        /// Deque 해결하기
        Deque<Node> deque = new LinkedList<>();
        /// 한 줄 인식
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            int now = Integer.parseInt(st.nextToken());
            Node node = new Node(i, now);

            /// 비어있지 않고... 최솟값보다 큰 경우 삭제
            while (!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }

            deque.addLast(node);

            /// index가 3보다 차이나면 기존 값을 삭제
            if ((node.index - deque.getFirst().index) >= L) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");

        }
        bw.flush();
        bw.close();

    }

    /**
     * 노드
     */
    static class Node {
        public int index;
        public int value;

        Node(int index, int value) {
            this.value = value;
            this.index = index;
        }
    }


}
