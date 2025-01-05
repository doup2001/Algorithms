import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 바구니 갯수
        Integer[] numbers = new Integer[N]; // 배열 제작

        for (int i = 0; i < numbers.length; i++) {
            int M = sc.nextInt();

            for (int j = 0; j < 1; j++) {
                numbers[i] = M;
            }
        }

        Arrays.sort(numbers);


        for (int number:numbers) {
            System.out.println(number);
        }
    }
}
