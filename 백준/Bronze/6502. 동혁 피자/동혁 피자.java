import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 6502번 동혁 피자 문제
 * - 식탁은 원이고 피자는 직사각형이다.
 * 반지름과 피자의 크기가 주어질 때, 피자가 식탁에 맞는지 체크하는 프로그램
 * - 입력
 * r 식탁의 반지름,w 피자의 너비 ,l 피자의 높이
 * 0 입력시 종료 => while 문
 * - 출력
 * 피자가 놓여질 수 있는지 체크
 * boolean으로 체크해두기?
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int index = 1;
	public static void main(String[] args) throws IOException {

		while (true) {

			/// 입력
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()); // 식탁 반지름

			// 0이면 종료
			if (r == 0) {
				break;
			}
			int w = Integer.parseInt(st.nextToken()); // 피자 너비
			int l = Integer.parseInt(st.nextToken()); // 피자 높이

			/// 계산
			// 식탁 안에 피자가 들어오는지 체크하기
			// 대각선으로 생각해보기
			// 지름
			int hr = 2 * r;

			// 면적
			if ((w * w + l * l) <= hr * hr) {
				
				bw.write("Pizza " + index + " fits on the table." + "\n");
			} else {
				bw.write("Pizza " + index + " does not fit on the table." + "\n");
			}
			index++;
		}

		/// 출력
		bw.flush();
		bw.close();

	}
}
