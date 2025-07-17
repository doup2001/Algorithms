import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 문제 -2003
 * - 투포인터
 * - 문제
 * - N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다.
 * - 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
 * 입력
 * - 첫째 줄에 N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)이 주어진다.
 * - 다음 줄에는 A[1], A[2], …, A[N]이 공백으로 분리되어 주어진다. 각각의 A[x]는 30,000을 넘지 않는 자연수이다.
 */
public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        /// 첫번째 줄 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /// 두번째 줄 입력 및 배열 생성
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ///  i번째 수부터 j번째 수까지의 합이 M이 되는 경우 출력
        int L = 0;
        int R = 0;
        int ans = 0;
        int sum = 0;

        /// 투포인터 작동
        while (true) {

            /// 합이 넘으면
            if (sum >= m) {

                if (sum == m) {
                    ans++;
                }

                sum -= arr[L];
                L++;
            } else if (R == n) {
                break;
            } else {
                sum += arr[R];
                R++;
            }
        }
        System.out.println(ans);
    }
}
