import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();

        /*

        10 시 10분 = 10 * 60 + 10 - 45 = 565

        계산 방법
        (((H * 60) + M) -45 ) / 6 = H
        h = 10 / m = 10
        600 + 10 - 45 = 565

        565 / 60 = H
        565 % 60 = M

        */

        if (H == 0) {
            H = 24;
        }

        int hour = (((H * 60) + M) - 45 ); // 분을 기준으로 총 시간을 구한 뒤 시간을 60으로 나눠서 계산
        H = hour / 60;
        M = hour % 60;

        if (H>=24 || H < 0){
            H = H % 24;
        }

        System.out.println( H + " " + M );
    }
}