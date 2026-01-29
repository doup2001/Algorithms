import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * K512컵 개최
 * 문제 개요: 행운 수치를 적절한 순서로 모두 소모하여 행운 수치를 최대화
 *
 * 입력 : N, M장의 주문서
 * 계산 : N 주문서 -> 행운 수치에서 더함
 * 		 M 주문서 -> 행운 수치에서 곱함
 * 		 P라고 하면 P+a1 , Pxb1
 * 출력 :
 *
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[] arrN = new int[12];
	static int[] arrM = new int[12];
	static long result = 0;

	public static void main(String[] args) throws IOException {

		/// 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		/// 계산
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());

			/// 다 더하고
			result = result + arrN[i];
		}

		// M 배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());

			/// 0빼고 다 곱합
			if (arrM[i] != 0) {
				result = result * arrM[i];
			}
		}

		/// 출력
		bw.write(result + "\n");
		bw.flush();
		bw.close();

	}
}
