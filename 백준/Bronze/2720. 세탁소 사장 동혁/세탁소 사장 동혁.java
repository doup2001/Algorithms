import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int a =Integer.parseInt(br.readLine());

            // 분리된 문자열 출력
            for (int j = 0; j < a; j++){
                int count = Integer.parseInt(br.readLine());

                int Quarter = count / 25;
                int QuarterRemain = count % 25;

                int Dime = QuarterRemain / 10;
                int DimeRemain = QuarterRemain % 10;

                int Nickel = DimeRemain / 5;

                int Penny = DimeRemain % 5;

                System.out.print(Quarter +" ");
                System.out.print(Dime +" ");
                System.out.print(Nickel +" ");
                System.out.print(Penny);
                System.out.println();

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
