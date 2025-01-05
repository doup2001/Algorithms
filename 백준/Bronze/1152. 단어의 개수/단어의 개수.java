import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        ArrayList<String> str = new ArrayList<>();
        int i = 0;

        while(st.hasMoreTokens()) {
            str.add(st.nextToken()) ;
            i++;
        }

        System.out.println(i);

        /*
        The Curious Case of Benjamin Button
        */
    }
}
