
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        /// 입력 받기
        /// 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        /// N,M 입력
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arrA = new int[n];
        int[] arrB = new int[m];

        /// 정렬은 이미 진행되어있다고 가정.

        List<Integer> list = new ArrayList<>();

        /// A 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
            list.add(arrA[i]);
        }

        /// B 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
            list.add(arrB[i]);
        }

        /// 정렬
        Collections.sort(list);

        /// 출력
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + " ");
        }

        bw.flush();
        bw.close();



    }
}
