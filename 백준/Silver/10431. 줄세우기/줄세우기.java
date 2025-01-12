import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 스캐너 입력

        int N = sc.nextInt(); // 테스트 케이스 값 입력

        // 값 입력
        for(int t = 0; t < N; t++){

            int T = sc.nextInt(); // 테스트 케이스 번호
            int[] arr = new int[20]; // 학생 키 배열

            for (int i = 0; i < 20; i++) {
                arr[i] = sc.nextInt();
            }

            int steps = 0; // 뒤로 물러난 걸음 수

            for(int j = 0; j < 20; j++){
                for (int k = 0; k <= j; k++) {
                    if (arr[k] > arr[j]) {
                        steps ++;
                    }
                }
            }
            System.out.println(T + " " + steps);
        }

    }
}
