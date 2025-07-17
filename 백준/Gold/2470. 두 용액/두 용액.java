import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2470번
 * - KOI 부설 과학연구소에서는 많은 종류의 산성 용액과 알칼리성 용액을 보유하고 있다.
 * - 각 용액에는 그 용액의 특성을 나타내는 하나의 정수가 주어져있다.
 * - 산성 용액의 특성값은 1부터 1,000,000,000까지의 양의 정수로 나타내고, 알칼리성 용액의 특성값은 -1부터 -1,000,000,000까지의 음의 정수로 나타낸다.
 * - 같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의한다.
 * - 이 연구소에서는 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다.
 * - 예를 들어, 주어진 용액들의 특성값이 [-2, 4, -99, -1, 98]인 경우에는 특성값이 -99인 용액과 특성값이 98인 용액을 혼합하면 특성값이 -1인 용액을 만들 수 있고, 이 용액이 특성값이 0에 가장 가까운 용액이다.
 * - 참고로, 두 종류의 알칼리성 용액만으로나 혹은 두 종류의 산성 용액만으로 특성값이 0에 가장 가까운 혼합 용액을 만드는 경우도 존재할 수 있다.
 * - 산성 용액과 알칼리성 용액의 특성값이 주어졌을 때, 이 중 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.
 *
 *
 * 입력 예시
 * 5
 * -2 4 -99 -1 98
 *
 * 출력 예시
 * -99 98
 */
public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        /// 첫째 줄
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        /// 두번째 줄 및 배열 생성
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /// 정렬
        Arrays.sort(arr);

        /// 투포인터 실행
        int L = 0;
        int R = N - 1;
        int min = Integer.MAX_VALUE;

        /// 출력할 값 저장
        int ansL = 0;
        int ansR = 0;

        /// 어떻게 근처의 값을 저장할 수 있을지
        while (L < R) {

            int sum = arr[L] + arr[R];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ansL = arr[L];
                ansR = arr[R];
            }

            /// 값이 크다면,
            else if (sum > 0) {

                /// 우측을 줄여야한다.
                R--;
            }

            /// 값이 작다면
            else if (sum < 0) {
                /// 왼쪽을 키워야한다.
                L++;
            }

            else {
                break;
            }
        }
        bw.write(ansL + " " +ansR);
        bw.flush();
        bw.close();

    }

}
