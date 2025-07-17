import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * - 백준 1920번
 * - N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * - 이진검색을 통해 찾기
 * - 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
 * - 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
 * - 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데,
 * - 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
 */
public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {


        ///  ----- 설정 -----

        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        /// 첫째 줄 값 받기
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        /// N 배열 생성 및 두번째 줄 입력
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /// 세번째 줄 값 받기
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        /// M 배열 생성 및 네번째 줄 입력
        int[] arrM = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        /// ------- 시작 --------

        /// arr 정렬
        Arrays.sort(arr);

        /// 이진 검색을 통해 존재하는지 체크
        /// 존재한다면 1, 존재하지 않는다면 0 출력
        for (int i = 0; i < M; i++) {

            int result = binarySearch(arrM[i], 0, arr.length - 1);
            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
    }

    /// 반복적 탐색
    /// 절반식 비교한다.
    /**
     * 바이너리 서치
     * @param key   찾으려는 값
     * @param low   시작 인덱스
     * @param high  마지막 인덱스
     */

    static int binarySearch(int key, int low, int high) {
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;

            if(key == arr[mid]) {
                return 1;
            } else if(key < arr[mid]) {
                /// 찾고자하는 값이 중간보다 작다.
                /// 더 작은 값들을 찾아야한다.
                /// 왼쪽 탐색
                high = mid - 1;
            } else {
                /// 큰 값을 찾아야하기에
                /// 오른쪽 탐색
                low = mid + 1;
            }
        }

        return 0; // 탐색 실패
    }
}
