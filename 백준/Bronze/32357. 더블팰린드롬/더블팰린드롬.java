import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제 개요
 * - 32357
 * - 팰린드롬 문자열 조사함.
 * 입력
 * - N개의 서로 다른 문자열에서 2개만 골라서 더블팰린드롬 현상을 만드는 것
 * 출력
 * -
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int result = 0;
	static int palindromeCount = 0;
	public static void main(String[] args) throws IOException {

		/// 입력
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (isPalindrome(s)) {
				palindromeCount++;
			}
		}

		// 결과: 팰린드롬인 것들 중에서 2개를 순서 있게 뽑는 경우의 수
		long result = palindromeCount * (palindromeCount - 1);

		/// 출력
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}

	// 팰린드롬 확인 함수 (StringBuilder보다 인덱스 비교가 빠름)
	private static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}
}
