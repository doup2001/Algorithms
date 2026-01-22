import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        // scanner
        /*

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N 바이트 정수

        */
        // 값 입력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st; //StringTokenizer인자값에 입력 문자열 넣음


        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write( String.valueOf(( Integer.parseInt( st.nextToken() ) ) + ( Integer.parseInt( st.nextToken() ) ) ));
            bw.newLine();
        }
        bw.flush();
        bw.close();


    }
}