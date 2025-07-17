import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 7795 문제
 * - 심해에는 두 종류의 생명체 A와 B가 존재한다. A는 B를 먹는다.
 * - A는 자기보다 크기가 작은 먹이만 먹을 수 있다.
 * - 예를 들어, A의 크기가 {8, 1, 7, 3, 1}이고, B의 크기가 {3, 6, 1}인 경우에 A가 B를 먹을 수 있는 쌍의 개수는 7가지가 있다.
 * - 8-3, 8-6, 8-1, 7-3, 7-6, 7-1, 3-1.
 * - 두 생명체 A와 B의 크기가 주어졌을 때, A의 크기가 B보다 큰 쌍이 몇 개나 있는지 구하는 프로그램을 작성하시오.
 *
 *
 * 입력
 * - 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 A의 수 N과 B의 수 M이 주어진다.
 * - 둘째 줄에는 A의 크기가 모두 주어지며, 셋째 줄에는 B의 크기가 모두 주어진다. 크기는 양의 정수이다. (1 ≤ N, M ≤ 20,000)
 *
 * 출력
 * - 각 테스트 케이스마다, A가 B보다 큰 쌍의 개수를 출력한다.
 */
public class Main {

    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {

        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        /// 첫째줄 - 테스트케이스 입력
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        /// T 만큼 반복
        for (int i = 0; i < T; i++) {

            /// 두번째 줄 - A와 B의 크기
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            /// 각각 배열 생성
            A = new int[N];
            B = new int[M];

            /// 각각 배열 값 입력하기
            // A 배열 생성
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < A.length; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            // B 배열 생성
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < B.length; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            /// B배열 정렬
            Arrays.sort(B);

            /// 이진 탐색 시작
            /// A가 B보다 큰 것 이진탐색 시작
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                int search = binarySearch(A[j], 0, B.length - 1);
                count += search;
            }
            bw.write(count + "\n");

        }


        bw.flush();
        bw.close();
    }

    /**
     * 이진 탐색을 위한 함수
     * 큰 것이 있다면, 다 체크
     * @param key   찾고자하는 값
     * @param left  왼쪽 인덱스
     * @param right 우측 인덱스
     */
    static int binarySearch(int key, int left, int right) {

        int mid;
        int result = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            /// 중간 값보다 작거나 같으면,
            if (key <= B[mid]) {
                /// 왼쪽 체크 해야함
                right = mid - 1;
            }

            /// 현재 값이 더 크다면, 왼쪽은 다 체크하고, 우측을 봐야함.
            else if (key > B[mid]) {

                /// 우측으로 넘어가서 체크
                left = mid + 1;

                /// 왼쪽은 이미 다 작기때문에 현재까지의 인덱스 값을 더한다.
                result = mid + 1;
            }
        }

        return result;
    }
}
