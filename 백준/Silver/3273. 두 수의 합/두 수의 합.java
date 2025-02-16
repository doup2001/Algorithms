import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // N 입력 받기
        int[] arr = new int[100000];

        // 수열 값 받기
        String[] input = br.readLine().split(" ");

        // X 입력 받기
        int X = Integer.parseInt(br.readLine());
        int cnt = 0;

        boolean[] exist = new boolean[1000001];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            exist[arr[i]] = true;
        }

        for (int i = 0; i < N; i++) {
            int pairValue = X - arr[i];
            if (1 <= pairValue  && pairValue <= 1000000){
                cnt += exist[pairValue] ? 1 : 0;
            }
        }

        bw.write(cnt / 2 + "\n");
        bw.flush();

    }

}
