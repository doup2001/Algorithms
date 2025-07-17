import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 총 N개의 문자열로 이루어진 집합 S가 주어진다.
 * - 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
 */
public class Main {

    static String[] arrS;
    static String[] arrM;
    public static void main(String[] args) throws IOException {

        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /// 토큰 분리
        StringTokenizer st;

        /// 첫째줄 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /// 배열 입력
        arrS = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arrS[i] = st.nextToken();
        }

        /// 검사할 문자열 입력
        arrM = new String[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arrM[i] = st.nextToken();
        }

        /// 총 몇 개가 집합 S에 포함되어 있는지 출력
        Arrays.sort(arrS);

        /// 바이너리서치
        int L = 0;
        int R = arrS.length - 1;
        int ans = 0;

        for (String s : arrM) {
            int search = binarySearch(s, L, R);
            ans += search;

        }

        System.out.println(ans);

    }

    static int binarySearch(String key, int low, int high) {

        int mid;

        while (low <= high) {

            mid = (low + high) / 2;

            if (key.equals(arrS[mid])) {
                return 1;
            }

            /// 중앙값이 더 작으면 왼쪽 버려
            else if (key.compareTo(arrS[mid]) < 0) {
                high = mid - 1;
            }

            /// 중앙값이 더 크면 오른쪽 버려
            else if (key.compareTo(arrS[mid]) > 0) {
                low = mid + 1;
            }
        }
        return 0;
    }

}
