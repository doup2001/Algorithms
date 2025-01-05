import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 시간복잡도 : 1억번 = 1초
    // 최악의 경우를 생각하면 불가능
    // 배열은 Fix되어있음.
    // 합배열을 이용한 구간합을 이용해야함.

    //  S[i] = S[i-1] + A[i]

    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =
                new StringTokenizer(br.readLine()); //StringTokenizer인자값에 입력 문자열 넣음

        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[]S = new long[suNo + 1 ]; // +1을 한 이유는 0번째 인덱스를 무시하고자 하기에.
        for (int i = 1; i <= suNo; i++) { //1부터 시작하는 이유는 0번째 인덱스를 무시하고자 하기때문임.
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }
        for (int q = 0; q < quizNo; q++) {
            st =
                    new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            System.out.println(S[J]-S[I-1]);
        }
    }

}