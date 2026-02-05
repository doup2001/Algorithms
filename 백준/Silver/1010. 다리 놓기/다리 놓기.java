import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제 개요
 * - 다리 N개의 개수는 꼭 지어야함.
 * 입력
 * -
 * 출력
 * -

 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static long[][] arr = new long[31][31];
	static long result = 0;

	public static void main(String[] args) throws Exception {

		/// 초기 설정
		for (int i = 0; i < 31; i++) {
			for (int j = 0; j <= i; j++) {

				// m,n =0 이라면
				if ((j == 0) || (i == j)) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}
		}

		/// 입력
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		// for문 작동
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			/// 계산
			// C(m,n) -> C(m-1,n-1) + C(m-1,n)
			result = arr[m][n];

			/// 출력
			bw.write(result + "\n");
		}

		/// 출력
		bw.flush();
		bw.close();
	}
}
