import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while (N-- > 0) {
            int sum = 0;
            int min = 101;

            for (int i = 0; i < 7; i++) {
                int x = sc.nextInt();
                if( x % 2 == 0 ) {
                    sum += x;
                    min = Math.min(min, x);
                }
            }

            System.out.println(sum + " "+ min);

        }


    }
}
