import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // N 바이트 정수 갯수

        int[] number1 = new int[N]; // 배열 생성

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt(); // 값 입력
            number1[i] = input;
        }

        int output = sc.nextInt(); // 찾기 위하여 입력할 값

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (number1[i]==output) {
                count++; }
            }
        System.out.println(count);
    }
 }