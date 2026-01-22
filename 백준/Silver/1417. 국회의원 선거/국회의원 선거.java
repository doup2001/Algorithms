import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1417 국회의원 선거
 * 문제 개요
 * 기호 1번인 다솜이가 매수를 통해, 국회의원에 당선되어야함
 * 몇 명의 사람을 최소로 매수해야하는지 출력
 *
 * 입력
 * - 후보의 수 N
 * - 차례대로 1번 뽑은 인원 수, 2번을 뽑는 인원 수, 3번을 뽑는 인원 수 ... N번을 뽑는 인원 수
 * 출력
 * - 다솜이가 매수해야하는 사람의 최솟값을 출력
 */
public class Main {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[] arr = null;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

	// 매수할 인원의 수
	static int result = 0;

	/// 메인
	public static void main(String[] args) throws IOException {

		/// 입력
		input();

		/// 계산

		// N 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];

		// N후보들에 대한 입력 값 넣기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());

			// 우선순윈 큐에 넣기
			if (i>0){
				pq.offer(arr[i]);
			}
		}

		// 우선순위 큐에서 최대값 추출
		Integer max = pq.peek();

		// 우선순위 큐의 최상단이 다솜이 아니라면 값 하나를 빼기
		while (max != null && max >= arr[0]) {

			// 매수 인원 추가
			result++;

			// 빼었던 최대값의 사이즈를 하나 줄여서 반영
			Integer poll = pq.poll();
			Integer newPerson = poll - 1;
			pq.offer(newPerson);

			// 다솜 투표인원 추가
			arr[0] = arr[0] + 1;

			max = pq.peek();
		}

		/// 출력
		bw.write(result + "");
		bw.flush();
		bw.close();
	}

	/// 입력값
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

	}
}
