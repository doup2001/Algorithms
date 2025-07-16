import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 1253번
 * - '좋은 수' 구하기
 * - 투포인터 활용하여 문제 풀이
 * - 주어진 N개의 수 중에서, 다른 두 수의 합으로 표현될 수 있는 수가 있다면, 그 수를 ‘좋은 수’라고 한다.
 * - N개의 수 중에서 좋은 수가 총 몇 개인지 출력하시오.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        /// 값 입력 받기
        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;

        // 첫 번째 줄 읽기
        stringTokenizer= new StringTokenizer(br.readLine());

        /// 배열 만들기
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[n];

        // 값 입력받기
        stringTokenizer= new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        /// 투포인터 활용

        // 내림차순 정렬하기
        Arrays.sort(arr);

        int count = 0;
        /// while 바탕의 투포인터 작성
        /// 배열은
        /// 1 2 3 4 5 6 7 8 9 10
        for (int i = 0; i < n; i++) {

            int k = arr[i];

            // 왼쪽 포인터
            int L = 0;

            // 우측 포인터
            int R = n - 1;

            /// 투포인터 가동
            while (L < R) {

                if (L == i) {
                    L++;
                    continue;
                }
                if (R == i) {
                    R--;
                    continue;
                }


                int sum = arr[L] + arr[R];

                if (sum == k) {
                    count++;
                    break;
                } else if (sum < k) {
                    L++;
                } else {
                    R--;
                }

            }
        }
        System.out.println(count);
    }
}
