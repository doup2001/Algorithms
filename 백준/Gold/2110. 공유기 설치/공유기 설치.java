import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 공유기 설치
 * 도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.
 * 도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
 * C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
 *
 * 입력
 * - 첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다.
 * - 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.
 *
 * 출력
 * 첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.
 */
public class Main {

    static int N;
    static int C;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        /// 입력
        input();

        /// 정렬
        Arrays.sort(arr);

        /// 문제 풀이
        binarySearch();

        /// 출력
        System.out.println(max);

    }

    private static void input() throws IOException {
        /// 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /// 토큰
        StringTokenizer st;

        /// 값 입력 받기
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    /// 간격이 값으로 사용되는 것이다.
    private static void binarySearch() {

        int low = 1;
        int high = arr[N - 1] - arr[0];
        int mid;
        int cnt = 0;

        while (low <= high) {

            /// 중앙값
            mid = (low + high) / 2;

            /// cnt 계산식
            cnt = calculate(mid);

            /// 설치 가능하면 더 넓은 간격 시도 (거리 늘림)
            if (cnt >= C) {

                max = Math.max(max, mid);
                low = mid + 1;

            }

            /// 설치 불가능하면 간격 줄이기
            else if (cnt < C) {
                high = mid - 1;
            }

        }
    }

    private static int calculate(int mid) {
        int cnt = 1;               // 첫 집에는 무조건 공유기를 설치한다고 가정
        int lastInstalledPos = arr[0];  // 마지막 공유기 설치 위치는 첫 집 좌표

        for (int i = 1; i < arr.length; i++) {
            // 현재 집의 좌표가 마지막 설치 위치와 mid 이상 떨어져 있으면 설치 가능
            if (arr[i] - lastInstalledPos >= mid) {
                cnt++;                // 공유기 개수 증가
                lastInstalledPos = arr[i]; // 설치 위치 갱신
            }
        }

        return cnt;  // 설치한 공유기 개수 반환
    }
}


