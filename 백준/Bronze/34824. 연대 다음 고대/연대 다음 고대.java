import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 연대 다음 고대
 * 문제 개요 :
 *
 *
 * 입력 : N개의 대학 참여
 * 대학 이름 한 줄씩 입력
 *
 * 출력 :
 * 연세대가 고려대보다 높다면 Yonsei Won!
 * 연세대가 고려대보다 낮으면 Yonsei Lost...
 *
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static String[] arr = new String[2];
 	public static void main(String[] args) throws IOException {

		/// 입력
		// 참여대학의 수
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			// 대학의 종류 확인 및 배열에 추가
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			// 마지막에 들어온 고려대/연세대만 체크하면 된다.
			if (s.equals("korea") || s.equals("yonsei")) {
				arr[0] = s;
			}
		}

		if (arr[0].equals("yonsei")) {
			bw.write("Yonsei Lost...");
		} else {
			bw.write("Yonsei Won!");
		}


		/// 출력
		bw.flush();
		bw.close();

	}

}


