import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1806 문제
 * - 10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다.
 * - 이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
 * - 첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다.
 * - 둘째 줄에는 수열이 주어진다. 수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다.
 */

public class Main {

    static int[] arr;
    static int[] sumArr;

    public static void main(String[] args) throws IOException {

        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /// 토큰
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        /// 첫번째 줄 입력
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        /// 두번째 줄 입력 및 배열 정의
        arr = new int[n];
        sumArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        /// 구간합 만들어두기
        /// 구간 합은 S[i-1] + A[i]
        for (int i = 0; i < n; i++) {

            if (i == 0) {
                sumArr[i] = arr[i];
            }
            else {
                sumArr[i] = sumArr[i - 1] + arr[i];
            }
        }


        /// 이 문제의 표준 투포인터 설계는 start=0, end=0에서 시작하여
        /// end 포인터를 올리며 부분합을 증가시키고,
        /// 합이 S 이상이면 start 포인터를 올리며 최소 길이를 줄여나가는 방식입니다

        int start = 0;
        int end = 0;

        /// 결과 스냅샷
        int ans = Integer.MAX_VALUE;

        /// 구간합을 투포인터에서 조절해서 사용
        while (start < n) {
            if (end >= n) break; // 가장 먼저 체크!

            int sum = (start == 0) ? sumArr[end] : sumArr[end] - sumArr[start - 1];

            if (sum >= s) {
                int indexSum = end - start + 1;
                ans = Math.min(ans, indexSum);
                start++;
            } else {
                end++;
            }
        }

        /// 못찾으면 0으로 출력
        if (ans == Integer.MAX_VALUE) {
            bw.write("0\n");

        }
        else{ bw.write(ans + "\n");}


        bw.flush();
        bw.close();
    }
}
