import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제 개요
 * - RPG 게임에는 레벨이 존재
 * - 각 레벨이 속한 구간의 번호를 출력
 * 입력
 * - N개의 개수와 M의 레벨
 * 출력
 * - 각 레벨의 구간 번호
 */
public class Main {

	/// 전역 변수
	static BufferedReader br = null;
	static BufferedWriter bw = null;
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {

		/// 입력
		input();

		/// 계산
		// N 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		// M 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			// 초기 값 (매번 초기화)
			int result = 0;

			// 레벨 값
			int a = Integer.parseInt(st.nextToken());

			// 값 분기 처리
			if (a >= 300) {
				result = 1;
			} else if (a >= 275) {
				result = 2;
			} else if (a >= 250) {
				result = 3;
			} else {
				result = 4;
			}

			/// 출력
			bw.write(result + " ");
		}

		/// 종료
		bw.flush();
		bw.close();
	}

	/// 값 설정
	private static void input() {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}


}
