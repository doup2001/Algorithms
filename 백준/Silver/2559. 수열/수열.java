import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2559
 * - 첫째 줄에는 두 개의 정수 N과 K가 한 개의 공백을 사이에 두고 순서대로 주어진다.
 * - 첫 번째 정수 N은 온도를 측정한 전체 날짜의 수이다. N은 2 이상 100,000 이하이다.
 * - 두 번째 정수 K는 합을 구하기 위한 연속적인 날짜의 수이다. K는 1과 N 사이의 정수이다.
 * - 둘째 줄에는 매일 측정한 온도를 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다. 이 수들은 모두 -100 이상 100 이하이다.
 */
public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        /// 입력 받기
        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        /// N,K 입력
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        /// 배열
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /// 실행
        int sum = 0;
        int max = Integer.MIN_VALUE;

        /// 슬라이딩 윈도우를 활용한다.
        for (int i = 0; i < n; i++) {

            /// 값 더하기
            sum += arr[i];

            // 최초에 나온 합을 최댓값으로 잡아놓음
            if(i == k - 1) {
                max = sum;
            }

            // 처음 길이를 벗어났을 때 부터 한칸씩 밀어주면서 최댓값 비교
            if(i >= k) {
                sum -= arr[i - k];
                max = Math.max(max, sum);
            }

        }

        System.out.println(max);

    }
}
